class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length; 
        int[] prefMax = new int[n];
        int[] suffixMin = new int[n];
        prefMax[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefMax[i] = Math.max(prefMax[i - 1], nums[i]);
        }

        suffixMin[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }


        for(int i = 0; i < n; i++){
            int score = prefMax[i] - suffixMin[i];
            if(score <= k){
                return i; 
            }
        }

        return -1; 
    }
}