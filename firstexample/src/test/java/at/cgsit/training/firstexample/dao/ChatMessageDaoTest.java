package at.cgsit.training.firstexample.dao;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.chat.model.MessageType;
import at.cgsit.training.firstexample.repository.ChatMessageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChatMessageDaoTest {

  @Autowired
  private IAbstractJpaDao<ChatMessage> chatMessageDao;

  @Test
  public void testPersistence() {
    //given
    ChatMessage chatMessage = new ChatMessage();
    chatMessage.setSender("john doe");
    chatMessage.setContent("test message");
    chatMessage.setRecipient("frank");
    chatMessage.setType(MessageType.CHAT);

    //when
    //ChatMessage saved =

    chatMessageDao.create(chatMessage);

    // assertThat(chatMessage.getId()).isNotNull();

    ChatMessage newChatMessage1 = chatMessageDao.findOne(chatMessage.getId());

    assertThat( newChatMessage1.getId() ).isGreaterThanOrEqualTo(1L);
  }

}
