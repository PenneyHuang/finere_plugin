package com.fr.plugin.tabledata.ws;

import com.fr.base.TableData;
import com.fr.design.data.tabledata.tabledatapane.AbstractTableDataPane;
import com.fr.design.fun.impl.AbstractTableDataDefineProvider;
import com.fr.plugin.tabledata.ws.core.WsTableData;
import com.fr.plugin.tabledata.ws.pojo.WsFlightsResult;
import com.fr.plugin.tabledata.ws.ui.WsTableDataPanel;

/**
 * @Description: 脚本入口类
 * @Author: penney
 * @CreateDate: 2019/10/16 10:43
 * @UpdateUser:
 * @UpdateDate: 2019/10/16 10:43
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class WsTableDataScriptDefine extends AbstractTableDataDefineProvider {
  @Override
  public Class<? extends TableData> classForTableData() {
    return WsTableData.class;
  }

  @Override
  public Class<? extends TableData> classForInitTableData() {
    return WsTableData.class;
  }

  @Override
  public Class<? extends AbstractTableDataPane> appearanceForTableData() {
    return WsTableDataPanel.class;
  }

  @Override
  public String nameForTableData() {
    return "TableData-ws";
  }

  @Override
  public String prefixForTableData() {
    return "ws";
  }

  @Override
  public String iconPathForTableData() {
    return "images/json.png";
  }
}
