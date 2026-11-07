class Solution {
public:
    vector<int> assignTasks(vector<int>& servers, vector<int>& tasks) {
        int n = servers.size(); 
        int m = tasks.size();
        typedef long long ll; 
        priority_queue<vector<ll>, vector<vector<ll>>, greater<vector<ll>>> availableServers; 

        priority_queue<vector<ll>, vector<vector<ll>>, greater<vector<ll>>> inUseServers; 
        vector<int> res;
        for(int i = 0; i < n; i++){
            availableServers.push({servers[i], i});
        }

        for(int i = 0; i < m; i++){
            // step 1 check if the queue
            while(!inUseServers.empty() && inUseServers.top()[0] <= i){
                vector<ll> top = inUseServers.top();
                inUseServers.pop();
                ll ft = top[0];
                ll wt = top[1];
                ll idx = top[2];
                availableServers.push({wt, idx});
            }


            if(!availableServers.empty()){
                vector<ll> top = availableServers.top(); 
                ll wt = top[0]; ll idx = top[1];
                availableServers.pop();
                res.push_back(idx); 
                inUseServers.push({i + tasks[i], wt, idx});
            } else {
                // take the top. element off
                vector<ll> top = inUseServers.top();
                inUseServers.pop();
                ll ft = top[0];
                ll wt = top[1];
                ll idx = top[2];
                res.push_back(idx);
                inUseServers.push({ft + tasks[i], wt, idx});
            }
        }


        return res; 
    }
};