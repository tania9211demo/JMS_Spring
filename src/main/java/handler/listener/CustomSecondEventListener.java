package handler.listener;

import handler.event.CustomSecondEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by tatiana.biliaieva on 5/6/2016.
 */
@Component
public class CustomSecondEventListener {

  @EventListener
  public void processEvent(CustomSecondEvent customSecondEvent) {
    System.out.println("process CustomSecondEvent");
  }
}
