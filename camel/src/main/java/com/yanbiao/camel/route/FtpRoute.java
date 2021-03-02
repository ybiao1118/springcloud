package com.yanbiao.camel.route;

import com.yanbiao.camel.processor.DataProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author byan
 * @Description:
 * @date 2021-02-04  下午2:33
 */
@Component
public class FtpRoute extends RouteBuilder {

  @Value("${ftp.address}")
  private String address;

  @Value("${ftp.username}")
  private String username;

  @Value("${ftp.password}")
  private String password;

  @Value("${ftp.url}")
  private String url;

  @Value("${ftp.options}")
  private String options;

  @Autowired
  private DataProcessor dataProcessor;


  @Override
  public void configure()  {
      from(getFromUrl()).process(dataProcessor).end()
          .to("direct:all");
  }

  private String getFromUrl(){
    StringBuilder sb=new StringBuilder();
    sb.append("ftp://")
        .append(username)
        .append("@")
        .append(address)
        .append(url)
        .append("?")
        .append("password=")
        .append(password)
        .append("&")
        .append(options);
    System.out.println("请求地址:"+sb.toString());
    return sb.toString();
  }

}
