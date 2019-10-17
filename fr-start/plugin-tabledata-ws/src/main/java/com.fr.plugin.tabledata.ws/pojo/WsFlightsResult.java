package com.fr.plugin.tabledata.ws.pojo;

/**
 * @Description: 城市间航班信息
 * @Author: penney
 * @CreateDate: 2019/10/15 13:58
 * @UpdateUser:
 * @UpdateDate: 2019/10/15 13:58
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class WsFlightsResult {
  /**
   * 航空公司
   */
  private String Company;
  /**
   * 航班号
   */
  private String AirlineCode;
  /**
   * 出发机场
   */
  private String StartDrome;
  /**
   * 到达机场
   */
  private String ArriveDrome;
  /**
   * 出发时间
   */
  private String StartTime;
  /**
   * 到达时间
   */
  private String ArriveTime;
  /**
   * 机型
   */
  private String Mode;
  /**
   * 经停
   */
  private String AirlineStop;
  /**
   * 飞行周期（星期）
   */
  private String Week;


  public WsFlightsResult(String company, String airlineCode, String startDrome, String arriveDrome, String startTime, String arriveTime, String mode, String airlineStop, String week) {
    Company = company;
    AirlineCode = airlineCode;
    StartDrome = startDrome;
    ArriveDrome = arriveDrome;
    StartTime = startTime;
    ArriveTime = arriveTime;
    Mode = mode;
    AirlineStop = airlineStop;
    Week = week;
  }

  public WsFlightsResult() {
  }

  @Override
  public String toString() {
    return "WsResult{" +
      "Company='" + Company + '\'' +
      ", AirlineCode='" + AirlineCode + '\'' +
      ", StartDrome='" + StartDrome + '\'' +
      ", ArriveDrome='" + ArriveDrome + '\'' +
      ", StartTime='" + StartTime + '\'' +
      ", ArriveTime='" + ArriveTime + '\'' +
      ", Mode='" + Mode + '\'' +
      ", AirlineStop='" + AirlineStop + '\'' +
      ", Week='" + Week + '\'' +
      '}';
  }

  public String getCompany() {
    return Company;
  }

  public void setCompany(String company) {
    Company = company;
  }

  public String getAirlineCode() {
    return AirlineCode;
  }

  public void setAirlineCode(String airlineCode) {
    AirlineCode = airlineCode;
  }

  public String getStartDrome() {
    return StartDrome;
  }

  public void setStartDrome(String startDrome) {
    StartDrome = startDrome;
  }

  public String getArriveDrome() {
    return ArriveDrome;
  }

  public void setArriveDrome(String arriveDrome) {
    ArriveDrome = arriveDrome;
  }

  public String getStartTime() {
    return StartTime;
  }

  public void setStartTime(String startTime) {
    StartTime = startTime;
  }

  public String getArriveTime() {
    return ArriveTime;
  }

  public void setArriveTime(String arriveTime) {
    ArriveTime = arriveTime;
  }

  public String getMode() {
    return Mode;
  }

  public void setMode(String mode) {
    Mode = mode;
  }

  public String getAirlineStop() {
    return AirlineStop;
  }

  public void setAirlineStop(String airlineStop) {
    AirlineStop = airlineStop;
  }

  public String getWeek() {
    return Week;
  }

  public void setWeek(String week) {
    Week = week;
  }
}
