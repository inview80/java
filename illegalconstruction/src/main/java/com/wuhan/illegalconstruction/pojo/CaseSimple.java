package com.wuhan.illegalconstruction.pojo;

import lombok.Data;

@Data
/**
 * 案件信息简表
 */
public class CaseSimple {
  private String recordnumber;
  private String address;
  private long discoverway;
  private long aStreet;
  private java.sql.Timestamp recordDate;
  private long region;
  private long matchId;
  private long approvalProgressA;
  private long approvalProgressB;
  private String addrMap;
}
