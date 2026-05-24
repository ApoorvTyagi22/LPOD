class Solution {
    Integer[] memo; 
    int n;
    public int solve(int[] arr, int i, int d){
        if(memo[i] != null){
            return memo[i];
        }

        int res = 0;

        // check all left (i - d) ... (i - 1)
         for(int j = i - 1; j >= Math.max(0, i - d); j--){
            if(arr[j] >= arr[i]) break; 
            res = Math.max(res, solve(arr, j, d) + 1);
        }
        
        // check all right (i + 1) ... (i + d)
        for(int j = i + 1; j <= Math.min(n - 1, i + d); j++){
            if(arr[j] >= arr[i]) break; 
            res = Math.max(res, solve(arr, j, d) + 1);
        }

        return memo[i] = res; 
    }
    
    public int maxJumps(int[] arr, int d) {
        int res = 0; 
        this.n = arr.length;
        this.memo = new Integer[n];
        for(int i = 0; i < n; i++){
            res = Math.max(res, solve(arr, i, d));
        }
        return res + 1; 
    }
}