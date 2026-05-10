class Solution {
    Integer[] memo;
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        this.memo = new Integer[n + 1];
        return solve(0, nums, n, target); // currIdx, int[] nums, int target
    }

    public int solve(int idx, int[] nums, int n, int target) {
        if(idx == n - 1){
            return 0;
        }
        if(memo[idx] != null){
            return memo[idx];
        }
        int bestChoice = -1; 
        for(int i = idx + 1; i < n; i++){
            if(Math.abs(nums[i] - nums[idx]) <= target) {
                int resOne = solve(i, nums, n, target);
                if(resOne != -1){
                    bestChoice = Math.max(resOne + 1, bestChoice);
                }
            }   
        }

        return memo[idx] = bestChoice; 

        
    }
}