/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (40.27%)
 * Likes:    20555
 * Dislikes: 1280
 * Total Accepted:    3.5M
 * Total Submissions: 8.6M
 * Testcase Example:  '"()"'
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "(]"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 * 
 * 
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    public boolean isValid(String s) {
        Queue<Character> visited = new LinkedList<>();        
        Map<Character, Character> symbols = Map.of('}', '{', ')', '(', ']', '[');

        for (int i = 0; i < s.length(); i++) {
            if (symbols.containsKey(s.charAt(i)))
                visited.add(s.charAt(i));
            else {
                Character prev = visited.poll();
                if (!symbols.get(symbols).equals(prev))
                    return false;                
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(new Solution().isValid(s));
    }
}
// @lc code=end

