package handler.service;

import handler.event.CustomFirstEvent;
import handler.event.CustomSecondEvent;
import handler.event.type.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Created by tatiana.biliaieva on 5/6/2016.
 */
@Component
public class EventService {
  @Autowired
  private ApplicationEventPublisher publisher;

  public void publishEvent(EventType eventType) {
    switch (eventType) {
      case FIRST:
        publisher.publishEvent(new CustomFirstEvent());
        break;
      case SECOND:
        publisher.publishEvent(new CustomSecondEvent());
        break;
      default:
        publisher.publishEvent(new CustomFirstEvent());
        break;
    }
  }
}
