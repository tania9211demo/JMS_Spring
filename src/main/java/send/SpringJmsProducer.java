package send;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by tatiana.biliaieva on 4/29/2016.
 */
@Component
public class SpringJmsProducer {
  private static final Logger logger = LoggerFactory
      .getLogger(SpringJmsProducer.class);

  @Autowired
  private JmsTemplate jmsTemplate;
  @Autowired
  private Destination destination;

  public JmsTemplate getJmsTemplate() {
    return jmsTemplate;
  }

  public void setJmsTemplate(JmsTemplate jmsTemplate) {
    this.jmsTemplate = jmsTemplate;
  }

  public Destination getDestination() {
    return destination;
  }

  public void setDestination(Destination destination) {
    this.destination = destination;
  }

  public void sendMessage(final String msg) throws JmsException {
    logger.debug("Send {}", msg);
    final MessageCreator messageCreator = new MessageCreator() {
      public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage(msg);
      }
    };

    jmsTemplate.send(destination, messageCreator);
  }
}
