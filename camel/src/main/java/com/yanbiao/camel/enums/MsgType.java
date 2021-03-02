package com.yanbiao.camel.enums;

public enum MsgType {
  TEST("test","这是一个测试队列");

  private String type;

  private String des;

  private MsgType(String type,String des){
    this.type=type;
    this.des=des;
  }

  public String getType() {
    return type;
  }
}
