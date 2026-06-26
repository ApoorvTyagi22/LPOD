class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length; 
        long validPairs = 0; 
        long res = 0; 
        long currSum = 0;
        HashMap<Long, Long> cnt = new HashMap<>();
        cnt.put((long)0, (long)1);
        for(int i = 0; i < n; i++){
            if(nums[i] == target){
                validPairs += cnt.getOrDefault(currSum, (long)0);
                currSum++;
            } else {
                currSum--;
                validPairs -= cnt.getOrDefault(currSum, (long)0);
            }
            res += validPairs;
            cnt.put(currSum, cnt.getOrDefault(currSum, (long)0) + 1);
        }

        return res; 

    }
}