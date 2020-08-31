package org.yangxin.kafka.producer.producer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author yangxin
 * 2020/08/31 14:50
 */
@SpringBootTest
class KafkaProducerServiceTest {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Test
    void sendMessage() throws InterruptedException {
        String topic = "topic02";
        for (int i = 0; i < 1000; i++) {
            kafkaProducerService.sendMessage(topic, "hello kafka" + i);
            Thread.sleep(5);
        }

        Thread.sleep(Integer.MAX_VALUE);
    }
}