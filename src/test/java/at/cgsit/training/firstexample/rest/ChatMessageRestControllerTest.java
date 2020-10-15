package at.cgsit.training.firstexample.rest;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.config.TestChatMessageServiceConfiguration;
import at.cgsit.training.firstexample.config.TestWebSecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import( {TestWebSecurityConfig.class, TestChatMessageServiceConfiguration.class })
class ChatMessageRestControllerTest {

  @Autowired
  private ChatMessageRestController controller;

  @Test
  public void testPersistence() {

    List<ChatMessage> msg = controller.findBySender("chris");
    assertThat(msg).isNotNull();

  }


}
