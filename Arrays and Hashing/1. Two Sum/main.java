class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();
        int[] arr1 = new int[] { 2, 7, 11, 15 };
        int[] arr2 = new int[] { 3, 2, 4 };
        int[] arr3 = new int[] { 3, 3 };
        int[] arr4 = new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        int[] arr5 = new int[] { 1, 5, -2, -4, 0 };
        int[] arr6 = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr6[i] = i;
        }
        arr6[100000 - 1] = 5;

        long start = System.currentTimeMillis();
        sol.twoSum(arr1, 9);
        sol.twoSum(arr2, 6);
        sol.twoSum(arr3, 6);
        sol.twoSum(arr4, 6);
        sol.twoSum(arr5, -6);
        sol.twoSum(arr6, 100000);
        Main.pl(System.currentTimeMillis() - start);
    }

    public static void pl(Object o) {
        System.out.println(o.toString());
    }
}

class LinkNode {
    public int val;
    public int index;
    public LinkNode next;

    public LinkNode(int val, int index) {
        this.val = val;
        this.index = index;
    }

    public String toString() {
        return "{val: " + val + "} {index: " + index + "}";
    }
}

class ComplementDetector {
    public final int SIZE;
    private LinkNode[] map;

    public ComplementDetector(int size) {
        this.SIZE = size;
        map = new LinkNode[size];
    }

    public LinkNode findComplement(int val, int target) {
        int compl = target - val;
        int mapIndex = compl < 0 ? compl % SIZE * -1 : compl % SIZE;
        if (map[mapIndex] == null) {
            return null;
        }
        if (map[mapIndex].val == compl) {
            return map[mapIndex];
        }
        LinkNode location = map[mapIndex];
        while (location.next != null) {
            if (location.next.val == compl) {
                return location.next;
            }
            location = location.next;
        }
        return null;
    }

    public void insert(int val, int index) {
        int mapIndex = val < 0 ? val % SIZE * -1 : val % SIZE;
        if (map[mapIndex] == null) {
            map[mapIndex] = new LinkNode(val, index);
            return;
        }
        LinkNode location = map[mapIndex];
        while (location.next != null) {
            location = location.next;
        }
        location.next = new LinkNode(val, index);
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int mapSize = 11;
        ComplementDetector detector = new ComplementDetector(nums.length < mapSize ? mapSize : nums.length / mapSize);
        for (int i = 0; i < nums.length; ++i) {
            LinkNode complement = detector.findComplement(nums[i], target);
            if (complement != null) {
                // Main.pl(nums[complement.index] + " + " + nums[i] + " = " + target);
                return new int[] { complement.index, i };
            }
            detector.insert(nums[i], i);
        }
        // Main.pl("Huh?");
        return new int[] {};
    }
}