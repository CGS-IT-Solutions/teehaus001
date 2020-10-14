package at.cgsit.training.firstexample.services;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.dto.ChatMessageDTO;
import at.cgsit.training.firstexample.repository.ChatMessageRepository;
import at.cgsit.training.firstexample.translator.ChatMessageDTOToChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// @Service
// @Transactional
public class DevChatMessageServiceImpl implements ChatMessageService {

  Logger logger = LoggerFactory.getLogger(DevChatMessageServiceImpl.class);

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
    return Collections.EMPTY_LIST;
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
