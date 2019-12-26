package com.wuhan.illegalconstruction.pojo;


import com.wuhan.illegalconstruction.enums.PowerLevel;
import lombok.Data;

@Data
/**
 * 用户信息表
 */
public class Userinfo {
  private long id;
  private String name;
  private String fullName;
  private PowerLevel powerLevel;
  private String password;
}
