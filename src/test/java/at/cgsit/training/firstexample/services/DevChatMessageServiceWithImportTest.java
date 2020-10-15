package at.cgsit.training.firstexample.services;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.config.TestChatMessageServiceConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(TestChatMessageServiceConfiguration.class)
public class DevChatMessageServiceWithImportTest {

    @Autowired
    private ChatMessageService devChatMessageService;

    @Test
    public void testDevService() {
        ChatMessage msg = devChatMessageService.getById(1L);
        assertThat(msg).isNull();
    }

}
