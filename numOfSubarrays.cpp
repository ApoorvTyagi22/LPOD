class Solution {
public:
    int numOfSubarrays(vector<int>& arr) {
        int n = arr.size();
        int MOD = 1e9 + 7; 
        vector<int> prefixSum(n + 1);

        for(int i = 0; i < n; i++){
            prefixSum[i  + 1] = prefixSum[i] + arr[i]; 
        }

        int evenCnt = 0; 
        int oddCnt = 0; 
        int res = 0; 
        for(int i = 0; i <= n; i++){
            if(prefixSum[i] % 2){
                //odd cnt 
                res = (res + evenCnt) % MOD; 
                oddCnt++; 
            } else{
                //evem cnt
                res = (res + oddCnt) % MOD; 
                evenCnt++; 
            }
        }

        return res; 
    }
};