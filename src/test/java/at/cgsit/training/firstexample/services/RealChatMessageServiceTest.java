package at.cgsit.training.firstexample.services;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RealChatMessageServiceTest {

    @Autowired
    private ChatMessageService chatMessageService;

    @Test
    public void testRealService() {
        ChatMessage msg = chatMessageService.getById(1L);
        assertThat(msg).isNotNull();
        assertThat(msg.getSender()).isEqualTo("johnDoe");
    }

}
