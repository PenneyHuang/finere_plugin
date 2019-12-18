package com.fr.plugin.resource.redef;

import com.fr.plugin.transform.ExecuteFunctionRecord;
import com.fr.plugin.transform.FunctionRecorder;
import com.fr.stable.fun.impl.AbstractResourcePathTransformer;

@FunctionRecorder
public class IndexRef extends AbstractResourcePathTransformer {


    private final static String LoginPage = "/com/fr/web/controller/decision/entrance/resources/index.html";

    @Override
    public boolean accept(String oldpath) {
        return LoginPage.equals(oldpath);
    }

    @Override
    @ExecuteFunctionRecord
    public String transform(String oldpath) {
        return "html/index.html";
    }

}
