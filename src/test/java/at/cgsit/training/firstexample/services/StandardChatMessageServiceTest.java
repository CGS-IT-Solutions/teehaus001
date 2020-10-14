package at.cgsit.training.firstexample.services;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StandardChatMessageServiceTest {

    @Autowired
    private ChatMessageService chatMessageService;

    @Test
    public void testRealService() {
        ChatMessage msg = chatMessageService.getById(1L);
        assertThat(msg).isNotNull();
        assertThat(msg.getSender()).isEqualTo("johnDoe");
    }

}
