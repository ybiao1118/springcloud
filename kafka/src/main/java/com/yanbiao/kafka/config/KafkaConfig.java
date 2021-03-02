package com.yanbiao.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

/**
 * @author byan
 * @Description:
 * @date 2021-02-26  下午3:13
 */
@Configuration
public class KafkaConfig {
  @Bean
  public KafkaAdmin admin(KafkaProperties properties){
    KafkaAdmin admin = new KafkaAdmin(properties.buildAdminProperties());
    admin.setFatalIfBrokerNotAvailable(true);
    return admin;
  }
  @Bean
  public NewTopic topic() {
    return new NewTopic("result", 1, (short) 1);
  }
}