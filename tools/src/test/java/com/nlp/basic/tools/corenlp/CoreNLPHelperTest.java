package com.nlp.basic.tools.corenlp;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class CoreNLPHelperTest {
    private static CoreNLPHelper helper;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        helper = CoreNLPHelper.getInstance();
    }

    /**
     * 测试分词效果
     *
     * @author mabaizhang
     * @date 2017年6月24日
     */
    @Test
    public void testSegmenter() {
        String text = "副会长，王大山";
        // 必须是ArrayList用以保证顺序固定
        ArrayList<String> segs = helper.segment(text);
        System.out.println(segs);
        assertTrue(!segs.isEmpty());

        text = "百度信息技术有限公司，畅捷通，10086，chanjet";
        segs = helper.segment(text);
        System.out.println(segs);
        assertTrue(!segs.isEmpty());

        text = "TONGWEI，Computer,T ra.rL.B a";
        segs = helper.segment(text);
        System.out.println(segs);
        assertTrue(!segs.isEmpty());

        text = "北京市海淀区北清路68号";
        segs = helper.segment(text);
        System.out.println(segs);
        assertTrue(!segs.isEmpty());
    }

    /**
     * 测试命名实体识别效果
     *
     * @author mabaizhang
     * @date 2017年6月24日
     */
    @Test
    public void testNER() {
        String text = "副会长，王大山";
        // 必须是ArrayList用以保证顺序固定
        ArrayList<String> segs = helper.namedEntity(text);
        System.out.println(segs);

        text = "百度信息技术有限公司";
        segs = helper.namedEntity(text);
        System.out.println(segs);

        text = "我的公司是百度信息技术有限公司";
        segs = helper.namedEntity(text);
        System.out.println(segs);

        text = "TONGWEI，Computer,T ra.rL.B a";
        segs = helper.namedEntity(text);
        System.out.println(segs);

        text = "洪七公刚才在开会，现在已经在工位了";
        segs = helper.namedEntity(text);
        System.out.println(segs);
    }

}
