class Solution {
public:
    int longestSubsequence(vector<int>& nums) {
        int n = nums.size();
        int zeroCount = 0; 
        for(int i = 0; i < n; i++){
            if(nums[i] == 0) {
                zeroCount++; 
            }
        }

        if(zeroCount == n){
            return 0; 
        }
        
        // now see if the xor of all n is zero or not 
        int x = 0; 
        for(int i = 0; i < n; i++){
            x ^= nums[i];
        }

        return (x == 0) ? n - 1 : n; 
    }
};