class Solution {

    public boolean check(int val, List<List<int[]>> adj, boolean[] online, long k){
        // check if there ia a valid path from 0 to n - 1 
        // with max cost k 
        // and the score is == val  
        int n = online.length;

        PriorityQueue<long[]> que = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        que.add(new long[]{0, 0});
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0; 

        while(!que.isEmpty()){
            long[] curr = que.poll();
            int node = (int)curr[0];
            long costSoFar = curr[1];
            if(node == n - 1 && costSoFar <= k){
                return true; 
            }
            if(costSoFar > dist[node]) continue; 

            List<int[]> neis = adj.get(node);
            for(int[] ne : neis){
                int newNode = ne[0];
                int extCst = ne[1];
                if(extCst >= val && online[newNode]){
                    long newCost = costSoFar + extCst;
                    if(newCost < dist[newNode]){
                        dist[newNode] = newCost;
                        que.add(new long[]{newNode, newCost});
                    }
                }
            }
        }

        return false;
        
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        List<List<int[]>> adj = new ArrayList<>();
        int n = online.length; 
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            adj.get(u).add(new int[]{v, cost});
        }


        int l = 0; 
        int r = (int)1e9; 
        int res = -1; 
        while(l <= r){
            int mid = l + (r - l) / 2; 
            if(check(mid, adj, online, k)){
                //look for a bigger one 
                res = mid; 
                l = mid + 1;  
            } else {
                r = mid - 1; 
            }
        }

        return res;
    }
}