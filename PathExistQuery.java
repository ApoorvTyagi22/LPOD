class Solution {


    int UpperBoundBinary(int[][] arr, int target){
        int n = arr.length; 
        int l = 0; 
        int r = n - 1;
        int res = 0;  // maxValue = val + maxDiff <= newVal 

        while(l <= r){
            int mid = l + (r - l)/2; 
            // is the midValue 
            if(arr[mid][0] <= target){
                res = mid; 
                l = mid + 1; 
            } else {
                r = mid - 1; 
            }
        }

        return res; 


    }

    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] arr = new int[n][2]; 
        for(int i = 0; i < n; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int[] NodeToIdx = new int[n];
        for(int i = 0; i < n; i++){
            int node = arr[i][1];
            NodeToIdx[node] = i; 
        }
        double result = Math.log(n) / Math.log(2);
        int cols = (int)result + 1; 

        int rows = n; 
        int[][] up = new int[rows][cols]; 

        // furthest we can go in 1 jump from node
        for(int node = 0; node < n; node++){
            int furtherst = UpperBoundBinary(arr, arr[node][0] + maxDiff);
            up[node][0] = furtherst;
        } 

        for(int j = 1; j < cols; j++){
            for(int node = 0; node < n; node++){
                up[node][j] = up[up[node][j - 1]][j - 1];
            }
        }
        int qs = queries.length;
        int[] res = new int[qs];
        int i = 0;
        for(int[] q : queries){
            int u = q[0];
            int v = q[1];

            int a = NodeToIdx[u];
            int b = NodeToIdx[v];
            if(a == b){
                res[i] = 0; 
                i++;
                continue; 
            }
            if(a > b){
                int temp = b; 
                b = a; 
                a = temp; 
            }
            int curr = a; 
            int jump = 0; 
            for(int col = cols - 1; col >= 0; col--){
                if(up[curr][col] < b){
                    curr = up[curr][col];
                    jump += (1 << col);
                }
            }

            if(up[curr][0] >= b){
                res[i] = jump + 1;
            } else {
                res[i] = -1; 
            }        
            i++;
        }

        return res; 

    }
}