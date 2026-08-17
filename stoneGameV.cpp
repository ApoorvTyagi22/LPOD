class Solution {
public:
    typedef long long ll; 
    vector<vector<ll>> dp; 
    const int INF = -1e9; 
    int solve(int l, int r,int n, const vector<int>& stoneValue,const vector<int>& prefixSum){
        if(l == r){
            return 0; 
        }
        if(dp[l][r] != -1){
            return dp[l][r];
        }
        int bestScore = INF; 
        for(int mid = l; mid < r; mid++){
            int firstHalf = prefixSum[mid];
            if(l > 0){
             firstHalf = firstHalf - prefixSum[l - 1];
            }
            int secondHalf = prefixSum[r]; 
            if(mid >= 0){
                secondHalf = secondHalf - prefixSum[mid]; 
            }

            if(firstHalf > secondHalf){
                // remove firstHalf
                bestScore = max(bestScore, secondHalf + solve(mid + 1, r, n, stoneValue, prefixSum));
            } else if(secondHalf > firstHalf){
                bestScore = max(bestScore, firstHalf + solve(l, mid, n, stoneValue, prefixSum));
            } else {// equal 
                bestScore = max(bestScore, firstHalf + solve(l, mid, n, stoneValue, prefixSum));
                bestScore = max(bestScore, secondHalf + solve(mid + 1, r, n, stoneValue, prefixSum));
            }
        }

        return dp[l][r] = bestScore; 

    }

    int stoneGameV(vector<int>& stoneValue) {
        int n = stoneValue.size(); 
        vector<int> prefixSum(n, 0);
        prefixSum[0] = stoneValue[0];
        for(int i = 1; i < n; i++){
            prefixSum[i] = stoneValue[i] + prefixSum[i - 1];
        }
        dp.resize(n, vector<ll>(n, -1));
        return solve(0, n - 1, n, stoneValue, prefixSum);
    }   
};