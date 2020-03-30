package cn.zy.note.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契（fibonacci）数列
 * 斐波那契数列是由0和1开始，之后的数就是前两个数的和。
 * 首几个费波那契系数是：
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233…
 * create by park.huang@zkteco.com 2020-03-14 10:57
 **/
public class Fibonacci {

    Map<Integer, Integer> memoryMap = new HashMap<>();

    /**
     * 递归 获取斐波那契第N个数
     * create by park.huang 2020/03/14
     **/
    public int getNByRecursion(int n) throws InterruptedException {
        Thread.sleep(1);
        if (n <= 2) {
            return n - 1;
        }
        return getNByRecursion(n - 1) + getNByRecursion(n - 2);
    }

    /**
     * 记忆化搜索 获取斐波那契第N个数
     * create by park.huang 2020/03/14
    **/
    public int getNbyMemorySearch(int n) throws InterruptedException {
        Thread.sleep(1);
        if (n <= 2) {
            return n - 1;
        }
        if (memoryMap.containsKey(n)) {
            return memoryMap.get(n);
        }
        int n1 = getNbyMemorySearch(n - 1);
        memoryMap.put(n - 1, n1);
        int n2 = getNbyMemorySearch(n - 2);
        memoryMap.put(n - 2, n2);
        return n1 + n2;
    }

    /**
     * DP 获取斐波那契第N个数
     * create by park.huang 2020/03/14
    **/
    public int getNbyDP(int n) throws InterruptedException {
        Thread.sleep(1);
        memoryMap = new HashMap<>(n);
        memoryMap.put(1, 0);
        memoryMap.put(2, 1);
        for (int i = 3; i <= n; i++) {
            memoryMap.put(i, memoryMap.get(i - 1) + memoryMap.get(i - 2));
        }
        return memoryMap.get(n);
    }



    public static void main(String[] args) throws InterruptedException {
        Fibonacci fibonacci = new Fibonacci();
        long time = System.currentTimeMillis();
        System.out.println(fibonacci.getNByRecursion(20));
        System.out.println(System.currentTimeMillis() - time);
        System.out.println();

        time = System.currentTimeMillis();
        System.out.println(fibonacci.getNbyMemorySearch(15));
        System.out.println(System.currentTimeMillis() - time);
        System.out.println();

        time = System.currentTimeMillis();
        System.out.println(fibonacci.getNbyDP(15));
        System.out.println(System.currentTimeMillis() - time);
    }
}
