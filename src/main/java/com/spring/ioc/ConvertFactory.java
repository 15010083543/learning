package com.spring.ioc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: liupeng
 * @DateTime: 2020/3/30 14:25
 * @Description: TODO
 */
@Service
@Data
public class ConvertFactory {

    @Autowired
    private List<ListConvert> listConverts;

    public ListConvert getListConverter(String type, int id) {
        return listConverts.stream().filter(o -> o.match(type, id)).findFirst().orElse(null);
    }

}
