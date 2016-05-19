#Description
Project shows JMS integration with psring using ActiveMQ message brocker.
By this url it is possibe to send message to a ActiveMQ.

**http://localhost:8080/integration-1.0-SNAPSHOT/message/send?message=your_message**

All messages would be handled by receiver.JmsMessageListener class and would publish appropriate event according to received message.

#Build instructions

Just use Maven to build project:

**mvn clean install**

#Technologies, that have been used:

1) JMS api;

2) ActiveMQ message broker;

3) Spting framework;
