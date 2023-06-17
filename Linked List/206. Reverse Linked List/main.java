class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();

        ListNode test1 = new ListNode(new int[] { 1, 2, 3, 4, 5 });
        ListNode test2 = new ListNode(new int[] { 1, 2 });
        ListNode test3 = new ListNode(new int[50000]);
        // pl(test1);
        // pl(test2);
        // pl(test3);
        long start = System.currentTimeMillis();
        pl(sol.reverseList(test1));
        pl(sol.reverseList(test2));
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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}