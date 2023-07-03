class Main {
    public static void main(String[] args) {

        KthLargest kthLargest = new KthLargest(3, new int[] { 4, 5, 8, 2 });
        kthLargest.add(3); // return 4
        kthLargest.add(5); // return 5
        kthLargest.add(10); // return 5
        kthLargest.add(9); // return 8
        kthLargest.add(4); // return 8
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

    class Node {
        int val;
        Node next, prev;

        Node(int val) {
            this.val = val;
        }

        public String toString() {
            String s = "{ ";
            int k = 1;
            Node trav = this;
            while (trav != null) {
                s += "[k" + k++ + "," + trav.val + "] ";
                trav = trav.next;
            }
            s += "}";
            return s;
        }
    }

    Node head;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        if (nums.length == 0) {
            return;
        }
        int i = -1;
        while (++i < nums.length) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        //Main.pl("Adding " + val);
        if (head == null) {
            head = new Node(val);
            //Main.pl(head.toString());
            //Main.pl(val);
            return val;
        }
        //Main.pl(head.toString());
        Node trav = head;
        int ktracker = 0;
        while (val < trav.val) {
            if (++ktracker == k) {
                //Main.pl(head.toString());
                //Main.pl(trav.val);
                return trav.val;
            }
            if (trav.next == null) {
                trav.next = new Node(val);
                trav.next.prev = trav;
                //Main.pl(head.toString());
                //Main.pl(val);
                return val;
            }
            trav = trav.next;
        }
        Node before = new Node(val);
        if (trav == head) {
            before.next = trav;
            head = before;
            trav.prev = before;
        } else {
            before.prev = trav.prev;
            trav.prev.next = before;
            before.next = trav;
            trav.prev = before;
        }
        // ktracker--;
        while (++ktracker < k) {
            if (trav.next == null) {
                //Main.pl("next null, k" + ++ktracker + " " + trav.val);
                //Main.pl(head.toString());
                //Main.pl(trav.val);
                return trav.val;
            }
            trav = trav.next;
        }
        //Main.pl(trav.val + " k" + ktracker);
        trav.prev.next = null;
        //Main.pl(head.toString());
        //Main.pl(trav.prev.val);
        return trav.prev.val;
    }
}