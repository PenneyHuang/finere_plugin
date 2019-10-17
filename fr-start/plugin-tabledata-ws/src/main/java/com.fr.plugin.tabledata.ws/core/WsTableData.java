package com.fr.plugin.tabledata.ws.core;

import com.fr.config.Identifier;
import com.fr.config.holder.Conf;
import com.fr.config.holder.factory.Holders;
import com.fr.data.AbstractParameterTableData;
import com.fr.general.data.DataModel;
import com.fr.intelli.record.Focus;
import com.fr.intelli.record.Original;
import com.fr.plugin.tabledata.ws.pojo.WsFlightsResult;
import com.fr.record.analyzer.EnableMetrics;
import com.fr.script.Calculator;
import com.fr.stable.ParameterProvider;
import com.fr.stable.StringUtils;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLableReader;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: ws的数据集(也就是数据源, 属于数据链最底层)
 * @Author: penney
 * @CreateDate: 2019/10/15 9:45
 * @UpdateUser:
 * @UpdateDate: 2019/10/15 9:45
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */

@EnableMetrics
public class WsTableData extends AbstractParameterTableData {

  public final static String TAG = "Normal";
  public final static String ATT = "Attributes";
  public final static String STARTCITY = "startCity";
  public final static String LASTCITY = "lastCity";
  public final static String THEDATE = "theDate";

  private String startCity = "";
  private String lastCity = "";
  private String theDate = "";


  /**
   * 调用ws接口，获得相应信息
   *
   * @param
   * @throws
   * @author penney
   * @date 2019/10/15 10:07
   **/
  public static List<WsFlightsResult> getInfo(String startCity, String lastCity, String theDate) {
    /**
     * 获取请求地址
     */
    StringBuilder target = new StringBuilder("http://ws.webxml.com.cn/webservices/DomesticAirline.asmx/getDomesticAirlinesTime");
    target.append("?startCity=" + startCity);
    target.append("&lastCity=" + lastCity);
    target.append("&theDate=" + theDate);
    target.append("&userID=");
    try {
      URL url = new URL(target.toString());
      SAXReader saxReader = new SAXReader();
      Document document = saxReader.read(url);
      Element root = document.getRootElement();
      //获得指定节点内容
      List<Element> nodes = root.element("diffgram").element("Airlines").elements("AirlinesTime");
      ArrayList<WsFlightsResult> results = new ArrayList<>();
      //遍历
      for (Element node : nodes) {
        WsFlightsResult result = new WsFlightsResult();
        result.setCompany(node.element("Company").getTextTrim());
        result.setAirlineCode(node.element("AirlineCode").getTextTrim());
        result.setStartDrome(node.element("StartDrome").getTextTrim());
        result.setArriveDrome(node.element("ArriveDrome").getTextTrim());
        result.setStartTime(node.element("StartTime").getTextTrim());
        result.setArriveTime(node.element("ArriveTime").getTextTrim());
        result.setMode(node.element("Mode").getTextTrim());
        result.setAirlineStop(node.element("AirlineStop").getTextTrim());
        result.setWeek(node.element("Week").getTextTrim());
        results.add(result);
      }
      return results;
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("失败!");
      return null;
    }

  }


  @Override
  @Focus(id = "com.fr.plugin.tabledata.ws", text = "tabledata-ws", source = Original.PLUGIN)
  public DataModel createDataModel(Calculator calculator) {
    //先获取参数面板上的所有参数
    ParameterProvider[] parameters = this.getParameters(calculator);
    //重新计算参数(有时候需要重新计算一次)(系统默认计算)
    parameters = Calculator.processParameters(calculator, parameters);
    for (ParameterProvider parameter : parameters) {
      if (STARTCITY.equals(parameter.getName())) {
        startCity = (String) parameter.getValue();
      }
      if (LASTCITY.equals(parameter.getName())) {
        lastCity = (String) parameter.getValue();
      }
      if (THEDATE.equals(parameter.getName())) {
        theDate = (String) parameter.getValue();
      }

    }
    //根据不同参数配置，返回不同结果集
    List<WsFlightsResult> info = getInfo(startCity, lastCity, theDate);
    return new WsModelData(info);
  }


  /**
   * 指定配置项
   */
  @Identifier(TAG)
  private Conf<String> others = Holders.simple(StringUtils.EMPTY);


  /**
   * 作为服务器数据集需要对数据库进行读写
   */

  public String getOthers() {
    //根据一定条件进行读
    return others.get();
  }

  public void setOthers(String others) {
    //根据一定条件写
    this.others.set(others);
  }

  /**
   * 作为模板数据集需要对XML进行读写
   */

  @Override
  public void readXML(XMLableReader reader) {
    super.readXML(reader);
    if (reader.isChildNode()) {
      if (ATT.equals(reader.getTagName())) {
        setOthers(reader.getAttrAsString(TAG, StringUtils.EMPTY));
      }
    }
  }

  @Override
  public void writeXML(XMLPrintWriter writer) {
    super.writeXML(writer);
    writer.startTAG(ATT).attr(TAG, getOthers()).end();
  }


}
