package com.nlp.basic.tools.regex;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by mabaizhang on 2017/7/3.
 */
public class URLRegexTest {


    /**
     * 测试抽取List
     *
     * @throws Exception
     */
    @Test
    public void extract() throws Exception {
        List<String> urls = URLRegex.extract(buildTestArry());
        for (String url : urls) {
            System.out.println(url);
        }
        assertTrue(urls.size() == 6);
    }


    /**
     * 测试抽取字符串
     *
     * @throws Exception
     */
    @Test
    public void extract1() throws Exception {
        List<String> urls = URLRegex.extract(buildTestString());
        for (String url : urls) {
            System.out.println(url);
        }
        assertTrue(urls.size() == 1);
    }

    /**
     * 构造测试数据
     *
     * @return
     */
    private List<String> buildTestArry() {
        List<String> arry = new ArrayList<>();
        String str1 = "我的邮箱是Byzen.Ma@gmail.com, byzenma@126.com";
        String str2 = "My homepage is http://www.wztwrj.com";
        String str3 = "我的网址是www.baidu.com，我的主页是www.qq.com";
        String str4 = "他的email：ooomabz@qq.com";
        String str5 = "https://www.google.com";
        String str6 = "www.chanjet.com";
        String str7 = "www.baidu.com";
        arry.add(str1);
        arry.add(str2);
        arry.add(str3);
        arry.add(str4);
        arry.add(str5);
        arry.add(str6);
        arry.add(str7);
        return arry;
    }

    /**
     * 构造测试字符串
     *
     * @return
     */
    private String buildTestString() {
        return "我的邮箱是Byzen.Ma@gmail.com, 我的网址是http://www.baidu.com";
    }
}