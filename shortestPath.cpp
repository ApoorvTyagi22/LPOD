class Solution {
public:
    int shortestPath(int n, vector<vector<int>>& edges, string labels, int k) {
        unordered_map<int, vector<pair<int, int>>> map; 

        for(auto& edge : edges){
            int u, v, w; 
            u = edge[0]; v = edge[1]; w = edge[2];
            map[u].push_back({v, w});
        }

        priority_queue<array<int,3>, vector<array<int,3>>, greater<array<int,3>>> pq;


        pq.push({0, 0, 1}); // weight so Far, prevNode, current K
        vector<vector<int>> minDist(n, vector<int>(k + 1, 1e9));
        while(!pq.empty()){
            auto [weight, node, currK] = pq.top(); pq.pop();
            if(minDist[node][currK] < weight) continue; // pruning 
            minDist[node][currK] = weight; 
            // otherwise this is a shorter path look at all neighbours 
            for(auto& [v, w] : map[node]){
                int newK = currK; 
                if(labels[v] == labels[node]){
                    newK++; 
                } else {
                    newK = 1; 
                }

                if(newK > k) continue; // cant explore this 
                // otherwise explore this 
                pq.push({weight + w, v, newK});
            }
        }
        int res = 1e9; 
        for(int i = 0; i <= k; i++){
            if(minDist[n - 1][i] < res){
                res = minDist[n - 1][i];
            }
        }

        return res == 1e9 ? -1 : res; 
    }
};