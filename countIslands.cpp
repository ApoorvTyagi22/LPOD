class Solution {
public:
    int countIslands(vector<vector<int>>& grid, int k) {
        int n = grid.size(); 
        int m = grid[0].size(); 

        vector<vector<bool>> visited(n, vector<bool>(m, false)); 
        vector<vector<int>> dir = {{1,0}, {-1,0}, {0, 1}, {0, -1}};
        int res = 0; 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                 if(!visited[i][j] && grid[i][j] != 0){ 
                    stack<pair<int, int>> stk; 
                    stk.push({i, j});
                    long long sum = grid[i][j];
                    visited[i][j] = true; 
                    while(!stk.empty()){
                        int x = stk.top().first;
                        int y = stk.top().second; 
                        stk.pop();
                        for(auto d : dir){
                           int x_ = x + d[0];
                           int y_ = y + d[1];

                           if(x_ >= 0 && x_ < n && y_ >= 0 && y_ < m && !visited[x_][y_]&& grid[x_][y_] != 0){
                                sum += grid[x_][y_];
                                visited[x_][y_] = true; 
                                stk.push({x_, y_});
                           }
                        }
                    }

                    if(sum % k == 0){
                        res++;
                    }
                }
            }
        }


        return res; 
    }
};