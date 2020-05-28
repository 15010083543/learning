package com.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class IpUtil {
       /**
        * Get the real remote client's IP
        *
        * @param request
        * @return
        */
       public static String getClientIP(HttpServletRequest request) {
           String ip = null;
           if (null != request.getHeader("x-forwarded-for")
                   && !"127.0.0.1".equals(request.getHeader("x-forwarded-for"))) {
               ip = request.getHeader("x-forwarded-for");
               ip = StringUtils.split(ip, ",")[0];
           } else if (null != request.getHeader("x-real-ip")) {
               ip = request.getHeader("x-real-ip");
           } else if (null != request.getHeader("clientip")) {
               ip = request.getHeader("clientip");
           } else if (null != request.getRemoteAddr()) {
               ip = request.getRemoteAddr();
           }

           int pos = ip.indexOf(',');
           if (pos > 0) {
               ip = ip.substring(0, pos);
           }
           pos = ip.indexOf(':');
           if (pos > 0) {
               ip = ip.substring(0, pos);
           }
           return ip.trim();
       }
}