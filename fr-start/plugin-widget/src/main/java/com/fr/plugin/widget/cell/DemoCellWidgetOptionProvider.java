package com.fr.plugin.widget.cell;

import com.fr.design.beans.BasicBeanPane;
import com.fr.design.fun.impl.AbstractCellWidgetOptionProvider;
import com.fr.form.ui.Widget;
import com.fr.plugin.widget.DemoWidget;

/**
 * @Description: 单元格控件集成类
 * @Author: penney
 * @CreateDate: 2019/12/30 14:25
 * @UpdateUser:
 * @UpdateDate: 2019/12/30 14:25
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class DemoCellWidgetOptionProvider extends AbstractCellWidgetOptionProvider {
    @Override
    public Class<? extends Widget> classForWidget() {
        return DemoWidget.class;
    }

    @Override
    public Class<? extends BasicBeanPane<? extends Widget>> appearanceForWidget() {
        return StyleCellTextDefinePane.class;
    }

    @Override
    public String iconPathForWidget() {
        return "/com/fr/plugin/web/image/text_field_16.png";
    }

    @Override
    public String nameForWidget() {
        return "样式文本控件";
    }


}
