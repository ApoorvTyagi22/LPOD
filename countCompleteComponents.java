class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1]; 
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int res = 0; 
        boolean[] visited = new boolean[n];
        // nC2 == (vertices * (vertices - 1))/2 == numEdges -> res++;  
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                int vertices = 0; 
                int numEdges = 0; 
                ArrayDeque<Integer> stk = new ArrayDeque<>();
                stk.push(i);
                visited[i] = true; 
                while(!stk.isEmpty()){
                    int curr = stk.pop();
                    vertices++; 
                    numEdges += adj.get(curr).size();
                    for(int nei : adj.get(curr)){
                        if(!visited[nei]){
                            stk.push(nei);
                            visited[nei] = true; 
                        }
                    }
                }

                if((vertices * (vertices - 1)) == numEdges){
                    res++; 
                }
            }
        }

        return res; 
    }
}