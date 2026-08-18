class Solution {
public:
    int largestInteger(vector<int>& nums, int k) {
        unordered_map<int, int> cnt; // need the biggest value with cnt 1
        int n = nums.size();
        int i = 0; 
        int j = 0; 
        unordered_set<int> st; 
        while(j < n){
            if(j - i + 1 == k){
                // add all elements from i to j 
                for(int l = i; l <= j; l++){
                    st.insert(nums[l]);
                }

                // loop over all elements in the set and increase subarray cnt 
                for(int num : st){
                    cnt[num]++; 
                }

                st.erase(nums[i]);
                i++; 
            } 
            j++; 
        }

        int bestAns = -1; 

        for(const auto& [key, val] : cnt){
            if(val == 1){
                if(bestAns < key){
                    bestAns = key; 
                }
            }
        }

        return bestAns; 

    }
};