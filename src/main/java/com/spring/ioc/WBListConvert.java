package com.spring.ioc;

import org.springframework.stereotype.Service;

/**
 * @Author: liupeng
 * @DateTime: 2020/3/30 14:20
 * @Description: TODO
 */
@Service
public class WBListConvert implements ListConvert {

    @Override
    public Boolean match(String type, int id) {
        return "wb".equals(type) || id == 1;
    }

    @Override
    public ListConvert getListConvert(String type, int id) {
        return null;
    }
}
