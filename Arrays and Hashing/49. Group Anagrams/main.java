import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();

        long start = System.currentTimeMillis();
        sol.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
        sol.groupAnagrams(new String[] { "" });
        sol.groupAnagrams(new String[] { "a" });
        Main.pl(System.currentTimeMillis() - start);
    }

    public static void pl(Object o) {
        System.out.println(o.toString());
    }
}

class StrSum implements Comparable<StrSum> {
    public String str;
    public int sum;

    StrSum(String str) {
        this.str = str;
        sum = 0;
    }

    public int compareTo(StrSum other) {
        return Integer.valueOf(sum).compareTo(other.sum);
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] primes = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
                83, 89, 97, 101 };
        StrSum[] strSums = new StrSum[strs.length];
        for (int i = 0; i < strs.length; ++i) {
            strSums[i] = new StrSum(strs[i]);
            for (char c : strs[i].toCharArray()) {
                strSums[i].sum += primes[c - 97];
            }
        }
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(strSums);
        result.add(new ArrayList<String>());
        result.get(0).add(strSums[0].str);
        for (int i = 1; i < strSums.length; ++i) {
            if (strSums[i].sum != strSums[i - 1].sum) {
                result.add(new ArrayList<String>());
            }
            result.get(result.size() - 1).add(strSums[i].str);
            Main.pl(strSums[i].str);
        }
        return result;
    }
}