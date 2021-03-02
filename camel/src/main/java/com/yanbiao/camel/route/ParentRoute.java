package com.yanbiao.camel.route;

import com.yanbiao.camel.enums.MsgType;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author byan
 * @Description:
 * @date 2021-02-04  下午3:09
 */
@Component
public class ParentRoute extends RouteBuilder {

  @Override
  public void configure()  {
    from("direct:all").threads(10,20)
        .to("direct:test")
        .end();

    from("direct:test")
        .process(exchange -> isGo(exchange,MsgType.TEST))
     .to("kafka:test?brokers=172.26.2.169:9092&autoOffsetReset=earliest");


  }

  private boolean isGo(Exchange exchange, MsgType msgType){
    String type = (String) exchange.getMessage().getHeader("type");
    return msgType.getType().equals(type);
  }
}
