import java.util.ArrayList;

/*
 * Remove nth from last node
 * There are between 1 and 30 nodes
 * n is between 1 and list len
 */

class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();

        ListNode test1 = new ListNode(new int[] { 1, 2, 3, 4, 5 });
        ListNode test2 = new ListNode(new int[] { 1 });
        ListNode test3 = new ListNode(new int[] { 1, 2 });
        ListNode test4 = new ListNode(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });

        long start = System.currentTimeMillis();
        pl(sol.removeNthFromEnd(test1, 2));
        pl(sol.removeNthFromEnd(test2, 1) == null);
        pl(sol.removeNthFromEnd(test3, 1));
        pl(sol.removeNthFromEnd(test4, 4));
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
            // Main.pl(cur.val);
        }
        return s + "}";
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ArrayList<ListNode> al = new ArrayList<>();

        ListNode cur = head;
        while (cur != null) {
            al.add(cur);
            cur = cur.next;
        }

        int len = al.size();
        int idx = len - n;

        if (n == len) {
            head = head.next;
        } else if (n == 1) {
            al.get(idx - 1).next = null;
        } else {
            al.get(idx - 1).next = al.get(idx + 1);
        }

        return head;
    }
}
