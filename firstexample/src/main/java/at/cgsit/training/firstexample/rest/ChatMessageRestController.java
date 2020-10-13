package at.cgsit.training.firstexample.rest;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.exceptions.ChatMessageNotFoundException;
import at.cgsit.training.firstexample.repository.ChatMessageRepository;
import at.cgsit.training.firstexample.services.ChatMessageService;
import at.cgsit.training.firstexample.translator.ChatMessageToChatMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
@Secured("USER")
public class ChatMessageRestController {

  private ChatMessageService chatMessageService;

  private ChatMessageToChatMessageDTO cmToCMDTO;

  private ChatMessageRepository repository;

  @Autowired
  public void setRepository(ChatMessageRepository repository) {
    this.repository = repository;
  }

  @Autowired
  public void setCmToCMDTO(ChatMessageToChatMessageDTO cmToCMDTO) {
    this.cmToCMDTO = cmToCMDTO;
  }

  @Autowired
  public void setChatMessageService(ChatMessageService chatMessageService) {
    this.chatMessageService = chatMessageService;
  }


  @GetMapping("/chatmessages")
  public List<ChatMessage> all() {
    return chatMessageService.listAll();
  }

  @GetMapping("/chatmessages/findBySender/{sender}")
  public List<ChatMessage> findBySender(@PathVariable String sender) {
    return chatMessageService.findBySender(sender);
  }


  @PostMapping("/chatmessages")
  ChatMessage newEmployee(@RequestBody ChatMessage chatMessage) {
    return repository.save(chatMessage);
  }

  // Single item

  @GetMapping("/chatmessages/{id}")
  ChatMessage one(@PathVariable Long id) {

    return repository.findById(id)
        .orElseThrow(() -> new ChatMessageNotFoundException(id));
  }

  @PutMapping("/chatmessages/{id}")
  ChatMessage replaceEmployee(@RequestBody ChatMessage chatMessage, @PathVariable Long id) {

    return repository.findById(id)
        .map(foundCM -> {
          foundCM.setSender(chatMessage.getSender());
          foundCM.setContent(chatMessage.getContent());
          foundCM.setRecipient(chatMessage.getRecipient());
          return repository.save(foundCM);
        })
        .orElseGet(() -> {
          chatMessage.setId(id);
          return repository.save(chatMessage);
        });
  }

  @DeleteMapping("/chatmessagess/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }



}
