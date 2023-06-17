
/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 50000
s consists of English letters, digits, symbols and spaces.
 */
import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        pl(solution.lengthOfLongestSubstring("abcabcbb") == 3);
        pl(solution.lengthOfLongestSubstring("bbbbb") == 1);
        pl(solution.lengthOfLongestSubstring("pwwkew") == 3);
        pl(solution.lengthOfLongestSubstring("") == 0);
        pl(solution.lengthOfLongestSubstring("au") == 2);
        pl(solution.lengthOfLongestSubstring("aab") == 2);
        pl(solution.lengthOfLongestSubstring("dvdf") == 3);
        // pl(16 == solution.lengthOfLongestSubstring(
        //         "asdfiuhwepiuyrpbspiauyvgpchiasdfyoiyuwgeoirboiyagvcopqwesdafhguiygaisueytrvbjzbxnckvjyxzcvguygauyebvwrrwermasdfkjhisduyhfoiybfofwfueyvbruoatvgysdfrohasdwqpweuyrtiuwehgfuioysauoyvgcauyswefasdcvavsdaf"));
    }

    public static void pl(Object o) {
        System.out.println(o.toString());
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty())
            return 0;

        final short finishIndex = (short) (s.length() - 1);
        char baseIndex = 0, toIndex = 0, maxLength = 1, length, extraAdd;
        HashSet<Character> existingChars = new HashSet<>();

        for (; baseIndex < finishIndex; ++baseIndex) {
            if (finishIndex - baseIndex < maxLength)
                break;
            char baseChar = s.charAt(baseIndex);
            for (;; ++toIndex) {
                char toChar = s.charAt(toIndex);
                if (existingChars.contains(toChar)) {
                    extraAdd = 0;
                    break;
                }
                if (toIndex == finishIndex) {
                    extraAdd = 1;
                    break;
                }
                existingChars.add(toChar);
            }
            existingChars.remove(baseChar);
            length = (char) (toIndex - baseIndex + extraAdd);
            maxLength = length > maxLength ? length : maxLength;
        }
        return maxLength;
    }
}