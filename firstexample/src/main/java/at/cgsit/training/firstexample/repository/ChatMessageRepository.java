package at.cgsit.training.firstexample.repository;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 *
 */
public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {

  List<ChatMessage> findBySender(String sender);

  @Query( value = "SELECT msg FROM ChatMessage msg WHERE msg.sender LIKE :sender")
  ChatMessage findByXYZ( @Param("sender") String sender);

}
