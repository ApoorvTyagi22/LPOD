class Solution {
    public int minElement(int[] nums) {
        int res = Integer.MAX_VALUE; 
        int n = nums.length; 

        for(int i = 0; i < n; i++){
            int curr = nums[i];
            int curr_sum = 0; 
            while(curr > 0){
                int digit = curr % 10; 
                curr_sum += digit; 
                curr /= 10; 
            }
            res = Math.min(curr_sum, res);
        }
        return res; 
    }
}