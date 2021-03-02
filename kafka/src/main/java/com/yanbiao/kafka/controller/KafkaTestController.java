package com.yanbiao.kafka.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author byan
 * @Description:
 * @date 2021-02-26  下午1:53
 */

@RestController
@RequestMapping("test")
public class KafkaTestController {

  @Autowired
  private KafkaTemplate kafkaTemplate;

  @RequestMapping(value = "/producer")
  public void consume(String msg) throws IOException {
    kafkaTemplate.send("test", msg);
  }
}