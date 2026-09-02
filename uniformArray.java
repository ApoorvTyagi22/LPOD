class Solution {
    public boolean uniformArray(int[] nums1) {
        int evenCount = 0; 
        int oddCount = 0; 
        int n = nums1.length;
        for(int i = 0; i < n; i++){
            if(nums1[i] % 2 == 0){
                evenCount++;
            } else {
                oddCount++;
            }
        }

        if(evenCount == 0 || oddCount == 0){
            return true; 
        }


        // otherwise we gotta make them all odd 
        if(oddCount >= 1){
            return true;
        } else {
            return false;
        }
        
    }
}