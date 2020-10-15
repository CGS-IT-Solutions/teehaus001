package at.cgsit.training.firstexample.dao;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.chat.model.MessageType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ComponentScan("at.cgsit.training.firstexample.dao") //
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // nimmt echte konfigurierte db
class ChatMessageDaoTest {

    @Autowired
    private IAbstractJpaDao<ChatMessage> chatMessageDao;

    @Test
    public void testPersistence() {
        //given
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setSender("john doe");
        chatMessage.setContent("test ChatMessageDaoTest");
        chatMessage.setRecipient("frank");
        chatMessage.setType(MessageType.CHAT);

        //when
        //ChatMessage saved =

        chatMessageDao.create(chatMessage);

        // assertThat(chatMessage.getId()).isNotNull();

        ChatMessage newChatMessage1 = chatMessageDao.findOne(chatMessage.getId());

        assertThat(newChatMessage1.getId()).isGreaterThanOrEqualTo(1L);
    }

}
