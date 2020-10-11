package at.cgsit.training.firstexample.repository;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ChatMessageRepositoryTest {

  @Autowired
  private ChatMessageRepository chatMessageRepository;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Before
  public void setUp() throws Exception {

  }

  @After
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
    chatMessage.setType(ChatMessage.MessageType.CHAT);

    //when
    ChatMessage saved = chatMessageRepository.save(chatMessage);

    Assert.assertNotNull(chatMessage.getId());

    ChatMessage newChatMessage1 = chatMessageRepository.findById(chatMessage.getId()).orElse(null);
    Assert.assertEquals((Long) 1L, newChatMessage1.getId());
  }


}
