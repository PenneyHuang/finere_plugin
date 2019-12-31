package com.fr.plugin.widget.panel;

import com.fr.design.Exception.ValidationException;
import com.fr.design.gui.ibutton.UIColorButton;
import com.fr.design.mainframe.widget.editors.AbstractPropertyEditor;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
/**
* @Description:    属性设置面板
* @Author:         penney
* @CreateDate:     2019/12/31 10:20
* @UpdateUser:
* @UpdateDate:     2019/12/31 10:20
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class StyleColorAttrEditor extends AbstractPropertyEditor {
    /**
     * 一个设置字体颜色的按钮。
     */
    private UIColorButton colorButton = new UIColorButton();

    public StyleColorAttrEditor() {
        super();
        /**
         * 给颜色选择按钮设置添加一个颜色变化的监听事件，监听事件中触发当前属性设置界面的
         * 属性改变事件
         */
        colorButton.addColorChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                firePropertyChanged();
            }
        });
    }

    /**
     * 给当前的属性框设置,这个demo中其实就是给颜色按钮显示对应的颜色
     *
     * @param value
     */
    @Override
    public void setValue(Object value) {
        if (value instanceof Color) {
            this.colorButton.setColor((Color) value);
            this.colorButton.repaint();
        }
    }

    /**
     * 返回对应属性值,firePropertyChanged 这个方法触发的时候就会调用这个方法返回值，然后调用控件类的对应get方法给控件设置属性
     *
     * @return
     */
    @Override
    public Object getValue() {
        //   return frFontPane.update(FRFont.getInstance());
        return this.colorButton.getColor();
    }

    /**
     * 属性界面实际显示的组件,这边就是直接显示颜色选择的按钮了
     *
     * @return
     */
    @Override
    public Component getCustomEditor() {
        return colorButton;
    }

    /**
     * 值校验
     *
     * @throws ValidationException
     */
    @Override
    public void validateValue() throws ValidationException {

    }

}
