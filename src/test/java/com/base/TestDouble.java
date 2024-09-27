package com.base;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * 描述
 *
 * @author liupeng
 * @version 1.0
 * @date 2022/08/04 16:11:59
 */
public class TestDouble {
    public static void main(String[] args) {
        /*Double num = null;
        BigDecimal d1 = new BigDecimal(Double.toString(num));
        System.out.println(d1.divide(BigDecimal.valueOf(1000)));
        System.out.println(num / 1000);*/
       /* DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                .withZone(ZoneId.systemDefault())
                .withLocale(Locale.CHINA );
        Instant instant = Instant.now();
        String output = formatter.format( instant );
        System.out.println(output);*/
        String str = instantConvertStr(Instant.now(), "yyyy-MM-dd");
        System.out.println(str);
    }

    public static String instantConvertStr(Instant instant, String pattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern)
                .withZone(ZoneId.systemDefault())
                .withLocale(Locale.CHINA );
        String output = formatter.format(instant);
        return output;
    }
}
