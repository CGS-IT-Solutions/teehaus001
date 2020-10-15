package at.cgsit.training.firstexample.services_special;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.services.ChatMessageService;
import at.cgsit.training.firstexample.services_stubs.DevChatMessageServiceImpl;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DevChatMessageServiceWithInterConfigTest {

    @Autowired
    private ChatMessageService devChatMessageService;

    @Test
    public void testDevService() {
        ChatMessage msg = devChatMessageService.getById(1L);
        assertThat(msg).isNull();
    }

    @TestConfiguration
    public static class ChatMessageServiceTestConfiguration {
        Logger logger = LoggerFactory.getLogger(ChatMessageServiceTestConfiguration.class);

        @Bean
        public ChatMessageService devChatMessageService() {
            logger.info("chatMessageService bean constructor callback");
            return new DevChatMessageServiceImpl();
        }

    }

}
