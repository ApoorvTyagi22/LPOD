class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        HashMap<Integer, Integer> cnt = new HashMap<>();

        int cumSum = 0; 
        cnt.put(0, 1);
        int validPoints = 0; 
        int res = 0; 
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                validPoints += cnt.getOrDefault(cumSum, 0);
                cumSum++;
            } else {
                cumSum--; 
                validPoints -= cnt.getOrDefault(cumSum, 0);
            }
            res += validPoints; 
            cnt.put(cumSum, cnt.getOrDefault(cumSum, 0) + 1);
        }

        return res; 
        
    }
}