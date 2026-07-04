class Solution {
    public int minScore(int n, int[][] roads) {
        boolean[] visited = new boolean[n];
        ArrayDeque<Integer> que = new ArrayDeque<>();
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] road : roads){
            int u = road[0] - 1;
            int v = road[1] - 1;
            int cst = road[2];
            adj.get(u).add(new int[]{v, cst});
            adj.get(v).add(new int[]{u, cst});
        }


        que.push(0);
        int res = Integer.MAX_VALUE; 

        while(!que.isEmpty()){
            int curr = que.pop();
            for(int[] nei : adj.get(curr)){
                int nd = nei[0];
                int curCst = nei[1];
                res = Math.min(res, curCst);
                if(!visited[nd]){
                    que.push(nd);
                    visited[nd] = true; 
                }

            }
        }

        return res; 

    }
}







