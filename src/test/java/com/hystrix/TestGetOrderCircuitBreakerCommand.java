package com.hystrix;

import com.netflix.hystrix.HystrixCommand;
import org.junit.Test;

/**
 * Created by wangxindong on 2017/8/15.
 */
public class TestGetOrderCircuitBreakerCommand {

    @Test
    public void testHystrixRongDuan() {
        for(int i=0;i<25;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            HystrixCommand<String> command = new FuseCommand("testCircuitBreaker");
            String result = command.execute();
            //本例子中从第11次，熔断器开始打开
            System.out.println("call times:"+(i+1)+"   result:"+result +" isCircuitBreakerOpen: "+command.isCircuitBreakerOpen());
            //本例子中5s以后，熔断器尝试关闭，放开新的请求进来
        }
    }

    @Test
    public void testHystrixXianLiu() {
        for (int i = 0; i < 25; ++i) {
            HystrixCommand<String> command = new LimitingCommand("-1");
            String result = command.execute();
            System.out.println("call times:"+(i+1)+"   result:"+result +" isCircuitBreakerOpen: "+command.isResponseRejected());

            HystrixCommand<String> command2 = new LimitingCommand("-2");
            String result2 = command2.execute();
            System.out.println("call times:"+(i+1)+"   result:"+result2 +" isCircuitBreakerOpen: "+command2.isResponseRejected());
        }
        // 防止主线程提前结束执行
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}