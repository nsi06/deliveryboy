package com.deliveryboy.controller;


import com.deliveryboy.service.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController {

    private final KafkaService kafkaService;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation() {

        this.kafkaService.updateLocation("(" + Math.round(Math.random() * 100) + "," +  Math.round(Math.random() * 100) + ")");
        return new ResponseEntity<>(Map.of("message", "Location updated successfully"), HttpStatus.OK);
    }
}
