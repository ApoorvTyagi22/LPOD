class Solution {
public:
    vector<long long> resultArray(vector<int>& nums, int k) {
        int n = nums.size();

        vector<long long> result(k, 0); 

        vector<long long> prevCount(k, 0);

        for(int i = 0; i < n; i++){
            vector<long long> currCnt(k, 0);

            int currElemenRem = nums[i] % k; 

            currCnt[currElemenRem]++;

            for(int oldRem = 0; oldRem < k; oldRem++){
                int newRem = ((long long)oldRem * nums[i] % k) % k; 
                currCnt[newRem] += prevCount[oldRem];
            }

            prevCount = move(currCnt);

            for(int x = 0; x <= k - 1; x++){
                result[x] += prevCount[x];
            }            
        }


        return result;




    }
};