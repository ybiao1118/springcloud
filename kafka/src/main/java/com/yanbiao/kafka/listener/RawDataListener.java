package com.yanbiao.kafka.listener;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author byan
 * @Description:
 * @date 2021-02-26  下午1:56
 */
@Component
@Slf4j
public class RawDataListener {

  /**
   * 实时获取kafka数据(生产一条，监听生产topic自动消费一条)
   * @param record
   * @throws IOException
   */
  @KafkaListener(topics = {"${kafka.consumer.topic}"})
  public void listen(ConsumerRecord<?, ?> record) {
    String value = (String) record.value();
    String topic = record.topic();
    if("test".equals(topic)){
      log.info("接收到的信息为："+value);
    }

  }

}
