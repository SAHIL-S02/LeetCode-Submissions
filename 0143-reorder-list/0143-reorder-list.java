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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode re = slow.next;
        slow.next = null;
        re = rev(re);
        ListNode first = head.next;
        boolean flg = false;
        while(re != null && first != null){
            if(flg){
                head.next = first;
                head = head.next;
                first = first.next;
                flg = !flg;
            }else{
                head.next = re;
                head = head.next;
                re = re.next;
                flg = !flg;
            }
        }
        if(re == null){
            head.next = first;
        }else{
            head.next = re;
        }
    }
    private ListNode rev(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}