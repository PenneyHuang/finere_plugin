package com.fr.plugin.widget.cell;

import com.fr.design.widget.ui.TextFieldEditorDefinePane;
import com.fr.form.ui.TextEditor;
import com.fr.plugin.widget.DemoWidget;

import javax.swing.*;
import java.awt.*;

/**
 * @Description: 文本框设置界面
 * @Author: penney
 * @CreateDate: 2019/12/30 14:23
 * @UpdateUser:
 * @UpdateDate: 2019/12/30 14:23
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class StyleCellTextDefinePane extends TextFieldEditorDefinePane {
    private ColorSelectPane colorSelectPane;

    /**
     * 增加一个自己设置的颜色选择框
     *
     * @return
     */
    @Override
    protected JPanel setFirstContentPane() {
        JPanel supPane = super.setFirstContentPane();
        colorSelectPane = new ColorSelectPane();
        supPane.add(colorSelectPane, BorderLayout.CENTER);
        return supPane;
    }

    /**
     * 给颜色选择面板设置值
     *
     * @param textEditor
     */
    @Override
    protected void populateSubFieldEditorBean(TextEditor textEditor) {
        super.populateSubFieldEditorBean(textEditor);
        if (textEditor instanceof DemoWidget) {
            this.colorSelectPane.setColor(((DemoWidget) textEditor).getFontColor());
        }
    }

    /**
     * 默认的基础上面增加一个设置颜色属性
     *
     * @return
     */
    @Override
    protected TextEditor updateSubFieldEditorBean() {
        TextEditor supEditor = super.updateSubFieldEditorBean();
        if (supEditor instanceof DemoWidget) {
            ((DemoWidget) supEditor).setFontColor(this.colorSelectPane.getColor());
        }
        return supEditor;
    }

    /**
     * 返回一个自己定义的控件类型
     *
     * @return
     */
    @Override
    protected TextEditor newTextEditorInstance() {
        return new DemoWidget();
    }


}
