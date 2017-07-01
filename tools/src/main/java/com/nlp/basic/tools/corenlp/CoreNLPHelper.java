package com.nlp.basic.tools.corenlp;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.PropertiesUtils;
import edu.stanford.nlp.util.TypesafeMap.Key;

public class CoreNLPHelper {
	private final static CoreNLPHelper instance = new CoreNLPHelper();
	private Properties props;
	private StanfordCoreNLP corenlp;

	/**
	 * 单一示例化抽取工具，这很重要，因为coreNLP工具加载很耗时， 因此采用饥饿单一模式，保证服务启动就加载该工具
	 * 
	 * @author mabaizhang
	 * @date 2017年6月24日
	 */
	public static CoreNLPHelper getInstance() {
		return instance;
	}

	/**
	 * 私有化声明方法
	 * 
	 * @author mabaizhang
	 * @date 2017年6月24日
	 */
	private CoreNLPHelper() {
		this.props = PropertiesUtils.asProperties("props", "StanfordCoreNLP-chinese.properties");
		this.corenlp = new StanfordCoreNLP(this.props);
	}

	/**
	 * 分词
	 * 
	 * @author mabaizhang
	 * @date 2017年6月24日
	 */
	public ArrayList<String> segment(String text) {
		ArrayList<String> words = actions(text, TextAnnotation.class);
		return words;
	}

	/**
	 * 命名实体识别
	 * 
	 * @author mabaizhang
	 * @date 2017年6月24日
	 */
	public ArrayList<String> namedEntity(String text) {
		ArrayList<String> ners = actions(text, NamedEntityTagAnnotation.class);
		return ners;
	}

	/**
	 * 词性标注，用于对于邮箱进行识别
	 * 
	 * @author mabaizhang
	 * @date 2017年6月24日
	 */
	public ArrayList<String> pos(String text) {
		ArrayList<String> poss = actions(text, PartOfSpeechAnnotation.class);
		return poss;
	}

	/**
	 * 采用coreNLP进行相关操作
	 * 
	 * @author mabaizhang
	 * @date 2017年6月24日
	 */
	private ArrayList<String> actions(String text, Class<? extends Key<String>> arg0) {
		Annotation document = new Annotation(text);
		this.corenlp.annotate(document);
		List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
		ArrayList<String> actions = new ArrayList<String>();
		for (CoreMap sentence : sentences) {
			for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
				String action = token.get(arg0);
				if (action != null && action.length() > 0) {
					actions.add(action);
				}
			}
		}
		return actions;
	}
}
