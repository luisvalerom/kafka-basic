package com.luisvalerom.consumer.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.luisvalerom.common.model.PageView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConsumerService {

    @Value(value = "${example.topic.groupId}")
    private String groupId;

    @KafkaListener(topics = "${example.topic.name}", groupId = "${example.topic.groupId}")
    public void listenMessages(@Payload PageView msg,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
        log.info("Received Message in group {}: {} from partition: {}", groupId, msg, partition);
    }

}
