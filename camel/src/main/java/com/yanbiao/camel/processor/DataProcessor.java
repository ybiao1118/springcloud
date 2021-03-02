package com.yanbiao.camel.processor;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.remote.RemoteFile;
import org.springframework.stereotype.Component;

/**
 * @author byan
 * @Description:
 * @date 2021-02-04  下午2:58
 */
@Component
public class DataProcessor implements Processor {

  @Override
  public void process(Exchange exchange) throws Exception {
    RemoteFile file = (RemoteFile) exchange.getMessage().getBody();
    byte[] bytes = (byte[]) file.getBody();
 /*   InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(bytes));
    String fileName = file.getFileName();*/
    String s=new String(bytes,"UTF-8");
    System.out.println("获取的数据===="+s);
    exchange.getMessage().setHeader("type","test");
    exchange.getMessage().setBody(s);
  }
}
