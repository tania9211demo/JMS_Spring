package handler.listener;

import handler.event.CustomFirstEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by tatiana.biliaieva on 5/6/2016.
 */
@Component
public class CustomFirstEventListener {

  @EventListener
  public void processEvent(CustomFirstEvent customFirstEvent) {
    System.out.println("process CustomFirstEvent");
  }
}
