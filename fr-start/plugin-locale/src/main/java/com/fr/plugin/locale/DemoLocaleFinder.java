package com.fr.plugin.locale;

import com.fr.plugin.transform.ExecuteFunctionRecord;
import com.fr.plugin.transform.FunctionRecorder;
import com.fr.stable.fun.impl.AbstractLocaleFinder;

/**
 * @Description: 国际化文件接口
 * @Author: penney
 * @CreateDate: 2019/12/2 10:23
 * @UpdateUser:
 * @UpdateDate: 2019/12/2 10:23
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@FunctionRecorder
public class DemoLocaleFinder extends AbstractLocaleFinder {
    @Override
    @ExecuteFunctionRecord
    public String find() {
        return "demo";
    }
}
