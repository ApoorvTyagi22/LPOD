class Solution {
public:
    int minMoves(vector<int>& nums) {
        int n = nums.size();
        int maxElm = -1; 
        for(int i = 0; i < n; i++){
            maxElm = max(nums[i], maxElm);
        }
        int res = 0; 
        for(int i = 0; i < n; i++){
            res += abs(nums[i] - maxElm);
        }


        return res; 
    }
};