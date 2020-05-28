package com.util;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @Author: liupeng
 * @DateTime: Created in 2020/5/28 10:34
 * @version: 1.0
 * @Description: TODO
 */
public class EncodeUtil {

    // java对js进行解码
    // js的原生encodeURI(escape(key)) 编码
    // https://www.cnblogs.com/kiko2014551511/p/11561792.html
    public static void main(String[] args) {
        //原始url
        String url = "%25u597D";
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByExtension("js");
        //解码后url
        String unUrl;
        try {
            unUrl = (String)engine.eval("unescape('"+url+"')");
            System.out.println(unUrl);
            String unUrl2 = (String)engine.eval("unescape('"+unUrl+"')");
            System.out.println(unUrl2);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
