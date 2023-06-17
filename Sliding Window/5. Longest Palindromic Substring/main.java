class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        pl("bab" == solution.longestPalindrome("babad"));
        pl("bb" == solution.longestPalindrome("cbbd"));
        pl("c" == solution.longestPalindrome("cb"));
        pl("aadadadadadaa" == solution
                .longestPalindrome("uhsdfhhuhhhhuhhuhsadfloihjouasdfaaddadadddaadadaadadadadadaaaddaaddaadad"));
    }

    public static void pl(Object o) {
        System.out.println(o.toString());
    }
}

class Solution {
    public String longestPalindrome(String s) {
        char sLength = (char) s.length();
        switch (sLength) {
            case (1):
                return s;
            case (2):
                return s.charAt(0) == s.charAt(1) ? s : s.charAt(0) + "";
        }
        String longest = s.charAt(0) + "";
        for (int mid = 1; mid < sLength - 1; mid++) {
            int low = mid - 1, high = mid + 1;
            while (s.charAt(low) == s.charAt(high) && low > 0 && high < sLength) {
                low--;
                high++;
            }
            if (s.charAt(low) != s.charAt(high)) {
                low++;
                high--;
            }
            if (s.substring(low, high + 1).length() > longest.length())
                longest = s.substring(low, high + 1);
        }
        Main.pl(longest);
        return longest;
    }
}