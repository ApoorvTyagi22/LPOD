class Solution {
public:
    vector<int> memo;

    int solve(int i, int n, vector<int>& costs){
        if(i == n){
            return 0;
        }
        if(memo[i] != -1){
            return memo[i];
        }
        int c1 = INT_MAX;
        if(i + 1 <= n){
            int j = i + 1;
            int costj = solve(j, n, costs);
            c1 = min(c1, costj + costs[j - 1] + (j - i) * (j - i));
        }
        if(i + 2 <= n){
            int j = i + 2;
            int costj = solve(j, n, costs);
            c1 = min(c1, costj + costs[j - 1] + (j - i) * (j - i));
        }
        if(i + 3 <= n){
            int j = i + 3;
            int costj = solve(j, n, costs);
            c1 = min(c1, costj + costs[j - 1] + (j - i) * (j - i));
        }
        memo[i] = c1;
        return c1;
    }

    int climbStairs(int n, vector<int>& costs) {
        memo.assign(n + 1, -1);
        return solve(0, n, costs);
    }
};