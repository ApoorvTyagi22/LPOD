class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] res = new char[n][m];

        // iterate through each row from the bottom 
        for(int i = m - 1; i >= 0; i--){
            // last cell to use 
            int lastCell = n - 1;
            for(int j = n - 1; j >= 0; j--){
                res[j][m - i - 1] = '.';
                if(boxGrid[i][j] == '#'){
                    res[lastCell][m - i - 1] = '#';
                    lastCell--;
                } else if(boxGrid[i][j] == '*'){
                    res[j][m - i - 1] = '*';
                    // lastCell is not ctive no more 
                    lastCell = j - 1; 
                }
            }
        }

        return res; 

    }
}