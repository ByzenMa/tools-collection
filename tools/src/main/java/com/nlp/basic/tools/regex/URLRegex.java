package com.nlp.basic.tools.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLRegex {
    private final static Pattern urlPattern = Pattern.compile(
            "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)" + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
                    + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)",
            Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

    /**
     * 由于是工具类，因此私有化初始化方法
     */
    private URLRegex() {
    }

    /**
     * 抽取操作
     *
     * @author mabaizhang
     * @date 2017年6月29日
     */
    public static List<String> extract(List<String> in) {
        List<String> pages = new ArrayList<>();
        for (String line : in) {
            pages.addAll(extract(line));
        }
        return pages;
    }

    /**
     * 抽取给定字符串中所有的网址
     *
     * @param in
     * @return
     */
    public static List<String> extract(String in) {
        String afterPreprocess = strPreprocess(in);
        List<String> pages = new ArrayList<>();
        Matcher m = urlPattern.matcher(afterPreprocess);
        while (m.find()) {
            int matchStart = m.start(1);
            int matchEnd = m.end();
            pages.add(afterPreprocess.substring(matchStart, matchEnd));
        }
        return pages;
    }

    /**
     * 字符串预处理
     *
     * @author mabaizhang
     * @date 2017年6月29日
     */
    private static String strPreprocess(String line) {
        String handled = "";
        if (line != null && line.length() > 0) {
            handled = line.trim();// 去除email的首位空格
        }
        return handled;
    }
}
