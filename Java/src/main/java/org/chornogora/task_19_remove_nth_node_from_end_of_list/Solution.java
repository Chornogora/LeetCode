package org.chornogora.task_19_remove_nth_node_from_end_of_list;

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }

        ListNode subHead = head;
        ListNode currentNode = head;
        int currentLength = 1;
        int totalLength = 1;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
            if (currentLength <= n) {
                currentLength++;
            } else {
                subHead = subHead.next;
            }
            ++totalLength;
        }

        if (totalLength == n) {
            return head.next;
        }
        subHead.next = subHead.next.next;
        return head;
    }
}
