class Solution {
    int[] nums; 
    int n; 
    Integer[][][] memo; 
    // (A + B) + (A - B) = total - diff 
    // 2A = total - diff 
    // A = (total - diff)/2; 
    // returns diff 
    public int solve(int i, int M, int isAlice){
        if(i >= n){
            return 0; 
        }

        if(memo[i][M][isAlice] != null){
            return memo[i][M][isAlice];
        }
        if(isAlice == 1){
            int runningSum = 0; 
            int bestAliceMove = Integer.MIN_VALUE;
            for(int x = 1; x <= 2 * M; x++){
                if(i + x > n) break;
                runningSum += nums[i + x - 1];
                int temp = runningSum + solve(i + x, Math.max(M, x), 0);
                bestAliceMove = Math.max(bestAliceMove, temp);
            }
            return bestAliceMove; 
        } else {
            int runningSum = 0; 
            int bestBobMove = Integer.MAX_VALUE; 
            for(int x = 1; x <= 2 * M; x++){
                if(i + x > n) break;
                runningSum += nums[i + x - 1];
                int temp = solve(i + x, Math.max(M, x), 1) - runningSum; 
                bestBobMove = Math.min(bestBobMove, temp);
            }
            return memo[i][M][isAlice] = bestBobMove; 
        }
    }
    public int stoneGameII(int[] piles) {
        this.nums = piles; 
        this.n = nums.length;
        int total = 0; 
        this.memo = new Integer[n + 1][n+ 1][2];
        for(int i = 0; i < n; i++){
            total += piles[i];
        }
        int diff =  solve(0, 1, 1); // i, M 

        return (total + diff) / 2; 
    }
}