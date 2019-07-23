package com.hystrix;

import com.netflix.hystrix.*;

import java.util.Random;

/**
 * 熔断
 */
public class FuseCommand extends HystrixCommand<String> {

    private int count = 10;

    public FuseCommand(String name) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ThreadPoolTestGroup"))// groupKey 表示所属的group，一个group共用线程池
                        .andCommandKey(HystrixCommandKey.Factory.asKey("testCommandKey")) //CommandKey 当前执行方法名
                        .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey(name))
                        .andCommandPropertiesDefaults(
                                HystrixCommandProperties.Setter()
                                        .withCircuitBreakerEnabled(true)//默认是true，本例中为了展现该参数
                                        .withCircuitBreakerForceOpen(false)//默认是false，本例中为了展现该参数
                                        .withCircuitBreakerForceClosed(false)//默认是false，本例中为了展现该参数
                                        .withCircuitBreakerErrorThresholdPercentage(5)//(1)错误百分比超过5%
                                        .withCircuitBreakerRequestVolumeThreshold(10)//(2)10s以内调用次数10次，同时满足(1)(2)熔断器打开
                                        .withCircuitBreakerSleepWindowInMilliseconds(5000)//隔5s之后，熔断器会尝试半开(关闭)，重新放进来请求
//                                .withExecutionTimeoutInMilliseconds(1000)
                        )
                        .andThreadPoolPropertiesDefaults(
                                HystrixThreadPoolProperties.Setter()
                                        .withMaxQueueSize(10)   //配置队列大小
                                        .withCoreSize(2)    // 配置线程池里的线程数
                        )
        );
    }

    @Override
    protected String run() throws Exception {
        Random rand = new Random();
        //模拟错误百分比(方式比较粗鲁但可以证明问题)
        if (1 == rand.nextInt(2)) {
//            System.out.println("make exception");
            throw new Exception("make exception");
        }
        return "running:  ";
    }

    @Override
    protected String getFallback() {
        System.out.println("FAILBACK");
        return "fallback: ";
    }
}