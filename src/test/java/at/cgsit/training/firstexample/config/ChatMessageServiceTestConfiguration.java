package at.cgsit.training.firstexample.config;

import at.cgsit.training.firstexample.services.ChatMessageService;
import at.cgsit.training.firstexample.services.DevChatMessageServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ChatMessageServiceTestConfiguration {
    Logger logger = LoggerFactory.getLogger(ChatMessageServiceTestConfiguration.class);

    @Bean
    public ChatMessageService devChatMessageService() {
        logger.info("chatMessageService bean constructor callback");
        return new DevChatMessageServiceImpl();
    }

}
