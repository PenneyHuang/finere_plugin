package com.fr.test;

import java.util.HashSet;

import com.fr.plugin.tabledata.ws.constant.Conts;
import com.fr.plugin.tabledata.ws.core.WsModelData;
import com.fr.plugin.tabledata.ws.core.WsTableData;
import com.fr.plugin.tabledata.ws.pojo.WsFlightsResult;
import com.fr.plugin.tabledata.ws.util.BM;
import com.fr.plugin.tabledata.ws.util.RegexUtil;
import com.fr.report.core.A.A;
import com.fr.third.org.apache.commons.lang3.RegExUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AllTest {
    /**
     * 接口测试
     *
     * @param
     * @return void
     * @throws
     * @author penney
     * @date 2019/10/17 10:59
     **/
    @Test
    public void test01() {
        List<WsFlightsResult> info = WsTableData.getInfo("上海", "北京", "2019-10-15");
        System.out.println("一共有" + info.size() + "趟航班");
    }


    /**
     * 类中字段测试
     *
     * @param
     * @return void
     * @throws
     * @author penney
     * @date 2019/10/17 11:00
     **/
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


    /**
     * 数据模型初始化测试
     *
     * @param
     * @return void
     * @throws
     * @author penney
     * @date 2019/10/17 11:00
     **/
    @Test
    public void test03() {
        ArrayList<WsFlightsResult> wsFlightsResults = new ArrayList<>();
        wsFlightsResults.add(new WsFlightsResult());
        WsModelData wsModelData = new WsModelData(wsFlightsResults);
    }


    /**
     * BM方法测试
     *
     * @param
     * @return void
     * @throws
     * @author penney
     * @date 2019/10/17 11:01
     **/
    @Test
    public void test04() {
        BM.pattern("as", "sasadsdwdaadkjhasncxhwdscuikjcm");
    }

    /**
     * 正则匹配测试
     *
     * @param
     * @return void
     * @throws
     * @author penney
     * @date 2019/10/17 16:37
     **/
    @Test
    public void test05() {
//        String s = RegExUtils.replaceAll("agsfasghas", "^[A-Za-z]+$", "hello");
        Set<String> s1 = RegexUtil.keywordFilter("aa${asd}", "(\\$\\{[^\\]]*\\})");
        Set<String> s2 = RegexUtil.keywordFilter("aa${asd}", Conts.CUTOUT.getCode());
        System.out.println(s1);
    }

}
