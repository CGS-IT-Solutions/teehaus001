package at.cgsit.training.firstexample.config;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.repository.ChatMessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  public CommandLineRunner initDatabase(ChatMessageRepository repository) {

    ChatMessage chatMessage = new ChatMessage();
    chatMessage.setSender("johnDoe");
    chatMessage.setContent("test");
    chatMessage.setRecipient("franky");

    return args -> {
      log.info("Preloading " + repository.save(chatMessage));
    };
  }
}

