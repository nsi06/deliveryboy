package com.deliveryboy.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@EmbeddedKafka
class KafkaConfigIntegrationTest {

    @Autowired
    private NewTopic topic;

    @Test
    void testTopicBeanConfiguration() {
        assertThat(topic).isNotNull();
        assertThat(topic.name()).isEqualTo("location-update-topic");
    }
}
