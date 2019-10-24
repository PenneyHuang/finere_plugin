package com.fr.plugin.tabledata.ws.util;


import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
    /**
     * 关键词提取
     *
     * @param content
     * @param pattern
     * @return
     */
    public static Set<String> keywordFilter(String content, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(content);
        Set<String> setResult = new HashSet<>();
        while (m.find()) {
            setResult.add(m.group().substring(2, m.group().length() - 1));
        }
        return setResult;
    }


}
