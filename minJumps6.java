class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length; 
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i); // current val and all index this value is stored at
        }

        Queue<Integer> que = new LinkedList<>();
        que.add(0);// curr Idx 
        int steps = 0; 
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while(!que.isEmpty()){
            // check if current is end and return stesp 
            int s = que.size();
            while(s-- > 0){
                int curr = que.poll();
                if(curr == n - 1){
                    return steps; 
                }
                // no check all its possible jumps 
                // first i + 1; 
                if(curr + 1 < n && !visited[curr + 1]){// check it hasent been visited ()
                    que.add(curr + 1);
                    visited[curr + 1] = true; 
                }
                // i - 1 
                if(curr - 1 >= 0 && !visited[curr - 1]){// check it hasent been visited ()
                    que.add(curr - 1);
                    visited[curr - 1] = true; 
                }
                // now we check all the indexes with these values
                List<Integer> tmp = adj.get(arr[curr]);
                if(tmp == null) continue; 
                for(int i = tmp.size() - 1; i >= 0; i--){
                    int idx = tmp.get(i);
                    if(!visited[idx]){
                        que.add(idx);
                        visited[idx] = true; 
                    }
                }
                adj.remove(arr[curr]);
            }
            steps++; 
        }

        return -1; 
    }
}