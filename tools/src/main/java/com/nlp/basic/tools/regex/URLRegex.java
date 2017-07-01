package com.nlp.basic.tools.regex;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLRegex {
	private final static Pattern urlPattern = Pattern.compile(
			"(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)" + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
					+ "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)",
			Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

	public static void main(String[] args) {
		List<String> arry = new ArrayList<String>();
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
		URLRegex urlExtractor = new URLRegex();
		List<String> urls = urlExtractor.extractor(arry);
		for (String url : urls) {
			System.out.println(url);
		}
		assertTrue(urls.size() == 6);
	}

	/**
	 * 抽取操作
	 * 
	 * @author mabaizhang
	 * @date 2017年6月29日
	 */
	public List<String> extractor(List<String> in) {
		List<String> afterPreprocess = preprocess(in);
		List<String> pages = new ArrayList<String>();
		for (String line : afterPreprocess) {
			Matcher m = urlPattern.matcher(line);
			while (m.find()) {
				int matchStart = m.start(1);
				int matchEnd = m.end();
				pages.add(line.substring(matchStart, matchEnd));
			}
		}
		return pages;
	}

	/**
	 * 预处理
	 * 
	 * @author mabaizhang
	 * @date 2017年6月29日
	 */
	public List<String> preprocess(List<String> in) {
		List<String> afterProcess = new ArrayList<String>();
		for (String line : in) {
			String handled = strPreprocess(line);
			if (handled != null && handled.length() > 0) {
				afterProcess.add(handled);
			}
		}
		return afterProcess;
	}

	/**
	 * 字符串预处理
	 * 
	 * @author mabaizhang
	 * @date 2017年6月29日
	 */
	private String strPreprocess(String line) {
		String handled = "";
		if (line != null && line.length() > 0) {
			handled = line.trim();// 去除email的首位空格
		}
		return handled;
	}

}
