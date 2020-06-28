package com.helius.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author Helius
 * @Create 2020-06-04-9:43 下午
 */

public class StreamTest2 {

    @Test
    public void test01() {
        List<String> list = Arrays.asList("a", "b", "c");
        list.forEach(e -> System.out.println(e));

        list.stream().filter(e -> "a".equals(e)).count();
    }

    @Test
    public void foreachTest() {
        List<String> skills = Arrays.asList("java", "golang", "c++", "c", "python");
        // 使用 Lambda 之前
        for (String skill : skills) {
            System.out.print(skill+",");
        }
        System.out.println();
        // 使用 Lambda 之后
        // 方式1,forEach+lambda
        skills.forEach((skill) -> System.out.print(skill));
        System.out.println();
        // 方式2，forEach+方法引用
        skills.forEach(System.out::print);
    }

    @Test
    public void streamTest() {
        List<String> skills = Arrays.asList("java", "golang", "c++", "c", "python", "java");
        // Jdk8 之前
        for (String skill : skills) {
            System.out.print(skill + ",");
        }
        System.out.println();
        // Jdk8 之后-去重遍历
        skills.stream().distinct().forEach(skill -> System.out.print(skill + ","));
        System.out.println();
        // Jdk8 之后-去重遍历
        skills.stream().distinct().forEach(System.out::print);
        System.out.println();
        // Jdk8 之后-去重，过滤掉 ptyhon 再遍历
        skills.stream().distinct().filter(skill -> skill != "python").forEach(skill -> System.out.print(skill + ","));
        System.out.println();
        // Jdk8 之后转字符串
        String skillString = String.join(",", skills);
        System.out.println(skillString);
    }

    /**
     * 数据转换
     */
    @Test
    public void mapTest() {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);
        // 数据转换
        numList.stream().map(num -> num * num).forEach(num -> System.out.print(num + ","));

        System.out.println();

        // 数据收集
        Set<Integer> numSet = numList.stream().map(num -> num * num).collect(Collectors.toSet());
        numSet.forEach(num -> System.out.print(num + ","));
    }

    /**
     * 数学计算测试
     */
    @Test
    public void mapMathTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        IntSummaryStatistics stats = list.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("最小值：" + stats.getMin());
        System.out.println("最大值：" + stats.getMax());
        System.out.println("个数：" + stats.getCount());
        System.out.println("和：" + stats.getSum());
        System.out.println("平均数：" + stats.getAverage());
        // 求和的另一种方式
        Integer integer = list.stream().reduce((sum, cost) -> sum + cost).get();
        System.out.println(integer);
    }

}
