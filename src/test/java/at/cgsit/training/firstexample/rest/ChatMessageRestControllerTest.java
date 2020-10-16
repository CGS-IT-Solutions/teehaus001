package at.cgsit.training.firstexample.rest;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.config.TestChatMessageServiceConfiguration;
import at.cgsit.training.firstexample.config.WebSecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = TestChatMessageServiceConfiguration.class)
class ChatMessageRestControllerTest {

  @Autowired
  private ChatMessageRestController controller;

  @Test
  @WithMockUser(roles = WebSecurityConfig.ROLE_READ)
  public void testPersistence() {
    List<ChatMessage> msg = controller.findBySender("chris");
    assertThat(msg).isNotNull().hasSize(1);
    assertThat(msg.get(0).getSender()).isEqualTo("dummy");
  }

}
