class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = -1; 
        long min = (long) 1e9 + 1;
        int n = nums.length; 

        for(int i = 0; i < n; i++){
           max = Math.max(max, nums[i]);
           min = Math.min(min, nums[i]);
        }

        return (max - min) * k; 
    }
}