package com.hystrix;

import com.netflix.hystrix.*;
import org.apache.commons.lang3.math.NumberUtils;

// 限流
public class LimitingCommand extends HystrixCommand<String> {
 
    private String productId;
 
    public LimitingCommand(String productId) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ProductInfoService"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("GetProductInfoCommand"))
                // 线程池相关配置信息
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        // 设置线程池大小为8
                        .withCoreSize(8)
                        // 设置等待队列大小为12
                        .withMaxQueueSize(12)
                        .withQueueSizeRejectionThreshold(15))
                //此属性设置队列大小拒绝阈值 - 即使未达到maxQueueSize也将发生拒绝的人为最大队列大小。 此属性存在，因为BlockingQueue的maxQueueSize不能动态更改，我们希望允许您动态更改影响拒绝的队列大小。
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerEnabled(true)
                        .withCircuitBreakerRequestVolumeThreshold(30)
                        .withCircuitBreakerErrorThresholdPercentage(40)
                        .withCircuitBreakerSleepWindowInMilliseconds(3000)
                        // 设置超时时间
                        .withExecutionTimeoutInMilliseconds(500)
                        // 设置fallback最大请求并发数
                        .withFallbackIsolationSemaphoreMaxConcurrentRequests(30)));
        this.productId = productId;
    }

/*
/@HystrixCommand(fallbackMethod = "noticesFallBack",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "200"),
                    @HystrixProperty(name = "maximumSize", value = "250"),
                    @HystrixProperty(name = "maxQueueSize", value = "200"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "200"),
                    @HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "true") // 默认false, 如果不设置该参数maximumSize=coreSize
            },
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10"),   //（出错百分比阈值，当达到此阈值后，开始短路。默认50%）
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "20"),      // 在统计数据之前，必须在10秒内发出3个请求。  默认是20
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"), //（短路多久以后开始尝试是否恢复，默认5s）
                    @HystrixProperty(name = "execution.timeout.enabled", value = "true"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "900"), //线程执行超时时间，默认为1s，应该可满足99.5%的请求
                    @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "25")    //执行fallback方法的semaphore数量
            })
根据Hystrix参数的配置说明和线程池的配置策略，具体参数配置规则如下：

核心线程数=峰值每秒的请求数健康状况下99%的响应时间
缓冲线程=核心线程数2/8
最大线程数=核心线程数+缓冲线程
队列长度=核心线程数
容忍错误率为:10%
熔断器恢复时间，默认5s
超时时间设为: 可满足99.5%的访问延时，同时延时在可接受范围之内
降级并发量=最大线程数*错误容忍率

具体参数配置，不同的场景和应用，有不同的tradeoffs方案, 以实际压测数据为准。如果在真是环境中，如果配置失效，可以动态的调整配置参数。
*/
 
    @Override
    protected String run() throws Exception {
        if (NumberUtils.toInt(productId) == -1L) {
            // throw new Exception();
        }
        // 请求过来，会在这里hang住3秒钟
        if (NumberUtils.toInt(productId) == -2L) {
            System.out.println("---");
            //Thread.sleep(5);
        }
        return "get String";
    }
 
    @Override
    protected String getFallback() {
        System.out.println("进入限流方法");
        return "限流";
    }
}