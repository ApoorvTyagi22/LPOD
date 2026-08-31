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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstOne = -1; 
        int closest = -1;       
        int bestMin = Integer.MAX_VALUE; 
        int BestMax = Integer.MIN_VALUE; 
        ListNode curr = head; 
        int cnt = 0;
        ListNode prev = null; 
        while(curr.next != null){
            cnt++; 
            // check if this is a critical point
            if(prev == null) {// cant be one 
                prev = curr; 
                curr = curr.next; 
                continue; 
            }

            if((prev.val < curr.val && curr.val > curr.next.val) || prev.val > curr.val && curr.val < curr.next.val){
                // first see if firstOne is populated if not populate it and closest and continue; 
                if(firstOne == -1 && closest == -1){
                    firstOne = cnt; 
                    closest = cnt; 
                    prev = curr; 
                    curr = curr.next; 
                    continue; 
                }
                
                // use firstOne and curr cnt to get max Dist 
                BestMax = Math.max(cnt - firstOne, BestMax);

                // use closest one and curr to get min distance 
                bestMin = Math.min(cnt - closest, bestMin); 
                closest = cnt; 
            }
            prev = curr; 
            curr = curr.next; 
        }

        if(bestMin == Integer.MAX_VALUE || BestMax == Integer.MIN_VALUE){
            return new int[]{-1, -1};
        } else {
            return new int[]{bestMin, BestMax};
        }
    }
}