package com.deliveryboy.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void updateLocation(String location) {
         this.kafkaTemplate.send("location-update-topic", location);
         this.logger.info("message sent to kafka topic location-update-topic: " + location);
    }
}
