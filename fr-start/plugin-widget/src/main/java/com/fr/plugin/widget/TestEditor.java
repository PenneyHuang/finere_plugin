package com.fr.plugin.widget;

import com.fr.design.designer.creator.CRPropertyDescriptor;
import com.fr.design.designer.creator.XLayoutContainer;
import com.fr.design.designer.creator.XWidgetCreator;
import com.fr.form.ui.Widget;

import javax.swing.*;
import java.awt.*;
import java.beans.IntrospectionException;

/**
 * @Description: 参数面板、表单界面，控件的界面展示类
 * @Author: penney
 * @CreateDate: 2019/12/30 11:13
 * @UpdateUser:
 * @UpdateDate: 2019/12/30 11:13
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class TestEditor extends XWidgetCreator {
    public TestEditor(Widget widget, Dimension dimension) {
        super(widget, dimension);
    }

    /**
     * 返回一个组件，设计的时候在参数面板显示的样子
     *
     * @return
     */
    @Override
    protected JComponent initEditor() {
        return null;
    }

    /**
     * 返回当前XCreator的一个封装父容器，可以直接返回XWScaleLayout即可
     *
     * @param widgetName 当前控件名字
     * @return
     */
    @Override
    protected XLayoutContainer getCreatorWrapper(String widgetName) {
        return super.getCreatorWrapper(widgetName);
    }

    /**
     * 将当前组件添加父组件，
     *
     * @param xLayoutContainer 父组件getCreatorWrapper 方法返回
     * @param width            宽
     * @param minHeight        高
     */
    @Override
    protected void addToWrapper(XLayoutContainer xLayoutContainer, int width, int minHeight) {
        super.addToWrapper(xLayoutContainer, width, minHeight);
    }

    /**
     * 画图的方法，在initEditor方法返回的组件上面画图,比如文本框实时显示当前的值
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    /**
     * 返回控件支持的属性
     *
     * @return
     * @throws IntrospectionException
     */
    @Override
    public CRPropertyDescriptor[] supportedDescriptor() throws IntrospectionException {
        return super.supportedDescriptor();
    }
}
