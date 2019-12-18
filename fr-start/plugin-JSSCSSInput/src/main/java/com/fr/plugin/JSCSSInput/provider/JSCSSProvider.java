package com.fr.plugin.JSCSSInput.provider;

import com.fr.decision.fun.impl.AbstractWebResourceProvider;
import com.fr.decision.web.MainComponent;
import com.fr.plugin.JSCSSInput.component.FileDef;
import com.fr.web.struct.Atom;

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
