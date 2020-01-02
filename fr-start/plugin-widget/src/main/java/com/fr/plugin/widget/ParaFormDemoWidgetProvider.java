package com.fr.plugin.widget;

import com.fr.design.fun.FormWidgetOptionProvider;
import com.fr.design.fun.impl.AbstractParameterWidgetOptionProvider;
import com.fr.form.ui.Widget;
import com.fr.plugin.widget.panel.XStyleTextEditor;

/**
 * @Description: 参数面板注册类
 * @Author: penney
 * @CreateDate: 2019/12/30 12:09
 * @UpdateUser:
 * @UpdateDate: 2019/12/30 12:09
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ParaFormDemoWidgetProvider extends AbstractParameterWidgetOptionProvider implements FormWidgetOptionProvider {
    @Override
    public Class<? extends Widget> classForWidget() {
        return DemoWidget.class;
    }

    @Override
    public Class<?> appearanceForWidget() {
        return XStyleTextEditor.class;
    }

    @Override
    public String iconPathForWidget() {
        return "/web/image/text_field_15.png";
    }

    @Override
    public String nameForWidget() {
        return "样式文本控件";
    }

    /**
     * 这个表单控件接口FormWidgetOptionProvider新增的一个方法，返回组件是不是布局容器，
     *
     * @return
     */
    @Override
    public boolean isContainer() {
        return false;
    }

}
