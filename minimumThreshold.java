class Solution {

    public boolean check(int threshold, int n, List<List<int[]>> adj, int source, int target, int k){
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> {
               return Integer.compare(a[0], b[0]);
            }
        );
        
        // trying to minimise k (number of heavy nodes)
        minHeap.add(new int[]{0, source}); // current k, current node 
        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int currK = curr[0];
            int currNode = curr[1];
            if(currNode == target){
                // return true if contains < k
                if(currK <= k) return true;
            }
            visited[currNode] = true;

            for(int[] nei : adj.get(currNode)){
                int neiNode = nei[0];
                int neiW = nei[1];
                if(visited[neiNode]) continue; 
                // see if its a heavy node or light and add to queu
                int newK = currK;
                if(neiW > threshold){
                    newK++;
                } 
                minHeap.add(new int[]{newK, neiNode});
            }
        }


        return false;

        
    }
    
    public int minimumThreshold(int n, int[][] edges, int source, int target, int k){ 
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        
        //binary search on answer
        int l = 0; 
        int r = (int)1e9;
        int res = -1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(check(mid, n, adj, source, target, k)) {
                res = mid;
                // look for a smaller threshold
                r = mid - 1;
            } else {
                l = mid + 1; 
            }
        }

        return res;
        
    }
}