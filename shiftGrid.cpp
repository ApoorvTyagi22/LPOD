class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {
        int m = grid.size();
        int n = grid[0].size();
        
        for (int shift = 0; shift < k; ++shift) {
            vector<vector<int>> next_grid(m, vector<int>(n, 0));
            
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (j < n - 1) {
                        next_grid[i][j + 1] = grid[i][j];
                    } else if (i < m - 1) {
                        next_grid[i + 1][0] = grid[i][j];
                    } else {
                        next_grid[0][0] = grid[i][j];
                    }
                }
            }
            grid = next_grid;
        }
        
        return grid;
    }
};