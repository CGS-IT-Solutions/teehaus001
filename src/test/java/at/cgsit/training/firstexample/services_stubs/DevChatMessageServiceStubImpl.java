package at.cgsit.training.firstexample.services_stubs;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.dto.ChatMessageDTO;
import at.cgsit.training.firstexample.services.ChatMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DevChatMessageServiceStubImpl implements ChatMessageService {

  Logger logger = LoggerFactory.getLogger(DevChatMessageServiceStubImpl.class);

  @Override
  public List<ChatMessage> listAll() {
    logger.info("listall");
    return Collections.emptyList();
  }

  @Override public ChatMessage getById(Long id) {
    logger.info("getById");
    return null;
  }

  @Override public List<ChatMessage> findBySender(String sender) {
    logger.info("findBySender");
    ChatMessage msg = new ChatMessage();
    msg.setSender("dummy");
    msg.setRecipient("dummy");
    msg.setContent("dummy");

    List<ChatMessage> list = new ArrayList<>();
    list.add(msg);

    return list;
  }

  @Override public ChatMessage saveOrUpdate(ChatMessage chatMessage) {
    logger.info("saveOrUpdate");
    return null;
  }

  @Override public void delete(Long id) {
    logger.info("delete");
  }

  @Override public ChatMessage saveOrUpdateChatMessageDTO(ChatMessageDTO cmDTO) {
    logger.info("delete");
    return null;
  }

}
