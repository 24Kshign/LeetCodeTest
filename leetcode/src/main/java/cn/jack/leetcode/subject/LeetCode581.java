package cn.jack.leetcode.subject;

/**
 * 581. 最短无序连续子数组
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 */
public class LeetCode581 {

    public static void main(String[] args) {
//        int[] nums = {2, 6, 4, 8, 10, 9, 15};
//        int[] nums = {2, 1};
//        int[] nums = {1, 2, 3, 4, 5};
//        int[] nums = {1, 3, 2, 2, 2};
        int[] nums = {1, 3, 2, 2, 2, 4, 4, 5};
        System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return 0;
        }
        int len = nums.length;
        int start = nums[0];
        int end = nums[len - 1];
        int left = 0;
        int right = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] < start) {
                right = i;
            } else {
                start = nums[i];
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] > end) {
                left = i;
            } else {
                end = nums[i];
            }
        }
        if (right - left == 0) {
            return 0;
        }
        return right - left + 1;
    }
}