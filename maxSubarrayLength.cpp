class Solution {
public:
    int maxSubarrayLength(vector<int>& nums, int k) {
        unordered_map<int, int> map; 
        int n = nums.size();
        int i = 0;
        int j = 0; 
        int bestLen = 0; 
        while(i < n && j < n){
            // just see j check if current freq of nums[j] < k
            // then we can add it to our window
            if(map[nums[j]] < k){
                map[nums[j]]++; 
                bestLen = max(bestLen, j - i + 1);
            } else {
                // cnt >= k so we remove continue removing element from back 
                // till we can be under the cnt 
                while(i < j && map[nums[j]] >= k){
                    map[nums[i]]--; 
                    i++; 
                }
                map[nums[j]]++; 
            }
            j++; 
        }

        return bestLen; 
    }
};