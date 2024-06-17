package com.luisvalerom.producer.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.luisvalerom.common.model.PageView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProducerService {

    private KafkaTemplate<Object, Object> template;

    @Value(value = "${example.topic.name}")
    private String topicName;

    public ProducerService(KafkaTemplate<Object, Object> template) {
        this.template = template;
    }

    public void SendMessage(PageView msg) {
        CompletableFuture<SendResult<Object, Object>> future = template.send(topicName, msg);
        future.whenCompleteAsync((result, ex) -> {
            if (ex == null) {
                log.info("Sent message=[{}] with offset=[{}]", msg, result.getRecordMetadata().offset());
            } else {
                log.error("Unable to send message=[{}] due to : {}", msg, ex.getMessage());
            }
        });
    }
}
