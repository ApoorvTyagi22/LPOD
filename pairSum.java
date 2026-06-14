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
    public int pairSum(ListNode head) {
        ListNode leftPointer = head; 
        ListNode dummy = head; 
        int n = 1;
        while(dummy.next != null){ 
            dummy = dummy.next;
            n++;
        }
        int r = 0; 
        dummy = head; 
        while(r != (n / 2)){
            dummy = dummy.next; 
            r++;
        }

        ListNode prev = null;
        ListNode curr = dummy;
        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;            
        }
        ListNode RightPointer = prev;

        int res = 0;
        int l = 0; 

        while(l < (n / 2)){
            int temp = leftPointer.val + RightPointer.val;
            res = Math.max(res, temp);  
            leftPointer = leftPointer.next; 
            RightPointer = RightPointer.next; 
            l++;
        }

        return res;

    }
}