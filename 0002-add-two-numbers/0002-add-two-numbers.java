/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        ListNode head = new ListNode();
        ListNode temp = head;
        while (l1 != null || l2 != null){
            if(l1 == null && l2 != null){
                sum = 0 + l2.val;
                l2 = l2.next;
            }
            else if(l1 != null && l2 == null){
                sum = l1.val + 0;
                l1 = l1.next;
            }
            else{
                sum = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            sum += carry;
            carry = 0;
            if (sum > 10){
                carry = 1;
                sum = sum % 10;
            }
            else if (sum == 10){
                sum = 0;
                carry = 1;
            }
            if(head == null){
                head.val = sum;
            }
            else{
                ListNode newNode = new ListNode(sum);
                temp.next = newNode;
                temp = temp.next;
            }
            
            
        }
        if (carry == 1){
            ListNode newNode = new ListNode(carry);
                temp.next = newNode;
                temp = temp.next;
        }
        temp = head.next;
        head = temp;
        return head;
    }
}