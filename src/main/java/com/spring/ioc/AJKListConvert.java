package com.spring.ioc;

import org.springframework.stereotype.Service;

/**
 * @Author: liupeng
 * @DateTime: 2020/3/30 14:21
 * @Description: TODO
 */
@Service
public class AJKListConvert implements ListConvert {

    @Override
    public Boolean match(String type, int id) {
        return "ajk".equals(type) || id == 2;
    }

    @Override
    public ListConvert getListConvert(String type, int id) {
        return null;
    }
}
