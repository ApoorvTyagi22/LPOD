class Solution {
public:
    typedef pair<int, int> P; 
    int secondMinimum(int n, vector<vector<int>>& edges, int time, int change) {
        unordered_map<int, vector<int>> adj; 
        
        for(auto& edge : edges){
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        const int INF = (int)1e9;
        priority_queue<P, vector<P>, greater<P>> pq; 
        vector<int> minDist(n, INF);
        vector<int> secMinDist(n, INF);
    
        pq.push({0, 0}); // timePassed, node
        minDist[0] = 0; 
        while(!pq.empty()){
            auto [timePassed, node] = pq.top(); pq.pop();
            if(node == n - 1 && secMinDist[node] != INF){
                return secMinDist[node];
            }
            int digit = timePassed / change; 
            // if its odd then we must add some time else continue 
            if(digit % 2){
                timePassed = (digit + 1) * change; 
            }

            for(auto& ngr : adj[node]){
                int newTime = timePassed + time;
                if(minDist[ngr] > newTime){
                    secMinDist[ngr] = minDist[ngr];
                    minDist[ngr] = newTime;
                    pq.push({newTime, ngr});
                } else if(newTime > minDist[ngr] && secMinDist[ngr] > newTime){
                    secMinDist[ngr] = newTime;
                    pq.push({newTime, ngr});
                }

            }
        }
        return -1;
    }
};