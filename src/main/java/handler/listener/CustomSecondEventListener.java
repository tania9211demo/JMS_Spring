package handler.listener;

import handler.event.CustomSecondEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by tatiana.biliaieva on 5/6/2016.
 */
@Component
public class CustomSecondEventListener {
  private static final Logger logger = LoggerFactory
      .getLogger(CustomSecondEventListener.class);

  @EventListener
  public void processEvent(CustomSecondEvent customSecondEvent) {
    System.out.println("process befin CustomSecondEvent");
    try {
      Thread.sleep(3000);
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("process end CustomSecondEvent");
  }
}
