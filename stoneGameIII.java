class Solution {
    int n; int[] stoneValue;
    int POS_INF = (int)1e9;
    int NEG_INF = -(int)1e9;
    Integer[][] dp; 

    int solve(int i, int isAlice){
        if(i == n){
            return 0; 
        }
        if(dp[i][isAlice] != null){
            return dp[i][isAlice];
        }
        // otherwise we want to maximise the diff (AliceScore - BobScore)
        if(isAlice == 1){
            // three choices 
            int c1 = NEG_INF; int c2 = NEG_INF; int c3 = NEG_INF;
            c1 = solve(i + 1, 0) + stoneValue[i];
            if(i + 1 < n){
            c2 = solve(i + 2, 0) + stoneValue[i] + stoneValue[i + 1];
            } 
            if(i + 2 < n){
                c3 = solve(i + 3, 0) + stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2];
            }
            return  dp[i][isAlice] = Math.max(c1, Math.max(c2, c3));
        } else {
            int c1 = POS_INF; int c2 = POS_INF; int c3 = POS_INF;
            c1 = solve(i + 1, 1) - stoneValue[i];
            if(i + 1 < n){
            c2 = solve(i + 2, 1) - stoneValue[i] - stoneValue[i + 1];
            } 
            if(i + 2 < n){
                c3 = solve(i + 3, 1) - stoneValue[i] - stoneValue[i + 1] - stoneValue[i + 2];
            }

            return dp[i][isAlice] = Math.min(c1, Math.min(c2, c3));
        }

    }

    public String stoneGameIII(int[] stoneValue) {
        this.n = stoneValue.length;
        this.stoneValue = stoneValue; 

        this.dp = new Integer[n][2];
        int total = solve(0, 1);
        if(total == 0){
            return "Tie";
        } else if(total > 0){
            return "Alice";
        } else {
            return "Bob";
        }
    }
}


/// Bottom up approach

class Solution {
    int n; int[] stoneValue;
    int POS_INF = (int)1e9;
    int NEG_INF = -(int)1e9;
    Integer[][] dp; 

    public String stoneGameIII(int[] stoneValue) {
        this.n = stoneValue.length;
        this.stoneValue = stoneValue; 

        this.dp = new Integer[n + 1][2];
        
        dp[n][0] = 0;
        dp[n][1] = 0;

        for(int i = n - 1; i >= 0; i--){
                int c1 = NEG_INF; int c2 = NEG_INF; int c3 = NEG_INF;
                c1 = dp[i + 1][0] + stoneValue[i];
                if(i + 1 < n){
                c2 = dp[i + 2][0] + stoneValue[i] + stoneValue[i + 1];
                } 
                if(i + 2 < n){
                    c3 = dp[i + 3][0] + stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2];
                }
                 dp[i][1] = Math.max(c1, Math.max(c2, c3));

                c1 = POS_INF; c2 = POS_INF; c3 = POS_INF;
                c1 = dp[i + 1][1] - stoneValue[i];
                if(i + 1 < n){
                c2 = dp[i + 2][1] - stoneValue[i] - stoneValue[i + 1];
                } 
                if(i + 2 < n){
                    c3 = dp[i + 3][1] - stoneValue[i] - stoneValue[i + 1] - stoneValue[i + 2];
                }

                dp[i][0] = Math.min(c1, Math.min(c2, c3));
        }
        
         int total = dp[0][1];
        if(total == 0){
            return "Tie";
        } else if(total > 0){
            return "Alice";
        } else {
            return "Bob";
        }
    }
}