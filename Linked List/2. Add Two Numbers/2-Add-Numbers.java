import java.util.ArrayList;

class Util {
    public static void pl(Object o) {
        System.out.println(o.toString());
    }
}

class Main {
    public static void main(String[] args) {
        runTest(new int[] { 2, 4, 3 }, new int[] { 5, 6, 4 });
        runTest(new int[] { 9 }, new int[] { 1, 9, 9, 9, 9, 9, 9, 9, 9, 9 });
    }

    public static void runTest(int[] array1, int[] array2) {
        ListNode list1 = new ListNode(array1);
        // System.out.println(list1.toString());
        ListNode list2 = new ListNode(array2);
        Util.pl(new Solution().addTwoNumbers(list1, list2));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int value) {
        this.val = value;
    }

    ListNode(int value, ListNode next) {
        this.val = value;
        this.next = next;
    }

    ListNode(int[] array) {
        ListNode current = this;
        for (int index = 0; index < array.length; index++) {
            current.val = array[index];
            if (index == array.length - 1)
                break;
            current = current.next = new ListNode();
        }
    }

    @Override
    public String toString() {
        String result = "";
        ListNode copy = this;
        while (copy != null) {
            result += copy.val;
            copy = copy.next;
        }
        return result;
    }
}

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Util.pl("Using : " + l1.toString() + ", " + l2.toString());
        ListNode resultHead = new ListNode();
        ListNode workingNode = resultHead;
        while (true) {
            if (l1 == null && l2 == null) {
                break;
            } //
            else if (l1 == null) {
                workingNode.val += l2.val;
                // Util.pl(0 + "+" + l2.val + "=" + workingNode.val);
                l2 = l2.next;
            } //
            else if (l2 == null) {
                workingNode.val += l1.val;
                // Util.pl(l1.val + "+" + 0 + "=" + workingNode.val);
                l1 = l1.next;
            } //
            else {
                workingNode.val += l1.val + l2.val;
                // Util.pl(l1.val + "+" + l2.val + "=" + workingNode.val);
                l1 = l1.next;
                l2 = l2.next;
            }

            if (workingNode.val >= 10) {
                // Util.pl("Carrying over");
                workingNode.val %= 10;
                workingNode = workingNode.next = new ListNode(1);
            } else if (l1 != null || l2 != null) {
                workingNode = workingNode.next = new ListNode(0);
            }
        }

        return resultHead;
    }
}