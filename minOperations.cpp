class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        int n = nums.size(); 
        unordered_map<int, int> map; // sum -> idx; 
        int total = 0; 
        
        for(int v : nums) total += v; 
        int target = total - x; 
        map[0]  = -1;
        if(target == 0) return n;    

        int runningSum = 0; 
        int bestAns = n + 1; 

        for(int i = 0; i < n; i++){
            runningSum += nums[i];
            // check if we have the defice 
            if(map.contains(runningSum - target)){
                int j = map[runningSum - target];
                int temp = n - (i - j); // current subarray
                bestAns = min(bestAns, temp);
            }

            map[runningSum] = i;  
        }

        return (bestAns == n + 1) ? -1 : bestAns; 
    }
};