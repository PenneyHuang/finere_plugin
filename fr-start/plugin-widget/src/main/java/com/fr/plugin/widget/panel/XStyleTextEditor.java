package com.fr.plugin.widget.panel;

import com.fr.design.designer.creator.CRPropertyDescriptor;
import com.fr.design.designer.creator.XTextEditor;
import com.fr.form.ui.TextEditor;
import com.fr.stable.ArrayUtils;

import java.awt.*;
import java.beans.IntrospectionException;

/**
 * @Description: 属性设置类
 * @Author: penney
 * @CreateDate: 2019/12/30 11:21
 * @UpdateUser:
 * @UpdateDate: 2019/12/30 11:21
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class XStyleTextEditor extends XTextEditor {
    public XStyleTextEditor(TextEditor textEditor, Dimension dimension) {
        super(textEditor, dimension);
    }

    /**
     * 因为控件类里面新增了一个fontColor属性，所以直接继承XTextEditor时候，只需要重新写实现这个属性的方法，新增一个设置fontColor的方法
     *
     * @return
     * @throws IntrospectionException
     */
    @Override
    public CRPropertyDescriptor[] supportedDescriptor() throws IntrospectionException {
        CRPropertyDescriptor[] sup = super.supportedDescriptor();
        /**
         * 新增一个属性fontColot是属性名称,自定义一个名称不和其他名称冲突即可，
         * this.data.getClass()就是控件类的class了
         * getFontColor和setFontColor 就是对应了控件类中该属性的get和set方法名，所以前面DemoWidget需要定义这两个方法
         * setI18NName方法设置的就是属性的标签值了,应该是需要使用国际化方法返回的这边简化了
         * setEditorClass 这个方法其实就是设置属性的编辑界面，如果对应的属性是一些基本类型比如int String 等，可以不用设置，会调用默认的设置界面，
         * 当前demo中是Color类型,所以需要自己定一个界面。StyleColorAttrEditor 就是一个设置界面类，继承了AbstractPropertyEditor，下文详细介绍，
         * putKeyValue("category", "Fine-Design_Report_Advanced") 设置当前属性显示的子菜单，demo中设置就是显示在高级属性下面
         */
        CRPropertyDescriptor styleAttr = new CRPropertyDescriptor("fontColor", this.data.getClass(), "getFontColor", "setFontColor").setI18NName("颜色")
                .setEditorClass(StyleColorAttrEditor.class).putKeyValue("category", "Fine-Design_Report_Advanced");
        return ArrayUtils.addAll(sup, new CRPropertyDescriptor[]{styleAttr});
    }

}
