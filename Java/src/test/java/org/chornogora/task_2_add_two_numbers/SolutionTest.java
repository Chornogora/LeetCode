package org.chornogora.task_2_add_two_numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void shouldReturn_807() {
        ListNode first = numberToLinkedList(342);
        ListNode second = numberToLinkedList(465);
        ListNode result = new Solution().addTwoNumbers(first, second);

        Assertions.assertEquals(7, result.val);
        Assertions.assertEquals(0, result.next.val);
        Assertions.assertEquals(8, result.next.next.val);
    }

    @Test
    public void shouldReturn_0() {
        ListNode first = numberToLinkedList(0);
        ListNode second = numberToLinkedList(0);
        ListNode result = new Solution().addTwoNumbers(first, second);

        Assertions.assertEquals(0, result.val);
    }

    @Test
    public void shouldReturn_89990001() {
        ListNode first = numberToLinkedList(9999999);
        ListNode second = numberToLinkedList(9999);
        ListNode result = new Solution().addTwoNumbers(first, second);

        Assertions.assertEquals(8, result.val);
    }

    @Test
    public void shouldReturn_70401() {
        ListNode first = numberToLinkedList(249);
        ListNode second = numberToLinkedList(5649);
        ListNode result = new Solution().addTwoNumbers(first, second);

        Assertions.assertEquals(7, result.val);
        Assertions.assertEquals(0, result.next.val);
        Assertions.assertEquals(4, result.next.next.val);
        Assertions.assertEquals(0, result.next.next.next.val);
        Assertions.assertEquals(1, result.next.next.next.next.val);
    }

    private ListNode numberToLinkedList(int number) {
        String s = String.valueOf(number);
        ListNode head = null;
        for (char ch : s.toCharArray()) {
            if (head == null) {
                head = new ListNode(Integer.parseInt(String.valueOf(ch)));
            } else {
                head = new ListNode(Integer.parseInt(String.valueOf(ch)), head);
            }
        }
        return head;
    }
}
