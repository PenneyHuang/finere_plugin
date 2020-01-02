package com.fr.plugin.report;

import com.fr.stable.fun.impl.AbstractJavaScriptFileHandler;

/**
 * @Description: 报表引入JS
 * @Author: penney
 * @CreateDate: 2019/12/30 10:34
 * @UpdateUser:
 * @UpdateDate: 2019/12/30 10:34
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ReportJavaScriptFileHandler extends AbstractJavaScriptFileHandler {


    @Override
    public String[] pathsForFiles() {
        return new String[]{"/web/js/text.js"};
    }
}
