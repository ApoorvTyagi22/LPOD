class Solution {
public:
    long long minSumSquareDiff(vector<int>& nums1, vector<int>& nums2, int k1, int k2) {
        vector<int> countDiff(1e5 + 1, 0); 
        int K = k1 + k2;   
        int n = nums1.size();
        for(int i = 0; i < n; i++){
            int diff = abs(nums1[i] - nums2[i]);
            countDiff[diff]++; 
        }


        for(int i = 1e5; i >= 0; i--){
            if(K == 0) break; 
            int maxReduce = min(K, countDiff[i]);
            K -= maxReduce; 
            countDiff[i] -= maxReduce; 
            if(i - 1 > 0) countDiff[i - 1] += maxReduce;
        }

        long long res = 0; 
        for(long long i = 0; i <= 1e5; i++){
            res += (i * i) * countDiff[i];
        }

        return res;
    }
};