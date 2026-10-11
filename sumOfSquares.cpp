class Solution {
public:
    int sumOfSquares(vector<int>& nums) {
        int n = nums.size();
        vector<int> squareNums; 

        for(int i = 0; i < n; i++){
            if(n % (i + 1) == 0){
                squareNums.push_back(nums[i] * nums[i]);
            }
        }

        int res = 0; 

        for(int i = 0; i < squareNums.size(); i++){
            res += squareNums[i];
        }

        return res; 

    }
};