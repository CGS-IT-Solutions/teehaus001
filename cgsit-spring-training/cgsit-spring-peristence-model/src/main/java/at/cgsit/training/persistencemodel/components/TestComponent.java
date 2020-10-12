package at.cgsit.training.persistencemodel.components;

import org.springframework.stereotype.Component;

@Component
public class TestComponent {

  private String message;

  public TestComponent() {
    // noop
  }

  public String getMessage() {
    return this.message;
  }

}
