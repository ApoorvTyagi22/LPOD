class Solution {
public:
    int getDigitSum(int n1){
        int sum = 0; 
        while(n1 > 0){
            sum += n1 % 10; 
            n1 /= 10; 
        }
        return sum; 
    }

    int minSwaps(vector<int>& nums) {
        int n = nums.size();
        vector<int> sortedNums(nums);
        auto lambda = [&](int num1,int num2){
            int dSum1 = getDigitSum(num1);
            int dSum2 = getDigitSum(num2);
            if(dSum1 != dSum2){
                return dSum1 < dSum2;
            }
            return num1 < num2;
        };

        sort(begin(sortedNums), end(sortedNums), lambda);

        unordered_map<int, int> map; 

        for(int i = 0; i < n; i++){
            map[nums[i]] = i; 
        }
        int res = 0; 
        for(int i = 0; i < n; i++){
            // currently at i 
            int expectedVal = sortedNums[i];
            if(expectedVal == nums[i]) continue; 

            res++;
            //swap expectedVal 
            int ourIdx = map[expectedVal];
            map[expectedVal] = i; 
            map[nums[i]] = ourIdx; 
            nums[ourIdx] = nums[i];
            nums[i] = expectedVal; 
        }


        return res;
    }
};