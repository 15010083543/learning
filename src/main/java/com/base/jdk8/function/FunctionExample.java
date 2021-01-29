package com.base.jdk8.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: liupeng
 * @DateTime: Created in 2021/1/29 17:04
 * @version: 1.0
 * @Description: TODO
 */
public class FunctionExample {
    public static <T,R> List<R> multiGetResult(List<Function<List<T>, R>> functions, List<T> list) {
        return functions.stream().map(f -> f.apply(list)).collect(Collectors.toList());
    }

    //怎样在一行代码里同时计算一个列表的和、最大值、最小值、平均值、元素个数、奇偶分组、指数、排序呢？
    /*
    [IntSummaryStatistics{count=9, sum=285, min=1, average=31.666667, max=81},
    [1, 4, 9, 16, 25, 36, 49],
    {even=[64, 16, 4, 36],
    odd=[49, 25, 9, 1, 81]},
    [1, 4, 9, 16, 25, 36, 49, 64, 81],
    {8.0=256.0, 4.0=16.0, 2.0=4.0, 1.0=2.0, 9.0=512.0, 5.0=32.0, 6.0=64.0, 3.0=8.0, 7.0=128.0}]
     */
    public static void main(String[] args) {
        System.out.println(multiGetResult(
                Arrays.asList(
                        list -> list.stream().collect(Collectors.summarizingInt(x->x)),
                        list -> list.stream().filter(x -> x < 50).sorted().collect(Collectors.toList()),
                        list -> list.stream().collect(Collectors.groupingBy(x->(x%2==0? "even": "odd"))),
                        list -> list.stream().sorted().collect(Collectors.toList()),
                        list -> list.stream().sorted().map(Math::sqrt).collect(Collectors.toMap(x->x, y->Math.pow(2,y)))),
                Arrays.asList(64,49,25,16,9,4,1,81,36)));
    }
}
