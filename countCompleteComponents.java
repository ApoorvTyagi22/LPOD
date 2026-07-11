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


//// Second Approach: Using DSU (Disjoint Set Union)

class Solution {
    int[] parent, size; 

    int find(int n1){
        if(parent[n1] == n1){
            return n1; 
        } 
        return parent[n1] = find(parent[n1]);
        
    }

    boolean unite(int n1, int n2){
        int root1 = find(n1);
        int root2 = find(n2);
        if(root1 == root2){
            return false; 
        }

        if(size[root1] > size[root2]){
            // merge root2 into root1
            parent[root2] = root1; 
            size[root1] += size[root2]; 
        } else {
            parent[root1] = root2; 
            size[root2] += size[root1]; 
        }

        return true; 
    }

    public int countCompleteComponents(int n, int[][] edges) {
        this.parent = new int[n];
        this.size = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1; 
        }


        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            unite(u, v);
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int root = find(u);
            map.put(root, map.getOrDefault(root, 0) + 1);
        }


        int res = 0; 

        for(int i = 0; i < n; i++){
            if(find(i) == i){
                int v = size[i];
                int e = map.getOrDefault(i, 0);

                if((v *(v - 1)/ 2 == e)){
                    res++;
                }
            }
        }

        return res; 

        
    }
}