class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Reach the node just before the left position
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Start reversing
        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {

            ListNode nextNode = curr.next;

            curr.next = nextNode.next;

            nextNode.next = prev.next;

            prev.next = nextNode;
        }

        return dummy.next;
    }
}