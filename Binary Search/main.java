class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();
        int[] arr = { -1, 0, 3, 5, 9, 12 };
        int[] arr2 = { -1, 0, 5 };

        long start = System.currentTimeMillis();
        pl(sol.search(arr, 9));
        pl(sol.search(arr, 2));
        pl(sol.search(arr2, 0));
        pl("Time: " + (System.currentTimeMillis() - start));
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
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int idx, num;
        while (start <= end) {
            idx = (start + end) / 2;
            num = nums[idx];
            if (num == target) {
                return idx;
            }
            if (target < num) {
                end = idx - 1;
            } else {
                start = idx + 1;
            }
        }
        return -1;
    }
}