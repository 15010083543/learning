package com.base.io;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @Author: liupeng
 * @DateTime: 2020/4/16 10:15
 * @Description: TODO
 */
@Slf4j
public class ReadFileTest {

    public static Map<String, String> cityInfos;

    public static void main(String[] args) {
        initCityMapping();
    }


    private static void initCityMapping() {
        //String configPath = System.getProperty("config.path");
        try {
            log.info("initCityMapping start.....");
            try {
                File dicFile = new File("/config/gj_city.json");
                if (dicFile.exists()) {
                    String dic = FileCopyUtils.copyToString(new InputStreamReader(
                            new FileInputStream(dicFile),
                            StandardCharsets.UTF_8));
                    cityInfos = JSONObject.parseObject(dic, Map.class);
                }
            } catch (Exception e) {
                log.error("加载城市信息失败,{}", e.getMessage(), e);
                e.printStackTrace();
            }
            log.info("initCityMapping end.....");
        } catch (Exception e) {
            log.info("初始化城市字典数据失败！", e);
        }
    }
}
