class Solution {
public:
    vector<int> targetIndices(vector<int>& nums, int target) {
        int n = nums.size();
        int cnt1 = 0; 
        int cnt2 = 0; 

        for(int i = 0; i < n; i++){
            if(nums[i] < target){
                cnt1++; 
            } else if(nums[i] == target){
                cnt2++; 
            }
        }
        int temp = 0; 
        vector<int> res; 
        for(int i = 0; i < cnt2; i++){
            res.push_back(cnt1 + temp);
            temp++;
        }

        return res; 
    }
};