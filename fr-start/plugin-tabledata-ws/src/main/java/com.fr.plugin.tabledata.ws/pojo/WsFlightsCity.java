package com.fr.plugin.tabledata.ws.pojo;

/**
 * @Description: 航班城市
 * @Author: penney
 * @CreateDate: 2019/10/15 16:02
 * @UpdateUser:
 * @UpdateDate: 2019/10/15 16:02
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class WsFlightsCity {
  /**
   * 城市英文名称
   *
   * @return
   */
  private String enCityName;

  /**
   * 城市中文名称
   */
  private String cnCityName;

  /**
   * 缩写
   */
  private String Abbreviation;


  public WsFlightsCity(String enCityName, String cnCityName, String abbreviation) {
    this.enCityName = enCityName;
    this.cnCityName = cnCityName;
    Abbreviation = abbreviation;
  }

  public WsFlightsCity() {
  }


  public String getEnCityName() {
    return enCityName;
  }

  public void setEnCityName(String enCityName) {
    this.enCityName = enCityName;
  }

  public String getCnCityName() {
    return cnCityName;
  }

  public void setCnCityName(String cnCityName) {
    this.cnCityName = cnCityName;
  }

  public String getAbbreviation() {
    return Abbreviation;
  }

  public void setAbbreviation(String abbreviation) {
    Abbreviation = abbreviation;
  }

  @Override
  public String toString() {
    return "WsFlightsCity{" +
      "enCityName='" + enCityName + '\'' +
      ", cnCityName='" + cnCityName + '\'' +
      ", Abbreviation='" + Abbreviation + '\'' +
      '}';
  }
}
