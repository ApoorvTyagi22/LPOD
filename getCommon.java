class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0; 
        int j = 0; 
        int n = nums1.length; 
        int m = nums2.length; 

        while(i < n && j < m){
            // check if i and j are equal if yes return 
            if(nums1[i] == nums2[j]){
                return nums1[i];
            }
            // otherwise move the
            if(nums1[i] < nums2[j]){
                i++;
            } else {
                j++;
            }
        }

        return -1; 
    }
}