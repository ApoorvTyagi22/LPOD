class Solution {
public:
    vector<vector<bool>> isPalindrom; 
    vector<vector<int>> memo;
    int n; 
    int k; 


    int solve(string& s, int i, int j){
        if(i >= n || j >= n){
            return 0; 
        }
        if(memo[i][j] != -1) return memo[i][j];   

        if(isPalindrom[i][j]){
            // take this 
            int take = 1 + solve(s, j + 1, j + k);

            int grow = solve(s, i, j + 1);

            int slide = solve(s, i + 1, j + 1);

            return memo[i][j] = max({take, grow, slide});
        } else {
            int grow = solve(s, i, j + 1);
            int slide = solve(s, i + 1, j + 1);
            return memo[i][j] = max(grow, slide);
        }
    }

    int maxPalindromes(string s, int k) {
        n = s.length();
        if(k == 1) return n;
        this->k = k; 
        isPalindrom.assign(n, vector<bool>(n, false));
        memo.assign(n, vector<int>(n, -1));             
        for(int L = 1; L <= n; L++){
            for(int i = 0; i + L <= n; i++){
                int j = i + L - 1; 
                if(i == j){
                   isPalindrom[i][j] = true;  
                } else if(i + 1 == j){
                    isPalindrom[i][j] = (s[i] == s[j]);
                } else {
                    isPalindrom[i][j] = (s[i] == s[j]) && 
                                        (isPalindrom[i + 1][j - 1]);
                }
            }
        }


        return solve(s, 0, k - 1);
    }
};