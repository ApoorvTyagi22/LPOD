class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length; 
        int numSum = 0;
        int f0 = 0;
        for(int i = 0; i < n; i++){
            numSum += nums[i];
            f0 += (i * nums[i]);
        }
        int maxRes = f0;
        int lastSum = f0;
        for(int i = 1; i < n; i++){
            int tmp = numSum + lastSum - (n * nums[n - i]);
            maxRes = Math.max(maxRes, tmp);
            lastSum = tmp;
        }

        return maxRes; 
    }
}