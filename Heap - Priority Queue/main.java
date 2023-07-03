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
            int idx = 0;
            Node trav = this;
            while (trav != null) {
                s += "[" + idx++ + "," + trav.val + "] ";
                trav = trav.next;
            }
            s += "}";
            return s;
        }
    }

    Node head, knode;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        // if (nums.length == 0) {
        //     this.kval = 0;
        //     return;
        // }
        if (nums.length == 0) {
            return;
        }
        int i = -1;
        while (++i < nums.length) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        Main.pl("Adding " + val);
        if (head == null) {
            Main.pl("Create head");
            head = new Node(val);
            knode = head;
            return val;
        }
        Main.pl("===Before===\n" + head.toString());
        Node trav = head;
        int ktracker = 1;
        while (true) {
            if (val > trav.val) {
                Main.pl("larger");
                Node before = new Node(val);
                if (trav == head) {
                    head = before;
                } else {
                    trav.prev.next = before;
                }
                trav.prev = before;
                if (ktracker == k) {
                    Main.pl("inserting before knode");
                    knode = before;
                } else {
                    before.next = trav;
                    trav = knode;
                    for (int i = k; i > ktracker; --i) {
                        if (trav.prev == null) {
                            Main.pl(head.toString() + " KNode " + knode.val + "\n===End===");
                            return knode.val;
                        }
                        trav = trav.prev;
                    }
                    knode = trav;
                    knode.next = null;
                }
                Main.pl(head.toString() + " KNode " + knode.val + "\n===End===");
                return knode.val;
            }
            if (ktracker++ == k) {
                Main.pl("reached k " + k);
                if (val > trav.val) {
                    Main.pl("replace val");
                    trav.val = val;
                }
                Main.pl(head.toString() + " KNode " + knode.val + "\n===End===");
                return knode.val;
            }
            if (trav.next == null) {
                Main.pl("next is null");
                trav.next = new Node(val);
                knode = trav.next;
                knode.prev = trav;
                Main.pl(head.toString() + " KNode " + knode.val + "\n===End===");
                return val;
            }
            Main.pl("next");
            trav = trav.next;
        }
    }
}