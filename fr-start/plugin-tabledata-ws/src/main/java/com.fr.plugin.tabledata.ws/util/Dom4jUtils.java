package com.fr.plugin.tabledata.ws.util;

import org.dom4j.Attribute;
import org.dom4j.Element;

import java.util.List;

public class Dom4jUtils {

  /**
   * 从指定节点开始,递归遍历所有子节点
   *
   * @author chenleixing
   */
  public static void getNodes(Element node) {
    System.out.println("--------------------");
    //当前节点的名称、文本内容和属性
    //当前节点名称
    System.out.println("当前节点名称：" + node.getName());
    //当前节点内容
    System.out.println("当前节点的内容：" + node.getTextTrim());
    //当前节点的所有属性的list
    List<Attribute> listAttr = node.attributes();
    //遍历当前节点的所有属性
    for (Attribute attr : listAttr) {
      //属性名称
      String name = attr.getName();
      //属性的值
      String value = attr.getValue();
      System.out.println("属性名称：" + name + "属性值：" + value);
    }

    //递归遍历当前节点所有的子节点
    //所有一级子节点的list
    List<Element> listElement = node.elements();
    //遍历所有一级子节点
    for (Element e : listElement) {
      //递归
      getNodes(e);
    }
  }


}
