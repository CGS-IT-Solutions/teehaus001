package at.cgsit.training.firstexample.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ChatMessageDTO {

  private Long id;

  private MessageType type;

  private String content;

  private String sender;

  private String recipient;

  public enum MessageType {
    CHAT,
    PRIVATE,
    JOIN,
    LEAVE;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public MessageType getType() {
    return type;
  }

  public ChatMessageDTO setType(MessageType type) {
    this.type = type;
    return this;
  }

  public String getContent() {
    return content;
  }

  public ChatMessageDTO setContent(String content) {
    this.content = content;
    return this;
  }

  public String getSender() {
    return sender;
  }

  public ChatMessageDTO setSender(String sender) {
    this.sender = sender;
    return this;
  }

  public String getRecipient() {
    return recipient;
  }

  public ChatMessageDTO setRecipient(String recipient) {
    this.recipient = recipient;
    return this;
  }
}
