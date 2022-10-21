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
class ReversedLinkedList {
    public ListNode reverseList(ListNode head) {
        
        ListNode previous = null;
        ListNode current = head;
        
        while (current != null){
            
            // Get the original next value.
            ListNode next = current.next;
            
            // Switch the next value to the previous value
            current.next = previous;
            
            // Switch the previous value to the current value
            previous = current;
            
            // Update the value of current to the original next value.
            current = next;   
        }
        
        return previous;
    }
}
