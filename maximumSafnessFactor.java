class Solution {

    public boolean check(int val, List<List<Integer>> grid, int[][] dist){
        if (dist[0][0] < val) return false;
        int n = grid.size();
        int m = grid.get(0).size();
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0});
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true; 
        int[][] dir = new int[][]{{0,1},{0, -1}, {1, 0}, {-1, 0}};

        while(!que.isEmpty()){
            int[] curr = que.poll();
            int x = curr[0];
            int y = curr[1];
            if(x == n - 1 && y == m - 1)    
                return true; 

            for(int[] d : dir){
                int x_ = x + d[0];
                int y_ = y + d[1];
                if(x_ >= 0 && x_ < n && y_ >= 0 && y_ < m && !visited[x_][y_] && dist[x_][y_] >= val){
                    visited[x_][y_] = true; 
                    que.add(new int[]{x_, y_});
                 }
            }
        }

        return false; 

    }


    public int maximumSafenessFactor(List<List<Integer>> grid) {
       int n = grid.size();
       int m = grid.get(0).size();
       int[][] dir = new int[][]{{0,1},{0, -1}, {1, 0}, {-1, 0}};
       int[][] dist = new int[n][m];
       boolean[][] visited = new boolean[n][m]; 
       Queue<int[]> que = new LinkedList<>();
       for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist[i][j] = -1; 
                if(grid.get(i).get(j) == 1) 
                    {que.add(new int[]{i, j}); 
                    dist[i][j] = 0; 
                    visited[i][j] = true; }
            }
       }

       int lev = 1; 

       while(!que.isEmpty()){
            int k = que.size();
            while(k-- > 0){
                int[] curr = que.poll();
                for(int[] d : dir){
                    int x_ = curr[0] + d[0];
                    int y_ = curr[1] + d[1];
                    if(x_ >= 0 && x_ < n && y_ >= 0 && y_ < m && !visited[x_][y_]){
                        dist[x_][y_] = lev; 
                        visited[x_][y_] = true; 
                        que.add(new int[]{x_, y_});
                    }
                }
            }
            lev++;
       }

        int l = 0; 
        int r = n + m; 
        int res = 0;
        while(l <= r){
            int mid = l + (r - l)/2; 
            if(check(mid, grid, dist)){
               // try a bigger distance 
               res = mid; 
               l = mid + 1;  
            } else {
                r = mid - 1; 
            }
        }

        return res; 

    }
}