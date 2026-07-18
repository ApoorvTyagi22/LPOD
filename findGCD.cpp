class Solution {
public:
    int findGCD(vector<int>& nums) {
        int n = nums.size(); 
        int smallest = 10001;
        int biggest = -1;
        for(int i = 0; i < n; i++){
            smallest = min(smallest, nums[i]);
            biggest = max(biggest, nums[i]);
        }

        return gcd(biggest, smallest);
        
    }
};