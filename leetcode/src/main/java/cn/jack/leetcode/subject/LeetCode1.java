package cn.jack.leetcode.subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题号：1、两数之和
 * 链接：https://leetcode-cn.com/problems/two-sum/
 * 描述：简单题
 */
public class LeetCode1 {

    public static void main(String[] args) {
        int[] nums = {3, 3, 4};
        int[] result = twoSum(nums, 6);
        if (null != result) {
            System.out.println(result[0] + "------" + result[1]);
        }
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

//    private static int[] twoSum(int[] nums, int target) {
//        List<Integer> list = new ArrayList<>();
//        int[] result = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            if (list.contains(target - nums[i])) {
//                result[0] = nums[i];
//                result[1] = target - nums[i];
//                break;
//            } else {
//                list.add(nums[i]);
//            }
//        }
//        int[] index = new int[]{-1, -1};
//        for (int i = 0; i < nums.length; i++) {
//            if (result[0] == nums[i] || result[0] == target - nums[i]) {
//                if (index[1] != -1) {
//                    break;
//                }
//                if (index[0] == -1) {
//                    index[0] = i;
//                } else {
//                    index[1] = i;
//                }
//            }
//        }
//        return index;
//    }
}