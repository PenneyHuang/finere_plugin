package com.fr.plugin.widget;

import com.fr.form.ui.TextEditor;
import com.fr.general.ComparatorUtils;
import com.fr.json.JSONException;
import com.fr.json.JSONObject;
import com.fr.script.Calculator;
import com.fr.stable.StableUtils;
import com.fr.stable.core.NodeVisitor;
import com.fr.stable.web.Repository;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLableReader;

import java.awt.*;

/**
 * @Description: 自定义控件类
 * @Author: penney
 * @CreateDate: 2019/12/30 11:09
 * @UpdateUser:
 * @UpdateDate: 2019/12/30 11:09
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class DemoWidget extends TextEditor {
    /**
     * 新增一个颜色属性
     * 需要有对应的get和set方法
     */
    private Color fontColor = Color.BLACK;

    /**
     * 控件的类型
     *
     * @return
     */
    @Override
    public String getXType() {
        return "styletext";
    }

    /**
     * 返回控件的属性json,这个对应的就是前端控件widget.options属性的,
     * 比如是否允许为空等，这边实现在原来的基础上增加了一个fontColor属性
     *
     * @param repository
     * @param calculator
     * @param nodeVisitor
     * @return
     * @throws JSONException
     */
    @Override
    public JSONObject createJSONConfig(Repository repository, Calculator calculator, NodeVisitor nodeVisitor) throws JSONException {
        return super.createJSONConfig(repository, calculator, nodeVisitor).put("fontColor", StableUtils.javaColorToCSSColor(this.fontColor));
    }

    public DemoWidget() {
        super();
    }

    /**
     * 保存时候将设置保存在模板里面,具体的写法配置文件的篇章中有介绍，这边不详细说明了
     *
     * @param xmLableReader
     */
    @Override
    public void readXML(XMLableReader xmLableReader) {
        super.readXML(xmLableReader);
        if (xmLableReader.isChildNode()) {
            String tagName = xmLableReader.getTagName();
            if (ComparatorUtils.equals(tagName, "FontColor")) {
                this.setFontColor(rgbTOColor(xmLableReader.getElementValue()));
                //   this.getFont().setForeground(new Color(""));
            }
        }
    }

    /**
     * 从模板里面读取对应的属性
     *
     * @param xmlPrintWriter
     */

    @Override
    public void writeXML(XMLPrintWriter xmlPrintWriter) {
        super.writeXML(xmlPrintWriter);
        xmlPrintWriter.startTAG("FontColor").textNode(String.valueOf(StableUtils.javaColorToCSSColor(this.fontColor))).end();
    }

    /**
     * 新增属性的get和set方法,需要有
     *
     * @return
     */
    public Color getFontColor() {
        return fontColor;
    }

    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    private Color rgbTOColor(String rgbStr) {
        int start = rgbStr.indexOf("(");
        int end = rgbStr.indexOf(")");
        if (start < 0 || end < 0 || start > end) {
            return Color.RED;
        }
        String colorString = rgbStr.substring(start + 1, end);
        String[] array = colorString.split(",");
        return new Color(Integer.parseInt(array[0]), Integer.parseInt(array[1]), Integer.parseInt(array[2]));
    }

    @Override
    public boolean isEditor() {
        return false;
    }


}
