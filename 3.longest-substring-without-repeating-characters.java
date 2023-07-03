/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int lengthOfLongestSubstring(String s) {
    
        final Map<Character, Integer> chars = new HashMap<>();
        int longest = 0;
        int begin = 0;        
    
        
        for (int i=0 ; i < s.length() ; i++) {
            char current = s.charAt(i);           
            char next;

            chars.put(current,i);
            
            // Estoy en el ultimo caracter o el proximo es repetido
            if ((s.length()-1==i))                
                return getActualSize(longest, begin, i);  
            
            next = s.charAt(i+1);
            if (chars.containsKey(next) && chars.get(next) >= begin) {
                longest = getActualSize(longest, begin, i);  

                // Si no estoy en la última posicion ,muevo el inicio al caracter
                // siguiente al repetido
                if (s.length()-1 > i) {
                    begin = chars.get(s.charAt(i+1)) + 1;
                }
            }
        }

        return longest;
    }

    private int getActualSize(int longest, int begin, int i) {
        // calculo el tamaño
        int actualSize  = i + 1 - begin;
        if (actualSize > longest)             
            longest = actualSize;
        return longest;
    } 

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaa";    



        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}
// @lc code=end

