package at.cgsit.training.firstexample.services;


import at.cgsit.training.firstexample.chat.model.ChatMessage;

import java.util.List;

public interface ChatMessageService {

  List<ChatMessage> listAll();

  ChatMessage getById(Long id);

  ChatMessage saveOrUpdate(ChatMessage product);

  void delete(Long id);

  // ChatMessage saveOrUpdateProductForm(ProductForm productForm);

}
