/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hs = new HashSet<>();
        ListNode pointer = head;
        while(pointer != null){
            if(hs.contains(pointer)){
                return pointer;
            }
            hs.add(pointer);
            pointer = pointer.next;
        }
        return null;
    }
}