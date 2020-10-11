package at.cgsit.training.firstexample.services;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ChatMessageServiceImpl implements ChatMessageService {

  private ChatMessageRepository chatMessageRepository;

  @Autowired
  public ChatMessageServiceImpl(ChatMessageRepository chatMessageRepository) {
    this.chatMessageRepository = chatMessageRepository;
  }


  @Override
  public List<ChatMessage> listAll() {
    List<ChatMessage> messages = new ArrayList<>();
    chatMessageRepository.findAll().forEach(messages::add);
    return messages;
  }

  @Override
  public ChatMessage getById(Long id) {
    return chatMessageRepository.findById(id).orElse(null);
  }

  @Override
  public ChatMessage saveOrUpdate(ChatMessage product) {
    chatMessageRepository.save(product);
    return product;
  }

  @Override
  public void delete(Long id) {
    chatMessageRepository.deleteById(id);

  }

  /*
  @Override
  public ChatMessage saveOrUpdateProductForm(ProductForm productForm) {
    Product savedProduct = saveOrUpdate(productFormToProduct.convert(productForm));

    System.out.println("Saved Product Id: " + savedProduct.getId());
    return savedProduct;
  }
   */
}
