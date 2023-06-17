import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();
        int[] arr1 = { 1, 1, 1, 2, 2, 3 };
        int[] arr2 = new int[] { 1 };
        int[] arr3 = new int[] { 1, 2, 3, 4, 4, 4, 5, 5, 5, 6, 6 };

        long start = System.currentTimeMillis();
        pl(sol.topKFrequent(arr1, 2));
        pl(sol.topKFrequent(arr2, 1));
        pl(sol.topKFrequent(arr3, 3));
        pl(System.currentTimeMillis() - start);
    }

    public static void pl(Object o) {
        System.out.println(o.toString());
    }

    public static void pl(int[] nums) {
        String s = "{";
        for (int i = 0; i < nums.length - 1; i++) {
            s += nums[i] + ", ";
        }
        s += nums[nums.length - 1] + "}";
        Main.pl(s);
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>(k);
        Integer count;
        for (int i = 0; i < nums.length; i++) {
            count = counts.get(nums[i]);
            if (count == null) {
                count = 0;
            }
            counts.put(nums[i], count + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(counts.entrySet());
        list.sort(Map.Entry.comparingByValue());
        int[] kmost = new int[k];
        for (int fromStartOfArr = 0, fromBackOfList = list.size() - 1; fromStartOfArr < k;) {
            kmost[fromStartOfArr++] = list.get(fromBackOfList--).getKey();
        }
        return kmost;
    }
}