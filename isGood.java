class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int maxNum = n - 1;
        int[] freq = new int[n];

        for(int i = 0; i < n; i++){
            if(nums[i] > maxNum) return false;
            freq[nums[i]]++;
        }

        for(int i = 1; i < maxNum; i++){
            if(freq[i] != 1){
                return false; 
            }
        }
        
        if(freq[maxNum] != 2){
            return false; 
        }

        return true;
    }
}