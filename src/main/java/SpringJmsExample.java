import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import producer.SpringJmsProducer;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by tatiana.biliaieva on 4/29/2016.
 */
public class SpringJmsExample {

  public static void main(String[] args) throws URISyntaxException, Exception {
  //  BrokerService brokerService = BrokerFactory.createBroker(new URI(
  //      "broker:(tcp://localhost:61616)"));
  //  brokerService.start();
  //  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
  }
}
