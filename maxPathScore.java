class Solution {
    int m, n;
    int[][] grid;
    Integer[][][] memo;
    public int maxPathScore(int[][] grid, int k) {
        this.grid = grid; 
        m = grid.length; 
        n = grid[0].length; 
        this.memo = new Integer[m + 1][n + 1][k + 1];
        

        return solve(0, 0, 0, k); // i, j, currCost, k
    }

    public int solve(int i, int j, int currCost, int k){
        if(i >= m || j >= n){
            return -1; 
        }
        int newCost = currCost + (grid[i][j] > 0 ? 1 : 0);
        
        if(newCost > k){
            return -1; 
        }

        if(i == m - 1 && j == n - 1){
            return grid[i][j];
        }
        if(memo[i][j][currCost] != null){
            return memo[i][j][currCost];
        }

        // otherwise 2 choices 

        int rightChoice = solve(i, j + 1, newCost, k);
        int downChoice =  solve(i + 1, j, newCost, k);

        if(rightChoice == -1 && downChoice == -1){
            return memo[i][j][currCost] = -1; 
        }

        return memo[i][j][currCost] = Math.max(rightChoice, downChoice) + grid[i][j];
    }
}