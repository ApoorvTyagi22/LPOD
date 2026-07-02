class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size(); int m = grid.get(0).size(); 
        
        ArrayDeque<int[]> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        que.add(new int[]{0, 0, health}); // x,y, currHealth
        visited[0][0] = true; 
        int[][] dirs = new int[][]{{0, 1},{0, -1}, {1, 0}, {-1, 0}};

        while(!que.isEmpty()){
            int[] curr = que.poll();
            int x = curr[0];
            int y = curr[1];
            int curHealth = curr[2];
            int newHealth = curHealth - grid.get(x).get(y);

            if(x == n - 1 && y == m - 1 && newHealth > 0){
                return true; 
            }
            for(int[] d : dirs){
                int x_ = x + d[0];
                int y_ = y + d[1];
                if(x_ >= 0 && x_ < n && y_ >= 0 && y_ < m && !visited[x_][y_]){
                    visited[x_][y_] = true; 
                    if(grid.get(x_).get(y_) != 1){
                        // add to the front
                        que.addFirst(new int[]{x_, y_, newHealth});
                    } else {
                        // otherwise to the back 
                        que.addLast(new int[]{x_, y_, newHealth});
                    }
                } 
            }
        }

        return false; 

    }
}