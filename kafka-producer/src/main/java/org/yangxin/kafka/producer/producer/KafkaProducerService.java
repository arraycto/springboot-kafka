package org.yangxin.kafka.producer.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author yangxin
 * 2020/08/31 11:01
 */
@Slf4j
@Component
public class KafkaProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, Object object) {
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, object);
        future.addCallback(new ListenableFutureCallback<>() {

            @Override
            public void onSuccess(SendResult<String, Object> sendResult) {
                log.info("发送消息成功：[{}]", sendResult.toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                log.error("发送消息失败：[{}]", throwable.getMessage());
            }
        });
    }
}
