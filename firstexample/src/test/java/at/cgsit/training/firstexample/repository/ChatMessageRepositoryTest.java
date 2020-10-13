package at.cgsit.training.firstexample.repository;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.chat.model.MessageType;
import at.cgsit.training.firstexample.config.StandardChatMessageServiceConfig;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.test.jdbc.JdbcTestUtils;


// @DataJpaTest
@SpringBootTest
// @ExtendWith()
public class ChatMessageRepositoryTest {

  @Autowired
  private ChatMessageRepository chatMessageRepository;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @BeforeEach
  public void tearDown() {
    JdbcTestUtils.deleteFromTables(jdbcTemplate, "chat_message");
  }

  @Test
  public void testPersistence() {
    //given
    ChatMessage chatMessage = new ChatMessage();
    chatMessage.setSender("john doe");
    chatMessage.setContent("test message");
    chatMessage.setRecipient("frank");
    chatMessage.setType(MessageType.CHAT);

    //when
    ChatMessage saved = chatMessageRepository.save(chatMessage);

    assertThat(chatMessage.getId()).isNotNull();

    ChatMessage newChatMessage1 = chatMessageRepository.findById(chatMessage.getId()).orElse(null);
    assertThat( newChatMessage1.getId() ).isGreaterThanOrEqualTo(1L);
  }


}
