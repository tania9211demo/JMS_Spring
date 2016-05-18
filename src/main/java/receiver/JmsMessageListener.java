package receiver;

import handler.event.CustomFirstEvent;
import handler.event.CustomSecondEvent;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.jms.*;

/**
 * Created by tatiana.biliaieva on 5/16/2016.
 */
@Service
public class JmsMessageListener implements MessageListener {
  private static final Logger logger = LoggerFactory
      .getLogger(JmsMessageListener.class);
  @Autowired
  private ApplicationEventPublisher applicationEventPublisher;

  @Override
  public void onMessage(Message message) {
    try {
      logger.debug("Receive {}", ((ActiveMQTextMessage) message).getText());
      switch (((ActiveMQTextMessage) message).getText()) {
        case "FIRST":
          applicationEventPublisher.publishEvent(new CustomFirstEvent());
          break;
        case "SECOND":
          applicationEventPublisher.publishEvent(new CustomSecondEvent());
          break;
        default:
          applicationEventPublisher.publishEvent(new CustomFirstEvent());
          break;
      }
    }
    catch (JMSException e) {
      e.printStackTrace();
    }
    logger.debug("JmsMessageListener Receive: " + message);
  }
}
