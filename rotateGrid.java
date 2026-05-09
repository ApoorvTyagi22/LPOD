class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length; 
        int numRows = m / 2; 
        int numCols = n / 2; 
        int minLayer = Math.min(numRows, numCols);
        int[][] res = new int[m][n];
        
        for(int layer = 0; layer < minLayer; layer++){
            int top = layer; 
            int bottom = m - layer - 1; 
            int left = layer; 
            int right = n - layer - 1;

            List<Integer> arr = new ArrayList<>();

            // traverse the layer 
            // in top row from left to right
            for(int i = left; i <= right; i++){
                arr.add(grid[top][i]);
            }

            // in right column from top row to bottom
            for(int i = top + 1; i <= bottom; i++){
                arr.add(grid[i][right]);
            }

            // in bottom row from right to left 
            for(int i = right - 1; i >= left; i--){
                arr.add(grid[bottom][i]);
            }

            // in left column from bottom to top

            for(int i = bottom - 1; i > top; i--){
                arr.add(grid[i][left]);
            }

            Collections.rotate(arr, -k);

            // now traverse the res and place the elements 
            int cnt = 0;
            for(int i = left; i <= right; i++){
                res[top][i] = arr.get(cnt);
                cnt++;
            }

            for(int i = top + 1; i <= bottom; i++){
                res[i][right] = arr.get(cnt);
                cnt++;
            }

            for(int i = right - 1; i >= left; i--){
                res[bottom][i] = arr.get(cnt);
                cnt++;
            }

            for(int i = bottom - 1; i > top; i--){
                res[i][left] = arr.get(cnt);
                cnt++;
            }

        }

        return res; 


    }
}