package com.fr.test;

import com.fr.plugin.tabledata.ws.core.WsModelData;
import com.fr.plugin.tabledata.ws.core.WsTableData;
import com.fr.plugin.tabledata.ws.pojo.WsFlightsResult;
import com.fr.plugin.tabledata.ws.util.BM;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class URLTest {

    @Test
    public void test01() {

        List<WsFlightsResult> info = WsTableData.getInfo("上海", "北京", "2019-10-15");
        System.out.println("一共有" + info.size() + "趟航班");
    }

    @Test
    public void test02() {
        ArrayList<String> list = new ArrayList<>();
        Field[] fields = WsFlightsResult.class.getDeclaredFields();
        for (Field field : fields) {
            list.add(field.getName());
        }
        String[] names = new String[list.size()];
        list.toArray(names);
        System.out.println(names.toString());
    }

    @Test
    public void test03() {
        ArrayList<WsFlightsResult> wsFlightsResults = new ArrayList<>();
        wsFlightsResults.add(new WsFlightsResult());
        WsModelData wsModelData = new WsModelData(wsFlightsResults);
    }


    @Test
    public void test04() {
        BM.pattern("as", "sasadsdwdaadkjhasncxhwdscuikjcm");
    }


}
