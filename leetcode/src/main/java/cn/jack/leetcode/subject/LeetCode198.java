package cn.jack.leetcode.subject;

/**
 * 题号：198. 打家劫舍
 * 链接：https://leetcode-cn.com/problems/house-robber/
 * 描述：简单题，动态规划
 */
public class LeetCode198 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 3, 100};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // 定义一个数组，用来保存打劫 0 - (len-1) 家最大能打劫到的金额数
        int[] money = new int[len];
        money[0] = nums[0];
        money[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            money[i] = Math.max(money[i - 2] + nums[i], money[i - 1]);
        }
        return money[len - 1];
    }
}