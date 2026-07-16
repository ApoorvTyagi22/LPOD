class Solution {
    int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }

    public long gcdSum(int[] nums) {
        int n = nums.length; 
        int[] prefixGcd = new int[n];
        int mxi = nums[0];
        for(int i = 0; i < n; i++){
            mxi = Math.max(mxi, nums[i]);
            prefixGcd[i] = gcd(nums[i], mxi);
        }

        Arrays.sort(prefixGcd);

        int l = 0; 
        int r = n - 1; 
        long res = 0;
        while(l < r){
            int lft = prefixGcd[l];
            int rgt = prefixGcd[r];
            res += gcd(lft, rgt);
            l++;
            r--; 
        }

        return res; 
    }
}