class Solution {
    int[][][] memo;
    int MOD = 1_000_000_007;
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public int solve(int[] nums, int i, int gcd1, int gcd2){
        if(i == nums.length){
            if(gcd1 != 0 && gcd2 != 0){
                return (gcd1 == gcd2) ? 1 : 0; 
            } 
            return 0; 
        }
        if(memo[i][gcd1][gcd2] != -1){
            return memo[i][gcd1][gcd2];
        }

        long skip = solve(nums, i + 1, gcd1, gcd2);
        long sub1 = solve(nums, i + 1, gcd(gcd1, nums[i]), gcd2);
        long sub2 = solve(nums, i + 1, gcd1, gcd(gcd2, nums[i]));

        return memo[i][gcd1][gcd2] = (int)((skip + sub1 + sub2) % MOD);
    }
    public int subsequencePairCount(int[] nums) {
        int maxVal = 0;
        int n = nums.length; 
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        memo = new int[n][maxVal + 1][maxVal + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= maxVal; j++) {
                for (int k = 0; k <= maxVal; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        return solve(nums, 0, 0, 0); // i, gcds1, gcds3
    } 
}