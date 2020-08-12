package com.base;

import com.util.RegexUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: liupeng
 * @DateTime: 2020/4/4 18:20
 * @Description: TODO
 */
public class RegexTest {

    @Test
    public  void mains() {
      String url = "300_1000";
      String result = revoseSuffix(url);
        String url1 = "0_1000)%20AND%209970%3D1318%20AND%20(1372%3D1372}";
        String result1 = revoseSuffix(url1);
        String url2 = "300_*";
        String result2 = revoseSuffix(url2);
        String url3 = "300_300.12";
        String result3 = revoseSuffix(url3);
        String url4 = "300_aa";
        String result4 = revoseSuffix(url4);
    }

    private String revoseSuffix(String seoPath){
        String regex = "[0-9]{1,}_(([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9]))";//(subway(\\d+" + "|(\\d+_\\d+)))/";
        String subwayLine = RegexUtil.find(regex, seoPath);
        // 处理来源
        String agent = RegexUtil.find(regex, seoPath);
        System.out.println(agent);
        return agent;
    }

    private Map<String, String> revoseSeoPath(String seoPath){
        Map<String, String> map = new HashMap<>();
        seoPath = "/" + seoPath;
        // 处理地铁
        String regex = "/(subway(\\d+" + "|(\\d+_\\d+)))/";
        String subwayLine = RegexUtil.find(regex, seoPath);
        // 处理来源
        String agent = RegexUtil.findgroup("/([0|1])/", seoPath, 1);
        StringBuilder stringBuilder = new StringBuilder();
        if (StringUtils.isNotBlank(subwayLine)) {
            stringBuilder.append(subwayLine);
            seoPath = seoPath.replaceFirst(subwayLine, "/");
        }
        if (StringUtils.isNotBlank(agent)) {
            stringBuilder.append(agent).append("/");
            seoPath = seoPath.replaceFirst(agent + "/", "");
        }
        map.put("finalSeoPrefix", stringBuilder.toString());
        map.put("finalSeoPath", seoPath.length() > 1 ? seoPath.substring(1) : "");
        return map;
    }

    public String buildseopathSort(String seopath){
        StringBuilder seopathStr = new StringBuilder();
        // 先处理地铁
        String regex = "/(subway(\\d+" + "|(\\d+_\\d+)))/";
        String subwayLine = RegexUtil.findgroup(regex, seopath, 1);
        if (StringUtils.isNotBlank(subwayLine)) {
            seopathStr.append(subwayLine).append("/");
            seopath = seopath.replaceFirst(subwayLine + "/", "/");
        }
        // 处理个人、经纪人
        String agent = RegexUtil.findgroup("/([0|1])/", seopath, 1);
        if (StringUtils.isNotBlank(agent)) {
            seopathStr.append(agent).append("/");
        }
        Pattern pattern = Pattern.compile("/(([c-z]\\d+)+)/");
        Matcher matcher = pattern.matcher(seopath);
        if (matcher.find()) {
            seopathStr.append(matcher.group(1) + "/");
        }
        return seopathStr.toString();
    }

    @Test
    public void test(){
        List<String> testArray = null;
        testArray = new ArrayList<>();
        testArray.add("1");
        Optional.ofNullable(testArray).orElse(new ArrayList<>()).forEach(x -> System.out.println(x));
        System.out.println("ppppppppp");

        /*String seoPath = "https://3g.ganji.com/bj_shangpu/0/t2s2z2f3/?params166=1";
        String url = seoPath.replaceFirst("[shangpucz|shangpu]", "shangpucs");
        System.out.println(url);*/
        // 处理
        // jiage = RegexUtil.findgroup("([t]\\d+)", seoPath, 1);
        //System.out.println(jiage);
        /*String seopath = "0/subway8_2081/t2m1f1s2h123/";
        String lastSeoPath = buildseopathSort("/" + seopath);
        System.out.println(lastSeoPath);*/
       /* String cityAndCate = "/bj_zhaozu/1/pve_1092_2/m4s3t2/";
        String regex = "/([a-z]+)_([a-z]+)/";
        String cityResult = RegexUtil.find(regex, cityAndCate);
        String city = "";
        String cate = "";
        if (StringUtils.isNotBlank(cityResult)) {
            city = RegexUtil.findgroup(regex, cityAndCate, 1);
            cate = RegexUtil.findgroup(regex, cityAndCate, 2);
        } else {
            String[] cityAndCateArray =  cityAndCate.split("/");
            city = cityAndCateArray[1];
            cate = cityAndCateArray[2];
        }
        System.out.println(city + "---" + cate);*/

        //return "cn";

        /*ReentrantReadWriteLock reentrantLock =new ReentrantReadWriteLock();

        String url = "https://sh.58.com/changfang/b3/?&params166=1&&&PGTID=0d30576d-0000-26f1-4794-55ca1b8dd7b2&ClickID=2";
        url = url.replaceAll("params16[4|5|6]=1", "");
        url = url.replaceAll("[&]+", "&");
        System.out.println(url);*/
        /*List<String> list = new ArrayList<>();
        list.clear();
        Set<String> set = new HashSet<>();
        set.add("1");*/
        /*String regex = "http[s]{0,1}://([0-9|a-z]+.)+com/";
        String url = "https://3g.ganji.com/subway41/shangpucs/0/h511575l2m4s53/";
        String urls = find(regex, url);
        System.out.println(urls);*/

        /*String requestURL = "/a/bb/cc11/";
            String regex = "/([a-z]+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(requestURL);
            while (matcher.find()) {
                System.out.println(matcher.group(1));

            }*/


        //revoseSeoPath("0/subway1/m4s3/");

       /* String str = "/0/subway1/m4s3/";
        String regex = "/([0|1])/";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        //String a = matcher.group(0);

        if(matcher.find()){
            String result = matcher.group(0);
            String finalResult = StringUtils.trimToEmpty(result);
            String result1 = matcher.group(1);
            System.out.println(result1);
        }*/
        /*String regex = "(subway(\\d+" + "|(\\d+_\\d+)))/";
        String value = "/subway58_11/zhaozu/pve_1582_3/m5/";
        String replace = value.replaceFirst(regex, "").replaceAll("//", "/");
        System.out.println(replace);*/
    }

    public String find(String regex,String str){
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
