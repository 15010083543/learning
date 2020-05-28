package com.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author xupengtao
 * @Date 2019/1/7 14:12
 * @Version version 1.0.0
 * 正则表达式
 **/
public class RegexUtil {

    /**
     * 单个结果
     * @param regex
     * @param str
     * @return
     */
    public static String find(String regex,String str){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher =  pattern.matcher(str);
        if(matcher.find()){
            String result = matcher.group(0);
            return StringUtils.trimToEmpty(result);
        }
        return "";
    }

    /**
     * 单个结果
     * @param regex
     * @param str
     * @return
     */
    public static String findgroup(String regex,String str, int index){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher =  pattern.matcher(str);
        if(matcher.find()){
            String result = matcher.group(index);
            return StringUtils.trimToEmpty(result);
        }
        return "";
    }
}
