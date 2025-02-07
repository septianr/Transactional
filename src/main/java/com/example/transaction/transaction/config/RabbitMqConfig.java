package com.example.transaction.transaction.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    @Bean
    public Queue transactionQueue() {

        return new Queue("TransactionQueue", true);
    }
}
