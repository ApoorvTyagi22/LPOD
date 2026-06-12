class Solution {
    List<List<Integer>> adj; 
    int[][] up;
    int[] depth;
    int rows, cols, log_2; 
    int MOD = (int)1e9 + 7; 

    public void dfs(int node, int parent){
        up[node][0] = parent;

        for(int nei : adj.get(node)){
            if(depth[nei] != -1){
                depth[nei] = depth[node] + 1; 
                dfs(nei, node);
            }
        }
    }

    public int lca(int u, int v){
        // first get all on the samee depth 
        if(depth[u] < depth[v]){
            int temp = u; 
            u = v; 
            v = temp; 
        }

        // u is deeper so bring it on the same level as v

        int diff = depth[u] - depth[v];

        for(int j = 0; j < log_2; j++){
            if(((diff >> j) & 1) == 1) {
                u = up[u][j];
            }
        }


        if(u == v) return u;

        for(int j = log_2 - 1; j >= 0; j--){
            if(up[u][j] != up[v][j]){
                u = up[u][j];
                v = up[v][j];
            }
        }

        return up[u][0];
    }


    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        this.adj = new ArrayList<>();
        int n = edges.length + 1; 
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        this.log_2 = 1; 
        while((1 << log_2) < n) log_2++;
        this.rows = n; 
        this.cols = log_2 + 1; 
        this.up = new int[rows][cols];
        this.depth = new int[n];
        Arrays.fill(depth, -1);

        for(int[] edge : edges){
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        depth[0] = 0;
        dfs(0, -1);
        int[] res = new int[queries.length + 1];
        int idx = 0;
        for(int[] query : queries){
            int u = query[0];
            int v = query[1];
            if(depth[u] == depth[v]){
                res[idx] = 0;
                continue; 
            }
            int lca_u_v = lca(u, v);
            int d = (depth[u] + depth[v] - 2 * lca_u_v) % MOD;
            idx++;
        }

        return res; 

    }
}