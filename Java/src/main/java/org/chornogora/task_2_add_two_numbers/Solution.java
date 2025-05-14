package org.chornogora.task_2_add_two_numbers;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        int reserved = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                int val = (l1.val + l2.val + reserved) % 10;
                reserved = (l1.val + l2.val + reserved) / 10;
                if (result == null) {
                    result = new ListNode(val);
                } else {
                    result = new ListNode(val, result);
                }
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                int val = (l1.val + reserved) % 10;
                reserved = (l1.val + reserved) / 10;
                result = new ListNode(val, result);
                l1 = l1.next;
            } else {
                int val = (l2.val + reserved) % 10;
                reserved = (l2.val + reserved) / 10;
                result = new ListNode(val, result);
                l2 = l2.next;
            }
        }
        if (reserved == 1) {
            result = new ListNode(1, result);
        }
        return reverseList(result);
    }

    ListNode reverseList(ListNode ln) {
        ListNode reversed = null;
        while (ln != null) {
            reversed = new ListNode(ln.val, reversed);
            ln = ln.next;
        }
        return reversed;
    }
}