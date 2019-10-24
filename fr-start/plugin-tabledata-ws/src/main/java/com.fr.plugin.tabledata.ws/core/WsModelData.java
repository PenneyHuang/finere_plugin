package com.fr.plugin.tabledata.ws.core;

import com.fr.data.AbstractDataModel;
import com.fr.general.data.TableDataException;
import com.fr.plugin.tabledata.ws.pojo.WsFlightsResult;
import com.fr.stable.ParameterProvider;
import com.fr.stable.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 帆软识别数据类
 * @Author: penney
 * @CreateDate: 2019/10/15 16:46
 * @UpdateUser:
 * @UpdateDate: 2019/10/15 16:46
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class WsModelData extends AbstractDataModel {
    /**
     * 初始化
     */
    private final static WsModelData EMPTY = new WsModelData(null);

    /**
     * 数据集对应的字段列
     */
    private String[] COL_NAMES = new String[]{};

    /**
     * 数据集对应的行数
     */
    private int RowCount = 0;

    /**
     * 数据集二维数组化
     */

    private String[][] TableData = new String[][]{};

    /**
     * 参数列(默认没有参数)
     */
    private ParameterProvider[] parameters = new ParameterProvider[0];

    /**
     * 其他参数
     */
    private String others = StringUtils.EMPTY;


    public WsModelData() {
    }

    @Override
    public int getColumnCount() throws TableDataException {
        return COL_NAMES.length;
    }

    @Override
    public String getColumnName(int i) throws TableDataException {
        return COL_NAMES[i];
    }

    @Override
    public int getRowCount() throws TableDataException {
        return RowCount;
    }

    @Override
    public Object getValueAt(int i, int j) throws TableDataException {
        return TableData[i][j];
    }


    public WsModelData(List<WsFlightsResult> results) {
        initData(results);
    }

    private void initData(List<WsFlightsResult> results) {
        Class clazz = WsFlightsResult.class;
        //定义一个数组存储字段名
        ArrayList<String> list = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            list.add(field.getName());
        }
        String[] names = new String[list.size()];
        list.toArray(names);
        this.COL_NAMES = names;
        //设置数据集行数
        this.RowCount = null == results ? 0 : results.size();
        //设置数据集
        String[][] temp = new String[RowCount][fields.length];
        for (int i = 0; i < RowCount; i++) {
            for (int j = 0; j < fields.length; j++) {
                fields[j].setAccessible(true);
                try {
                    temp[i][j] = (String) fields[j].get(results.get(i));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
        this.TableData = temp;

    }
}
