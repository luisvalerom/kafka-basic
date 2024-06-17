package com.luisvalerom.producer.config;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.luisvalerom.common.utils.PageViewUtil;
import com.luisvalerom.producer.services.ProducerService;

@Configuration
public class KafkaRunnerConfig {

    @Bean
    ApplicationListener<ApplicationReadyEvent> runner(ProducerService service) {
        return event -> Executors.newScheduledThreadPool(1).schedule(() -> {
            for (int i = 0; i < 100; i++) {
                var pageView = PageViewUtil.getPageView();
                service.SendMessage(pageView);
            }
        }, 5, TimeUnit.SECONDS);
    }
}
