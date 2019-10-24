package com.fr.plugin.tabledata.ws.constant;


public enum Conts {
    CUTOUT("(\\$\\{[^\\]]*\\})"),;

    private String code;

    private Conts(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }


}
