import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) {

        long time = System.currentTimeMillis();
        KthLargest kthLargest = new KthLargest(3, new int[] { 4, 5, 8, 2 });
        pl(kthLargest.add(3)); // return 4
        pl(kthLargest.add(5)); // return 5
        pl(kthLargest.add(10)); // return 5
        pl(kthLargest.add(9)); // return 8
        pl(kthLargest.add(4)); // return 8
        pl(System.currentTimeMillis() - time);
    }

    public static void pl(Object o) {
        System.out.println(o.toString());
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

class KthLargest {

    PriorityQueue<Integer> pq;
    char k;

    public KthLargest(int k, int[] nums) {
        this.k = (char) k;
        pq = new PriorityQueue<Integer>(k + 1);
        for (char i = 0; i < nums.length; ++i) {
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (pq.size() < k) {
            pq.add(Integer.MIN_VALUE);
        }
    }

    public int add(int val) {
        pq.add(val);
        pq.poll();
        return pq.peek();
    }
}