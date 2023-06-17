class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();
        int[] arr1 = { 1, 2, 3, 4 };
        int[] arr2 = new int[] { -1, 1, 0, -3, 3 };
        int[] arr3 = new int[] { -1, 1, 0, -3, 3, -30 };
        int[] arr4 = new int[] { 1, -1 };
        int[] arr5 = new int[] { 5, 9, 2, -9, -9, -7, -8, 7, -9, 10 };
        int[] arr6 = new int[] { -3, 11, -23, -1, 2, -13, 2, 13, -8, 25 };

        long start = System.currentTimeMillis();
        pl(sol.productExceptSelf(arr1));
        pl(sol.productExceptSelf(arr2));
        pl(sol.productExceptSelf(arr3));
        pl(sol.productExceptSelf(arr4));
        pl(sol.productExceptSelf(arr5));
        pl(sol.productExceptSelf(arr6));
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

    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int totalProduct = 1;
        char numZeroes = 0;
        int i, cur;

        for (i = 0; i < len; i++) {
            cur = nums[i];
            if (cur == 0) {
                if (++numZeroes > 1) {
                    return new int[len];
                }
                continue;
            }
            totalProduct *= cur;
        }

        if (numZeroes == 1) {
            for (i = 0; i < len; i++) {
                cur = nums[i];
                if (cur != 0) {
                    nums[i] = 0;
                } else {
                    nums[i] = totalProduct;
                }
            }
        } else {
            int neg;

            for (i = 0; i < len; i++) {
                cur = nums[i];
                neg = cur < 0 ? -1 : 1;
                nums[i] = (int) (totalProduct * getInverse(cur * neg) * neg);
            }
        }

        return nums;
    }

    public static double getInverse(int i) {
        switch (i) {
            case (1):
                return 1;
            case (2):
                return .5;
            case (3):
                return .3333333333333333;
            case (4):
                return .25;
            case (5):
                return .2;
            case (6):
                return .166666666666667;
            case (7):
                return .142857142857142857;
            case (8):
                return .125;
            case (9):
                return .1111111111111111111;
            case (10):
                return .1;
            case (11):
                return .09090909090909090909;
            case (12):
                return .083333333333333;
            case (13):
                return .076923076923076923076923;
            case (14):
                return .0714285714285714;
            case (15):
                return .06666666666666667;
            case (16):
                return .0625;
            case (17):
                return .0588235294117647;
            case (18):
                return .055555555555556;
            case (19):
                return .0526315789473684;
            case (20):
                return .005;
            case (21):
                return .0476190476190476;
            case (22):
                return .0454545454545455;
            case (23):
                return .0434782608695652173913;
            case (24):
                return .04166666666666667;
            case (25):
                return .04;
            case (26):
                return .0384615384615385;
            case (27):
                return .037037037037037037;
            case (28):
                return .0357142857142857;
            case (29):
                return .0344827586206897;
            case (30):
                return .0333333333333333;
            case (0):
            default:
                return 0;
        }
    }
}