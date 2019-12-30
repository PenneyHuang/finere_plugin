package com.fr.plugin.widget.cell;

import com.fr.design.designer.IntervalConstants;
import com.fr.design.gui.ibutton.UIColorButton;
import com.fr.design.gui.ilable.UILabel;
import com.fr.design.layout.TableLayout;
import com.fr.design.layout.TableLayoutHelper;

import javax.swing.*;
import java.awt.*;

/**
 * @Description: 颜色选择框
 * @Author: penney
 * @CreateDate: 2019/12/30 14:20
 * @UpdateUser:
 * @UpdateDate: 2019/12/30 14:20
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ColorSelectPane extends JPanel {
    private UIColorButton colorButton = new UIColorButton();

    /**
     * 设置一个颜色选择pane,标签和UIColorButton横向排列
     */
    public ColorSelectPane() {
        this.setLayout(new BorderLayout());

        double f = TableLayout.FILL;
        double p = TableLayout.PREFERRED;
        Component[][] components = new Component[][]{
                new Component[]{new UILabel("字体颜色"), colorButton},
        };
        double[] rowSize = {p};
        double[] columnSize = {p, f};
        int[][] rowCount = {{1, 1}};
        JPanel panel = TableLayoutHelper.createGapTableLayoutPane(components, rowSize, columnSize, rowCount, IntervalConstants.INTERVAL_W3, IntervalConstants.INTERVAL_L1);
        this.add(panel, BorderLayout.CENTER);
    }

    /**
     * 获取选择框的颜色
     *
     * @return
     */
    public Color getColor() {
        return this.colorButton.getColor();
    }

    /**
     * 根据颜色设置这个选择框的颜色
     *
     * @param color
     */
    public void setColor(Color color) {
        this.colorButton.setColor(color);
        this.colorButton.repaint();
    }


}
