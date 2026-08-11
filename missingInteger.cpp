class Solution {
public:
    int missingInteger(vector<int>& nums) {
        int n = nums.size();
        unordered_set<int> set; 
        for(int i = 0; i < n; i++){
            set.insert(nums[i]);
        }
        int seqSum{0};

        seqSum += nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i - 1] + 1){
                seqSum += nums[i];
            } else {
                break; 
            }
        } 

        while(set.count(seqSum)){
            seqSum++; 
        }
        return seqSum; 

    }
};