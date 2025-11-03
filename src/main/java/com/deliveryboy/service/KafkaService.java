package com.deliveryboy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean updateLocation(String location) {
         this.kafkaTemplate.send("location-update-topic", location);
         this.logger.info("message sent to kafka topic location-update-topic: " + location);
         return true;
    }
}
