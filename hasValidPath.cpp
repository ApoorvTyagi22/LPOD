class Solution {
public:

    int memo[101][101][201];
    bool solve(int i, int j, int cnt, int m, int n, vector<vector<char>>& grid){
        if(i >= n || j >= m || cnt < 0){
            return false; 
        }

        int add1 = grid[i][j] == '(' ? 1 : -1;
        if(i == n - 1 && j == m - 1){
          cnt += add1; 
          if(cnt == 0) return true;
          return false; 
        }
        
        if(memo[i][j][cnt] != -1){
            return memo[i][j][cnt];
        }
        
        bool down = solve(i + 1, j, cnt + add1, m, n, grid);
        bool right = solve(i, j + 1, cnt + add1, m, n, grid);

        return memo[i][j][cnt] = down || right; 

    }

    bool hasValidPath(vector<vector<char>>& grid) {
        int n = grid.size();
        int m = grid[0].size(); 
        memset(memo, -1, sizeof(memo));
        return solve(0, 0, 0, m, n, grid);
    }
};