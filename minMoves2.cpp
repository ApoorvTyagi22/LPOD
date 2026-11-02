class Solution {
public:
    int minMoves2(vector<int>& nums) {
        int n = nums.size();
        sort(begin(nums), end(nums));
        int res = 0; 
        for(int i = 0; i < n; i++){
            res += abs(nums[i] - nums[n/2]);
        }

        return res; 
    }
};