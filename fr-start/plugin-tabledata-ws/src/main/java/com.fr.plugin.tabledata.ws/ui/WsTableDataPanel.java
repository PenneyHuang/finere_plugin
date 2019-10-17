package com.fr.plugin.tabledata.ws.ui;

import com.fr.base.BaseUtils;
import com.fr.base.Parameter;
import com.fr.design.data.datapane.preview.PreviewTablePane;
import com.fr.design.data.tabledata.tabledatapane.AbstractTableDataPane;
import com.fr.design.gui.ibutton.UIButton;
import com.fr.design.gui.itableeditorpane.ParameterTableModel;
import com.fr.design.gui.itableeditorpane.UITableEditorPane;
import com.fr.design.gui.itableeditorpane.UITableModelAdapter;
import com.fr.design.gui.itextfield.UITextField;
import com.fr.design.layout.TableLayout;
import com.fr.design.layout.TableLayoutHelper;
import com.fr.plugin.tabledata.ws.core.WsTableData;
import com.fr.script.Calculator;
import com.fr.stable.ParameterProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description: 数据源配置面板类
 * @Author: penney
 * @CreateDate: 2019/10/16 9:51
 * @UpdateUser:
 * @UpdateDate: 2019/10/16 9:51
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class WsTableDataPanel extends AbstractTableDataPane<WsTableData> {
  /**
   * 填充样式1
   */
  private final static double P = TableLayout.PREFERRED;
  /**
   * 填充样式2
   */
  private final static double F = TableLayout.FILL;
  /**
   * 文本标签
   */
  private UITextField tEditor;
  /**
   * 系统自实现参数面板
   */
  private UITableEditorPane<ParameterProvider> parameterTableEditorPane;


  public WsTableDataPanel() {
    init();
  }

  /**
   * 初始化面板
   */
  private void init() {
    //创建系统默认参数面板
    UITableModelAdapter<ParameterProvider> model = new ParameterTableModel();
    parameterTableEditorPane = new UITableEditorPane<>(model);
    //创建文本标签控件
    tEditor = new UITextField();
    //创建预览按钮
    UIButton preview = new UIButton(BaseUtils.readIcon("/com/fr/design/images/m_file/preview.png"));
    preview.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(new Runnable() {
          @Override
          public void run() {
            PreviewTablePane.previewTableData(WsTableDataPanel.this.updateBean());
          }
        });
      }
    });
    JPanel one = TableLayoutHelper.createTableLayoutPane(
      new Component[][]{{
        tEditor, preview
      }},
      new double[]{P},
      new double[]{F, P}
    );
    //创建2行1列
    JPanel panel = TableLayoutHelper.createTableLayoutPane(
      new Component[][]{{
        one
      }, {
        parameterTableEditorPane
      }},
      new double[]{P, F},
      new double[]{F}
    );
    this.add(panel, BorderLayout.SOUTH);
  }

  @Override
  public void populateBean(WsTableData wsTableData) {
    if (null == wsTableData) {
      return;
    }
    ParameterProvider[] parameters = wsTableData.getParameters(Calculator.createCalculator());
    tEditor.setText("参数");
    parameterTableEditorPane.populate(parameters);
  }

  @Override
  public WsTableData updateBean() {
    WsTableData ob = new WsTableData();
    ob.setOthers(tEditor.getText());
    java.util.List<ParameterProvider> parameterProviderList = parameterTableEditorPane.update();
    Parameter[] parameters = parameterProviderList.toArray(new Parameter[parameterProviderList.size()]);
    ob.setParameters(parameters);
    return ob;
  }

  @Override
  protected String title4PopupWindow() {
    return "TableData-ws";
  }
}
