package com.fr.plugin.JSCSSInput.provider;

import com.fr.base.ServerConfig;
import com.fr.decision.authority.data.User;
import com.fr.decision.config.AppearanceConfig;
import com.fr.decision.fun.impl.AbstractWebResourceProvider;
import com.fr.decision.web.ConnectionComponent;
import com.fr.decision.web.MainComponent;
import com.fr.decision.webservice.utils.WebServiceUtils;
import com.fr.decision.webservice.v10.user.UserService;
import com.fr.plugin.JSCSSInput.component.FileDef;
import com.fr.third.fasterxml.jackson.databind.ObjectMapper;
import com.fr.web.Browser;
import com.fr.web.struct.Atom;
import com.fr.web.struct.AtomBuilder;
import com.fr.web.struct.PathGroup;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class JSCSSProvider extends AbstractWebResourceProvider {
    @Override
    public Atom attach() {
        //在平台主组件加载时添加我们自己的组件
        return MainComponent.KEY;
    }


    @Override
    public Atom client() {
        //我们自己要引入的组件
        return FileDef.KEY;
    }
}
