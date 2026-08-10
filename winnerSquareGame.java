class Solution {
    Boolean[][] memo; 
    private boolean solve(int i, int isAlice){
        if (i == 0) {
            if (isAlice == 1) {
                return memo[i][isAlice] = false; 
            } else {
                return memo[i][isAlice] = true;  
            }
        }

        if(memo[i][isAlice] != null){
            return memo[i][isAlice];
        }
        if(isAlice == 1){
            boolean res = false; 
            for(int j = 1; j * j <= i; j++){
                int sqr = j * j; 
                if(i - sqr >= 0){
                    boolean temp = solve(i - sqr, 0);
                    res = temp || res; // can she win with any move? 
                }
            }
            return memo[i][isAlice] = res; 
        } else { // BOB is tying to see any way to make it false 
            boolean res = true; 
            for(int j = 1; j * j <= i; j++){
                int sqr = j * j; 
                if(i - sqr >= 0){
                    // we want temp == false, that to presist
                    boolean temp = solve(i - sqr, 1);
                    if(temp == false) return memo[i][isAlice] = false; 
                }
            }

            return memo[i][isAlice] = res; 

        }

    }
    public boolean winnerSquareGame(int n) {
        this.memo = new Boolean[n + 1][2];
        return solve(n, 1);
    }
}