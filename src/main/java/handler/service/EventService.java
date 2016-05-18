package handler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import send.SpringJmsProducer;

/**
 * Created by tatiana.biliaieva on 5/6/2016.
 */
@Component
public class EventService {
  @Autowired
  private SpringJmsProducer springJmsProducer;

  public void publishEvent(String event) {
    springJmsProducer.sendMessage(event);
  }
}
