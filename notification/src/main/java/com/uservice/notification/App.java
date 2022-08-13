package com.uservice.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Hello world!
 *
 */
@SpringBootApplication(
  scanBasePackages = {
    "com.uservice.notification",
    "com.uservice.amqp"
  }
)
public class App
{
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  // @Bean
  // CommandLineRunner commandLineRunner(
  //     RabbitMQMessageProducer producer,
  //     NotificationConfig notificationConfig) {
  //   return args -> {
  //     producer.publish(
  //         new Person("Ali", 18),
  //         notificationConfig.getInternalExchange(),
  //         notificationConfig.getInternalNotificationRoutingKey());
  //   };
  // }

  // record Person(String name, int age) {
  // }
}
