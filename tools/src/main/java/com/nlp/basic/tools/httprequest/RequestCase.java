package com.nlp.basic.tools.httprequest;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation")
public class RequestCase {
    /**
     * 测试post请求
     *
     * @author mabaizhang
     * @date 2017年6月27日
     */
    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", "testdemo");
        Gson gson = new Gson();
        String text = gson.toJson(getTestCaseInput());
        params.put("text", text);
        // 测试地址抽取
        params.put("type", "email");

        String paramsJson = gson.toJson(params);
        String url = "http://localhost:9000/extractor";
        String result = null;
        try {
            result = postDataWithJson(url, paramsJson);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    /**
     * 构造输入例子
     *
     * @author mabaizhang
     * @date 2017年6月23日
     */
    private static List<String> getTestCaseInput() {
        List<String> arry = new ArrayList<>();
        String str1 = "百度信息技术有限公司";
        String str2 = "中国著名的搜索引擎公司包含百度信息技术股份有限公司";
        String str3 = "baidu";
        String str4 = "我的公司是百度";
        String str5 = "我的邮箱是omabz@qq.com, oomabz@126.com";
        String str6 = "有乱码的测试例子：我是中�人，�是一���的例子";
        String str7 = "苍南县灵溪镇仁英路德丰大厦A幢7B";
        String str8 = "总 经理，王长江l";
        String str9 = "我的电话是13810091009";
        String str10 = "L二二二——————";
        arry.add(str1);
        arry.add(str2);
        arry.add(str3);
        arry.add(str4);
        arry.add(str5);
        arry.add(str6);
        arry.add(str7);
        arry.add(str8);
        arry.add(str9);
        arry.add(str10);
        return arry;
    }

    /**
     * 采用post方式请求参数
     *
     * @author mabaizhang
     * @date 2017年6月27日
     */
    private static String postDataWithJson(String url, String paramsJson) throws ParseException, IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
        StringEntity se = new StringEntity(paramsJson, "UTF-8");
        se.setContentType("text/json");
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httpPost.setEntity(se);
        @SuppressWarnings("resource")
        HttpResponse httpResponse = new DefaultHttpClient().execute(httpPost);
        return EntityUtils.toString(httpResponse.getEntity());
    }

}
