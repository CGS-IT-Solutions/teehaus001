package at.cgsit.training.firstexample.services;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class DevChatMessageServiceTest {

    @Autowired
    private ChatMessageService chatMessageService;

    @Test
    public void testDummyService() {
        ChatMessage msg = chatMessageService.getById(1L);
        assertThat(msg).isNull();
    }

    @Configuration
    public static class ContextConfiguration {
        Logger logger = LoggerFactory.getLogger(DevChatMessageServiceTest.class);
        @Bean
        public ChatMessageService devChatMessageService() {
            logger.info("chatMessageService bean constructor callback");
            return new DevChatMessageServiceImpl();
        }
    }
}
