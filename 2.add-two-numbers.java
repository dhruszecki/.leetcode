/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (40.72%)
 * Likes:    26729
 * Dislikes: 5162
 * Total Accepted:    3.7M
 * Total Submissions: 9.1M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have
 * leading zeros.
 * 
 * 
 */

// @lc code=start

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

/**
 * Definition for singly-linked list.
 */
  class ListNode {
      public int val;
      public ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      @Override
      public String toString() {
          return val + (next!=null ?  "," + next.toString() : "");
      }
  }
 
class Solution {

    public long getIntValue(ListNode ln) {
        long intValue = 0;
        long multiplier = 1;

        ListNode digit = ln;
        do {
            intValue += multiplier * digit.val;
            multiplier*=10;
            digit = digit.next;
        } while (digit !=null);
        
        return intValue;        
    }

    public BigInteger getBigIntValue(ListNode ln) {
        ListNode node = ln;
        String sValue = "";
        do {
            sValue = String.valueOf(node.val + sValue);
            node = node.next;
        } while (node !=null);

        
        
        return new BigInteger(sValue);        
    }

    public ListNode getLNValue(String digits) {
        ListNode node = null;

        for (int i=0 ; i < digits.length() ; i++) {
            ListNode newNode = new ListNode(Character.getNumericValue(digits.charAt(i)), node);
            node = newNode;
        }

        
        return node;
        
    }

    public ListNode addTwoNumbersInt(ListNode l1, ListNode l2) {
        long v1 = getIntValue(l1);
        long v2 = getIntValue(l2);
        long sum  = v1 + v2;
        ListNode ln = getLNValue(String.valueOf(sum));
        return ln;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger v1 = getBigIntValue(l1);
        BigInteger v2 = getBigIntValue(l2);
        BigInteger sum  = v1.add(v2);
        ListNode ln = getLNValue(sum.toString());
        return ln;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1, 
            new ListNode(9, 
            new ListNode(9,
                            new ListNode(9,
                                new ListNode(9, 
                                    new ListNode(9, 
                                        new ListNode(9, 
                                            new ListNode(9, 
                                                new ListNode(9, 
                                                    new ListNode(9))))))))));

        Solution s = new Solution();
        System.out.println(s.addTwoNumbers(l1, l2));
    }
}
// @lc code=end

