package config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.activemq.spring.ActiveMQConnectionFactoryFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;

/**
 * Created by tatiana.biliaieva on 4/29/2016.
 */
@Configuration
@ComponentScan(basePackages = {"producer", "consumer", "handler"})
public class ApplicationConfig {

  @Bean
  public JmsTemplate getJmsTemplate() {
    JmsTemplate jmsTemplate = new JmsTemplate();
    jmsTemplate.setDefaultDestination(getDestination());
    jmsTemplate.setConnectionFactory(getActiveMQConnectionFactory());
    jmsTemplate.setReceiveTimeout(10000);
    return jmsTemplate;
  }

  @Bean
  public ActiveMQConnectionFactory getActiveMQConnectionFactory() {
    ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
    activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
    return activeMQConnectionFactory;
  }

  @Bean
  public Destination getDestination() {
    Destination destination = new ActiveMQQueue("jms.queue");
    return  destination;
  }
}
