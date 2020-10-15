package at.cgsit.training.firstexample.config;

import at.cgsit.training.firstexample.services.ChatMessageService;
import at.cgsit.training.firstexample.services_stubs.DevChatMessageServiceStubImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
//@Profile("dev")
public class TestChatMessageServiceConfiguration {
    Logger logger = LoggerFactory.getLogger(TestChatMessageServiceConfiguration.class);

    @Bean
    public ChatMessageService devChatMessageService() {
        logger.info("chatMessageService bean constructor callback");
        return new DevChatMessageServiceStubImpl();
    }

}
