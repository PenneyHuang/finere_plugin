package com.fr.plugin.JSCSSInput.component;


import com.fr.plugin.transform.ExecuteFunctionRecord;
import com.fr.plugin.transform.FunctionRecorder;
import com.fr.web.struct.Component;
import com.fr.web.struct.Filter;
import com.fr.web.struct.browser.RequestClient;
import com.fr.web.struct.category.ScriptPath;
import com.fr.web.struct.category.StylePath;

/**
 * @Description: 定义组件
 * @Author: penney
 * @CreateDate: 2019/10/18 11:06
 * @UpdateUser:
 * @UpdateDate: 2019/10/18 11:06
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@FunctionRecorder
public class FileDef extends Component {
    public static final FileDef KEY = new FileDef();

    private FileDef() {
    }

    /**
     * 返回需要引入的JS脚本路径
     *
     * @param client 请求客户端描述
     * @return JS脚本路径
     */
    @Override
    public ScriptPath script(RequestClient client) {
        //如果不需要就直接返回  ScriptPath.EMPTY
        return ScriptPath.build("js/demo.js");
    }

    /**
     * 返回需要引入的CSS样式路径
     *
     * @param client 请求客户端描述
     * @return CSS样式路径
     */
    @Override
    public StylePath style(RequestClient client) {
        //如果不需要就直接返回 StylePath.EMPTY;
        return StylePath.build("css/head.css");
    }

    /**
     * 通过给定的资源过滤器控制是否加载这个资源
     *
     * @return 资源过滤器
     */
    @Override
    @ExecuteFunctionRecord
    public Filter filter() {
        return new Filter() {
            @Override
            public boolean accept() {
                //任何情况下我们都在平台组件加载时加载我们的组件
                return true;
            }
        };
    }
}
