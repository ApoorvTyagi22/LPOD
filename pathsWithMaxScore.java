class Solution {
    int MOD = (int)1e9 + 7; 
    Integer[][][] memo; 
    int getIntFromChar(char ch){
        return ch != 'S' ? ch - '0' : 0; 
    }
    private int[] solve(int i, int j, List<String> board){
        if(i == 0 && j == 0){
            return new int[]{0, 1};
        } else if(i < 0 || j < 0 || board.get(i).charAt(j) == 'X'){
            return new int[]{0, 0};
        } 

        if(memo[i][j][0] != null && memo[i][j][1] != null){
            return new int[]{memo[i][j][0], memo[i][j][1]};
        }
        
        char ch  = board.get(i).charAt(j); 
        int[] up = solve(i - 1, j, board);
        int upScore = up[0]; int upPath = up[1];
        if(upPath > 0){
            upScore = upScore + (getIntFromChar(ch));
        }
        int[] left = solve(i, j - 1, board);
        int lftScore = left[0]; int lftPath = left[1];
        if(lftPath > 0){
            lftScore = lftScore + (getIntFromChar(ch));
        }
        int[] diag = solve(i - 1, j - 1, board);
        int digScore = diag[0]; int digPath = diag[1];
        if(digPath > 0){
            digScore = digScore + (getIntFromChar(ch));
        }
        int BestScore = 0; int BestPath = 0; 
        if(upScore == lftScore && lftScore == digScore){
            // All same
            BestScore = upScore;
            BestPath = upPath + lftPath + digPath;
        } else if (upScore == lftScore){
            BestScore = upScore; BestPath = upPath + lftPath;
            if(digScore > BestScore){
                BestScore = digScore;
                BestPath = digPath; 
            }
        } else if(lftScore == digScore){
            BestScore = lftScore; BestPath = lftPath + digPath;
            if(upScore > BestScore){
                BestScore = upScore; 
                BestPath = upPath; 
            }
        } else {
            // All are different; 
            BestScore = upScore; 
            BestPath = upPath; 
            // Check wit left 
            if(lftScore > BestScore){
                BestScore = lftScore; 
                BestPath = lftPath; 
            }  
            if(digScore > BestScore){
                BestScore = digScore; 
                BestPath = digPath; 
            }
        }
        memo[i][j][0] = BestScore;
        memo[i][j][1] = BestPath % MOD; 
        return new int[]{memo[i][j][0], memo[i][j][1]};
    }
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        this.memo = new Integer[n + 1][n + 1][2];
        return solve(n - 1, n - 1, board);
    }
}