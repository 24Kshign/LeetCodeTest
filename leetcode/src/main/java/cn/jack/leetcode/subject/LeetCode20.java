package cn.jack.leetcode.subject;

import java.util.Stack;

/**
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class LeetCode20 {

    public static void main(String[] args) {
        String s = "){}(";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s.equals("")) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            // 判断是左括号，入栈
            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            } else {
                // 如果发现是右括号，但是栈中没有左括号
                if (stack.empty()) {
                    return false;
                }
                // 判断栈中的左括号与当前的右括号是否匹配，匹配的话就将栈中的左括号出栈然后进行下一次匹配
                if (character == ')' && stack.peek() == '('
                        || character == ']' && stack.peek() == '['
                        || character == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        // 最后判断栈是否为空
        return stack.empty();
    }
}