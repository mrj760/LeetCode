
/* 
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106 */

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 });
        solution.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 });
        solution.findMedianSortedArrays(new int[] { 1, 2, 12, 15, 16 }, new int[] { 3, 4, 5, 6, 7, 8 });
        // pl(16 == solution.lengthOfLongestSubstring(
        //         "asdfiuhwepiuyrpbspiauyvgpchiasdfyoiyuwgeoirboiyagvcopqwesdafhguiygaisueytrvbjzbxnckvjyxzcvguygauyebvwrrwermasdfkjhisduyhfoiybfofwfueyvbruoatvgysdfrohasdwqpweuyrtiuwehgfuioysauoyvgcauyswefasdcvavsdaf"));
    }

    public static void pl(Object o) {
        System.out.println(o.toString());
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0;
    }
}