package com.deliveryboy.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class KafkaServiceTest {

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @InjectMocks
    private KafkaService kafkaService;

    @Test
    void should_send_location_to_correct_topic() {
        String testLocation = "(45, 90)";
        String expectedTopic = "location-update-topic";

        kafkaService.updateLocation(testLocation);

        verify(kafkaTemplate, times(1)).send(eq(expectedTopic), eq(testLocation));
    }
}
