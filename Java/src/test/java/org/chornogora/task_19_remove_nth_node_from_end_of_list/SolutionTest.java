package org.chornogora.task_19_remove_nth_node_from_end_of_list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void shouldRemoveElement() {
        Solution solution = new Solution();
        ListNode head = createList(new int[]{1, 2, 3, 4, 5});
        head = solution.removeNthFromEnd(head, 2);
        Assertions.assertTrue(listMatches(head, new int[]{1, 2, 3, 5}));
    }

    @Test
    public void shouldRemoveSingleElement() {
        Solution solution = new Solution();
        ListNode head = createList(new int[]{1});
        head = solution.removeNthFromEnd(head, 1);
        Assertions.assertNull(head);
    }

    @Test
    public void shouldRemoveLastElement() {
        Solution solution = new Solution();
        ListNode head = createList(new int[]{1, 2});
        head = solution.removeNthFromEnd(head, 1);
        Assertions.assertTrue(listMatches(head, new int[]{1}));
    }

    @Test
    public void shouldRemoveFirstElement() {
        Solution solution = new Solution();
        ListNode head = createList(new int[]{1, 2});
        head = solution.removeNthFromEnd(head, 2);
        Assertions.assertTrue(listMatches(head, new int[]{2}));
    }

    private ListNode createList(int[] values) {
        ListNode dummy = new ListNode(values[0]);
        ListNode current = dummy;
        for (int i = 1; i < values.length; i++) {
            int value = values[i];
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy;
    }

    private boolean listMatches(ListNode head, int[] values) {
        ListNode current = head;
        for (int value : values) {
            if (current == null || current.val != value) {
                return false;
            }
            current = current.next;
        }
        return current == null;
    }
}
