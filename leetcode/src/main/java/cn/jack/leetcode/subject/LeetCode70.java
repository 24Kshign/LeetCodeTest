package cn.jack.leetcode.subject;

/**
 * 题号：70. 爬楼梯
 * 链接：https://leetcode-cn.com/problems/climbing-stairs/
 * 描述：简单题，动态规划
 */
public class LeetCode70 {

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(7));
        System.out.println(climbStairs(10));
        System.out.println(climbStairs(23));
        System.out.println(climbStairs(45));
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] steps = new int[n];
        steps[0] = 1;
        steps[1] = 2;
        for (int i = 2; i < n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n - 1];
    }
}