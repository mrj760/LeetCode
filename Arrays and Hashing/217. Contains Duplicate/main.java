class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();
        int[] arr1 = { 1, 2, 3, 4, 5, 7, 1 };
        int[] arr2 = new int[] { 1, 2, 3, 1 };
        int[] arr3 = new int[] { 1, 2, 3, 4 };
        int[] arr4 = new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        int[] arr5 = new int[] { 1, 5, -2, -4, 0 };
        int[] arr6 = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr6[i] = i;
        }
        arr6[100000 - 1] = 5;

        long start = System.currentTimeMillis();
        pl(sol.containsDuplicate(arr1));
        pl(sol.containsDuplicate(arr2));
        pl(sol.containsDuplicate(arr3));
        pl(sol.containsDuplicate(arr4));
        pl(sol.containsDuplicate(arr5));
        pl(sol.containsDuplicate(arr6));
        pl(System.currentTimeMillis() - start);
    }

    public static void pl(Object o) {
        System.out.println(o.toString());
    }
}

class LinkNode {
    public int val;
    public LinkNode next;

    public LinkNode(int val) {
        this.val = val;
    }
}

class DuplicateDetector {
    public final int SIZE;
    private LinkNode[] map;

    public DuplicateDetector(int size) {
        this.SIZE = size;
        map = new LinkNode[size];
    }

    public boolean insert(int val) {
        final int index = val >= 0 ? val % SIZE : val % SIZE * -1;
        if (map[index] == null) {
            map[index] = new LinkNode(val);
            return true;
        }
        LinkNode location = map[index];
        if (location.val == val) {
            return false;
        }
        while (location.next != null) {
            if (location.next.val == val) {
                return false;
            }
            location = location.next;
        }
        location.next = new LinkNode(val);
        return true;
    }
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        int mapSize = 11;
        DuplicateDetector detector = new DuplicateDetector(nums.length < mapSize ? mapSize : nums.length / mapSize);
        for (int i : nums) {
            if (!detector.insert(i))
                return true;
        }
        return false;
    }
}