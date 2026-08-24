class Solution {
    Integer[][] memo; 
    // returns Alice Score - Bob Score 
    int solve(int i, int n, int isAlice, int[] prefixSum){
        if(i == n - 1){
            return 0; 
        }

        if(memo[i][isAlice] != null){
            return memo[i][isAlice];
        }

        if(isAlice == 1){
            // Alice Turn trying getting the maximum score 
            int take = prefixSum[i + 1] + solve(i + 1, n, 0, prefixSum); // take the sum up to i + 2 as we need to take atleast 2 
            int skip = (i + 1 == n - 1) ? Integer.MIN_VALUE : solve(i + 1, n, 1, prefixSum); 
            return memo[i][isAlice]= Math.max(take, skip);
        } else {
            // its Bobs turn 
            int take = solve(i + 1, n, 1, prefixSum) - prefixSum[i + 1]; // take the 
            int skip = (i + 1 == n - 1) ? Integer.MAX_VALUE : solve(i + 1, n, 0, prefixSum);   
            return memo[i][isAlice] = Math.min(take, skip);
        }
    }

    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] prefixSum = new int[n]; 
        prefixSum[0] = stones[0];

        for(int i = 1; i < n; i++){
            prefixSum[i] = stones[i] + prefixSum[i - 1];
        }
        this.memo = new Integer[n][2];
        
        return solve(0, n, 1, prefixSum);
    }
}