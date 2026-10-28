class Solution {
public:
    int minCost(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();

        vector<vector<bitset<1024>>> mask(m, vector<bitset<1024>>(n));
        mask[0][0][grid[0][0]] = 1; 
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                bitset<1024> up, left; 
                if(i - 1 >= 0) {
                    up = mask[i - 1][j];
                }
                if(j - 1 >= 0){
                    left = mask[i][j - 1];
                }

                auto combined = up | left; 

                for(int k = 0; k < 1024; k++){
                    if(combined[k]){
                        mask[i][j][k ^ grid[i][j]] = 1; 
                    }
                }
            }
        }


        for(int i = 0; i < 1024; i++){
            if(mask[m - 1][n - 1][i] != 0){
                return i;
            }
        }

        return -1; 
    }
};