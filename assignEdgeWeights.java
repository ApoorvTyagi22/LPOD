class Solution {
    long MOD = (long)1e9 + 7; 
    private int maxDepth(List<List<Integer>> adj, int node, int parent){
        int var = 0; 
        for(int nei : adj.get(node)){
            if(parent == nei) continue; 
            var = Math.max(var, maxDepth(adj, nei, node) + 1);
        }
        // if no nei = 0
        return var; 
    }   

    private long binaryExpo(long a, long b){
        if(b == 0){
            return 1; 
        }
        long a_half = binaryExpo(a, b / 2);
        long res = a_half; 
        res = (res * a_half) % MOD; 
        if(b % 2 == 1){
            res = (res * a) % MOD;  
        } 
        return res;
    }

    public int assignEdgeWeights(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length + 1;
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int d = maxDepth(adj, 1, -1);

        // we only have half paths that are odd 2^(d - 1)

        long res = binaryExpo(2, d - 1);

        return (int) res; 
    }   
}