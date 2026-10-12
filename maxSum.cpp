class Solution {
public:
    int maxSum(vector<int>& nums, int k) {
        int n = nums.size();
        int MOD = (int)1e9 + 7; 
        vector<int> count(32, 0);

        for(int& num : nums){
            for(int b = 0; b < 32; b++){
                if((num & (1 << b))){
                    count[b]++; 
                }
            }
        }

        int res = 0; 
        while(k-- > 0){
            long long curr = 0; 

            for(int b = 0; b < 32; b++){
                if(count[b] > 0){
                    count[b]--; 
                    curr = (curr | (1 << b));
                }
            }
            curr = curr % MOD;
            res = (res % MOD) + ((curr * curr % MOD));
        }

        return res % MOD; 
    }
};