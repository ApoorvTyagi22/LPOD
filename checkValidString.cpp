class Solution {
public:
    int dp[101][101];
    bool solve(string& s, int count, int i){
        if(i == s.length()){
            if(count == 0){
                return true; 
            } 
            return false; 
        }
        if(count < 0) return false; 
        if(dp[count][i] != -1){
            return dp[count][i];
        }
        // if current is ( or ) change count and conintue 
        if(s[i] == '('){
            return dp[count][i] = solve(s, count + 1, i + 1);
        } else if(s[i] == ')'){
            return dp[count][i] = solve(s, count - 1, i + 1);
        } else {
            // its a star have 3 chocices
            bool c1 = solve(s, count + 1, i + 1);
            bool c2 = solve(s, count - 1, i + 1);
            bool c3 = solve(s, count, i + 1);
            return  dp[count][i] = c1 || c2 || c3; 
        }
    }

    bool checkValidString(string s) {
        memset(dp, -1, sizeof(dp));
        return solve(s, 0, 0);
    }
};