package at.cgsit.training.persistencemodel.components;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest("service.message=Hello")
class TestComponentTest {

  @org.junit.jupiter.api.Test
  void getMessage() {
  }

  @SpringBootApplication
  static class TestConfiguration {
  }

}
