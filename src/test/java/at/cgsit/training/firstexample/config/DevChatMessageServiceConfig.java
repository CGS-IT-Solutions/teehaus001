package at.cgsit.training.firstexample.config;

import at.cgsit.training.firstexample.services.ChatMessageService;
import at.cgsit.training.firstexample.services.DevChatMessageServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("dev")
public class DevChatMessageServiceConfig {
    Logger logger = LoggerFactory.getLogger(DevChatMessageServiceConfig.class);

    @Primary
    @Bean
    public ChatMessageService devChatMessageService() {
        logger.info("chatMessageService bean constructor callback");
        return new DevChatMessageServiceImpl();
    }

}
