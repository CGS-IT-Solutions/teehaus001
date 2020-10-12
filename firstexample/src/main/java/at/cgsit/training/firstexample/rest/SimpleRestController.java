package at.cgsit.training.firstexample.rest;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.exceptions.ChatMessageNotFoundException;
import at.cgsit.training.firstexample.properties.PropertiesSample;
import at.cgsit.training.firstexample.properties.SingletonPropertyExample;
import at.cgsit.training.firstexample.services.ChatMessageServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simplerest")
public class SimpleRestController {

  Logger logger = LoggerFactory.getLogger(SimpleRestController.class);

  @Autowired
  private PropertiesSample propertiesSample;

  @Autowired
  private SingletonPropertyExample singletonPropertyExample;


  @GetMapping("/properties/{property}")
  String getProperty(@PathVariable String property) {
    logger.info("getProperty /properties called with value {}", property);
    logger.info("Working Directory = " + System.getProperty("user.dir"));
    return propertiesSample.getMyValue();
  }

  @GetMapping("/properties2/{property}")
  String getPropertySingleton(@PathVariable String property) {
    logger.info("getProperty /properties called with value {}", property);
    logger.info("Working Directory = " + System.getProperty("user.dir"));
    return this.singletonPropertyExample.getMessage();
  }


}
