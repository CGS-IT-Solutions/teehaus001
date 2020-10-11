package at.cgsit.training.firstexample.repository;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {

}
