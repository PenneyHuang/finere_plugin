package com.fr.plugin.report;

import com.fr.stable.fun.impl.AbstractCssFileHandler;

public class ReportCssFileHandler extends AbstractCssFileHandler {
    @Override
    public String[] pathsForFiles() {
        return new String[]{"/com/fr/plugin/web/css/text.css"};
    }


}
