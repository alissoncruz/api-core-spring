package com.api.james.core.apicorejames.service.impl;

import com.api.james.core.apicorejames.ApiCoreJamesApplication;
import com.api.james.core.apicorejames.Receiver;
import com.api.james.core.apicorejames.Repository.ProductRepository;
import com.api.james.core.apicorejames.model.Product;
import com.api.james.core.apicorejames.service.ProductService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.api.james.core.apicorejames.service.utils.ParserJsonUtil.convertObjectToJson;
import static com.api.james.core.apicorejames.service.utils.ParserUtil.convertToJSON;

//import org.springframework.data.redis.core.RedisTemplate;

@Service
public class ProductServiceImpl implements ProductService {
    //@Autowired
    //private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ProductRepository productRepository;

    private final RabbitTemplate rabbitTemplate;

    private final Receiver receiver;

    private final static String ROUTE_KEY = "foo.bar.baz";

    public ProductServiceImpl(RabbitTemplate rabbitTemplate, Receiver receiver) {
        this.rabbitTemplate = rabbitTemplate;
        this.receiver = receiver;
    }

    @Override
    public String createProduct(Product product) {

        Product response = productRepository.save(product);

        String payloadProduct = convertObjectToJson(response);

        try {
            sendNotification(payloadProduct);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response.getId();
    }

    @Override
    public List<Product> findProducts() {
        return productRepository.findAll();
    }


    private void sendNotification(String payload) throws Exception {

        rabbitTemplate.convertAndSend(ApiCoreJamesApplication.topicExchangeName, ROUTE_KEY , payload);

        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);


    }


}
