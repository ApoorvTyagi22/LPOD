class Solution {
public:
    int smallestIndex(vector<int>& nums) {
        int n = nums.size();
        int total = 0; 
        
        for(int i = 0; i < n; i++){
            int num = nums[i];

            int temp = num; 
            int sum = 0; 
            while(temp > 0){
                sum += temp % 10;
                temp /= 10; 
            }

            if(sum == i){
                return i;
            }
        }

        return -1;

    }
};