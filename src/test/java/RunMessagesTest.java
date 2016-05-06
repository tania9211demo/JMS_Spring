import config.ApplicationConfig;
import consumer.SpringJmsConsumer;
import handler.event.type.EventType;
import handler.service.EventService;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import producer.SpringJmsProducer;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by tatiana.biliaieva on 4/29/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class RunMessagesTest {
  @Autowired
  private SpringJmsProducer springJmsProducer;
  @Autowired
  private SpringJmsConsumer springJmsConsumer;
  @Autowired
  private EventService eventService;

  @Test
  public void run() throws Exception {
    BrokerService brokerService = BrokerFactory.createBroker(new URI(
        "broker:(tcp://localhost:61616)"));
    brokerService.start();
    springJmsProducer.sendMessage("Hi");
    System.out.print("Message " + springJmsConsumer.receiveMessage());
  }

  @Test
  public void listenEvent() {
    eventService.publishEvent(EventType.FIRST);
  }
}
