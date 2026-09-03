class Solution {
    public boolean uniformArray(int[] nums1) {
        int minElem = Integer.MAX_VALUE; 
        int n = nums1.length; 
        for(int i = 0; i < n; i++){
            minElem = Math.min(minElem, nums1[i]);
        }

        if(minElem % 2 == 1){
            return true; // smallest is odd 
        }


        for(int num : nums1){
            if(num % 2 == 1){
                return false; 
            }
        }

        return true; 
    }
}