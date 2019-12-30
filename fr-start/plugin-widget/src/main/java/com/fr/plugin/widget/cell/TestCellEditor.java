package com.fr.plugin.widget.cell;

import com.fr.design.gui.ilable.UILabel;
import com.fr.design.layout.FRGUIPaneFactory;
import com.fr.design.widget.ui.AbstractDataModify;
import com.fr.plugin.widget.DemoWidget;

import java.awt.*;

/**
 * @Description: 单元格控件设置界面类
 * @Author: penney
 * @CreateDate: 2019/12/30 14:02
 * @UpdateUser:
 * @UpdateDate: 2019/12/30 14:02
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class TestCellEditor extends AbstractDataModify<DemoWidget> {
    /**
     * 初始化方法
     *
     * @param
     * @return
     * @throws
     * @author penney
     * @date 2019/12/30 14:16
     **/
    public TestCellEditor() {
        this.setLayout(FRGUIPaneFactory.createBorderLayout());
        UILabel label = new UILabel("测试");
        this.add(label, BorderLayout.CENTER);
    }


    /**
     * 根据传递进来控件类，刷新当前的界面
     *
     * @param demoWidget
     */
    @Override
    public void populateBean(DemoWidget demoWidget) {

    }

    /**
     * 根据当前属性界面返回一个控件类
     *
     * @return
     */
    @Override
    public DemoWidget updateBean() {
        return null;
    }

    /**
     * 标题
     *
     * @return
     */
    @Override
    protected String title4PopupWindow() {
        return null;
    }


}
