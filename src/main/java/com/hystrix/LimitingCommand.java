package com.hystrix;

import com.netflix.hystrix.*;
import org.apache.commons.lang3.math.NumberUtils;

// 限流
public class LimitingCommand extends HystrixCommand<String> {
 
    private String productId;
 
    private static final HystrixCommandKey KEY = HystrixCommandKey.Factory.asKey("GetProductInfoCommand");
 
    public LimitingCommand(String productId) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ProductInfoService"))
                .andCommandKey(KEY)
                // 线程池相关配置信息
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        // 设置线程池大小为8
                        .withCoreSize(8)
                        // 设置等待队列大小为10
                        .withMaxQueueSize(10)
                        .withQueueSizeRejectionThreshold(12))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerEnabled(true)
                        .withCircuitBreakerRequestVolumeThreshold(20)
                        .withCircuitBreakerErrorThresholdPercentage(40)
                        .withCircuitBreakerSleepWindowInMilliseconds(3000)
                        // 设置超时时间
                        .withExecutionTimeoutInMilliseconds(20000)
                        // 设置fallback最大请求并发数
                        .withFallbackIsolationSemaphoreMaxConcurrentRequests(30)));
        this.productId = productId;
    }
 
    @Override
    protected String run() throws Exception {
        if (NumberUtils.toInt(productId) == -1L) {
            throw new Exception();
        }
        // 请求过来，会在这里hang住3秒钟
        if (NumberUtils.toInt(productId) == -2L) {
            Thread.sleep(3);
        }
        return "get String";
    }
 
    @Override
    protected String getFallback() {
        System.out.println("进入限流方法");
        return "限流";
    }
}