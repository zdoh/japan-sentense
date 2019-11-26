package ru.zdoher.japs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.PollableChannel;

@Configuration
public class MyMessageChannelConfig {

    @Bean
    public PollableChannel sendChannel() {
        return new QueueChannel(100);
    }

    @Bean
    public DirectChannel receiveChannel() {
        return MessageChannels.direct("receiveChannel").get();
    }
}
