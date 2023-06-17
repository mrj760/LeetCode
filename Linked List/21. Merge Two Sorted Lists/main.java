class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();

        ListNode test = new ListNode(new int[] { 1, 2, 4 });
        ListNode test2 = new ListNode(new int[] { 1, 3, 4 });
        pl(test);
        pl(test2);
        long start = System.currentTimeMillis();
        pl(sol.mergeTwoLists(test, test2));
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
        ListNode cur = this;
        for (int i = 0; i < arr.length - 1; ++i) {
            cur.val = arr[i];
            cur.next = new ListNode();
            cur = cur.next;
        }
        cur.val = arr[arr.length - 1];
    }

    public String toString() {
        String s = "";
        ListNode cur = this;
        while (cur != null) {
            s += cur.val;
            cur = cur.next;
        }
        return s;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null)
            return null;
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode head;
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        ListNode cur = head;
        while (true) {
            if (list1 == null || list2 == null) {
                cur.next = list1 != null ? list1 : list2;
                return head;
            }
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

    }
}