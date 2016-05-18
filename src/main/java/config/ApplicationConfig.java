package config;

import receiver.JmsMessageListener;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.jms.Destination;

/**
 * Created by tatiana.biliaieva on 4/29/2016.
 */
@ComponentScan(basePackages = {"send", "receiver", "handler", "controller", "publish"})
@Configuration
@EnableWebMvc
@EnableJms
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

  @Bean
  public JmsMessageListener getJmsMessageListener() {
    JmsMessageListener jmsMessageListener = new JmsMessageListener();

    return jmsMessageListener;
  }

  @Bean
  public DefaultMessageListenerContainer getDefaultMessageListenerContainer() {
    DefaultMessageListenerContainer defaultMessageListenerContainer = new DefaultMessageListenerContainer();
    defaultMessageListenerContainer.setConnectionFactory(getActiveMQConnectionFactory());
    defaultMessageListenerContainer.setDestination(getDestination());
    defaultMessageListenerContainer.setMessageListener(getJmsMessageListener());

    return defaultMessageListenerContainer;
  }
}
