package handler.listener;

import handler.event.CustomFirstEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by tatiana.biliaieva on 5/6/2016.
 */
@Component
public class CustomFirstEventListener {
  private static final Logger logger = LoggerFactory
      .getLogger(CustomFirstEventListener.class);

  @EventListener
  public void processEvent(CustomFirstEvent customFirstEvent) {
    System.out.println("process begin CustomFirstEvent");
    try {
      Thread.sleep(3000);
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("process end CustomFirstEvent");
  }
}
