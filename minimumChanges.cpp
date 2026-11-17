class Solution {
public:
    string s;
    vector<vector<int>> cost_memo, solve_memo;
    int get_cost(int i, int j){
        int len = j - i + 1; 
        if(cost_memo[i][j] != -1){
            return cost_memo[i][j];
        }
        int min_cost = INT_MAX; 


        for(int d = 1; d < len; d++){
            if(len % d != 0) continue; 
            // based on d divid string into groups 
            int cost = 0; 
            for(int group = 0; group < d; group++){
                int start = i + group; 
                int end = j - (d - 1) + group;

                while(start < end){
                    if(s[start] != s[end]){
                        cost++; 
                    }
                    start += d; 
                    end -= d; 
                }
            }

            min_cost = min(min_cost, cost); 
        }

        return cost_memo[i][j] = min_cost;
    }
    int solve(int start, int k){
        // Base case 
        if(k == 0){
            if(start == s.length()){
                return 0;
            }

            return INT_MAX; 
        }

        if(solve_memo[start][k] != -1){
            return solve_memo[start][k];
        }
        // prunning
        if(start + 2*k > s.length()){
            return solve_memo[start][k] = INT_MAX; 
        }

        int min_cost = INT_MAX; 
        for(int end = start + 1; end < s.length(); end++){
            // get cost of partitioning from end 
            int rem_cost = solve(end + 1, k - 1);
            if(rem_cost == INT_MAX){
                continue; 
            }
            min_cost = min(min_cost, rem_cost + get_cost(start, end));
        }

        return solve_memo[start][k] = min_cost; 
    }
    int minimumChanges(string s, int k) {
        this->s = s;
        int n = s.length();
        solve_memo.assign(n + 1, vector<int>(k + 1, -1));
        cost_memo.assign(n + 1, vector<int>(n + 1, -1));
        return solve(0, k);  
    }
};