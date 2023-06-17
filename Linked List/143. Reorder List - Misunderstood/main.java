import java.util.LinkedList;
import java.util.Queue;

/*
 * Misunderstood.
 * Was supposed to split linked list by first and second half, reverse second half, then merge lists.
 * Instead, I split by every other node, reversed second list, then merged lists.
 * To fix, alter the splitting portion.
 */

class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();

        ListNode test1 = new ListNode(new int[] { 1, 2, 3, 4, 5 });
        ListNode test2 = new ListNode(new int[] { 1, 2, 3, 4, 5, 6, 7 });
        ListNode test3 = new ListNode(new int[50000]);

        // pl(test1);
        // pl(test2);
        // pl(test3);
        long start = System.currentTimeMillis();
        sol.reorderList(test1);
        sol.reorderList(test2);
        // pl(sol.reverseList(test3));
        // sol.reverseList(test2);
        // sol.reverseList(test3);
        pl(System.currentTimeMillis() - start);
    }

    public static void pl(Object o) {
        System.out.println(o.toString());
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        ListNode cur = this;
        for (int i = 0; i < arr.length - 1; ++i) {
            cur.val = arr[i];
            cur.next = new ListNode();
            cur = cur.next;
        }
        cur.val = arr[arr.length - 1];
    }

    public String toString() {
        String s = "{";
        ListNode cur = this;
        while (cur != null) {
            s += cur.val + (cur.next == null ? "" : ", ");
            cur = cur.next;
        }
        return s + "}";
    }
}

class Solution {

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        Queue<ListNode> q = new LinkedList<>();

        // let cur go out of scope
        {
            ListNode cur = head;
            while (cur != null) {
                q.add(cur);
                cur = cur.next;
            }
        }

        // Separate to two linked lists by even and odd indexes
        ListNode head1 = head, head2 = head.next;
        {
            ListNode cur1 = head1, cur2 = head2;
            while (cur1.next != null || cur2.next != null) {
                cur1.next = q.poll();
                if (cur1.next != null) {
                    cur1 = cur1.next;
                }
                cur2.next = q.poll();
                if (cur2.next != null) {
                    cur2 = cur2.next;
                }
            }
        }

        // Reverse second list
        {
            ListNode prev = null, cur = head2;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            head2 = prev;
        }

        // Merge two lists
        {
            ListNode cur1 = head1, cur2 = head2;
            while (true) {

                ListNode next1 = cur1.next;
                cur1.next = cur2;
                cur1 = next1;

                if (cur1 == null) {
                    break;
                }

                ListNode next2 = cur2.next;
                cur2.next = cur1;
                cur2 = next2;

                if (cur2 == null) {
                    break;
                }
            }
        }
        // Main.pl(head1);
        // Main.pl(head2);
        head = head1;
    }

    public ListNode reverseList(ListNode head) {
        return null;
    }
}