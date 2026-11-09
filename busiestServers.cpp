class Solution {
public:
    typedef pair<int, int> p; 
    vector<int> busiestServers(int k, vector<int>& arrival, vector<int>& load) {
        set<int> availableServers; 
        vector<int> countRequests(k, 0);

        for(int i = 0; i < k; i++){
            availableServers.insert(i);
        }

        priority_queue<p, vector<p>, greater<p>> pq; 
        for(int i = 0; i < load.size(); i++){
            int time = arrival[i];
            while(!pq.empty() && pq.top().first <= time){
                int server = pq.top().second; 
                pq.pop(); 
                availableServers.insert(server);
            }

            int need = (i % k);
            auto available = availableServers.lower_bound(need);

            if(available == availableServers.end()){
                available = availableServers.begin();
            }

            if(availableServers.empty()){
                continue; 
            }

            int ser = *available; 

            availableServers.erase(ser);

            pq.push({time + load[i], ser});

            countRequests[ser]++;
        }


        int mx = *max_element(begin(countRequests), end(countRequests));


        vector<int> res; 

        for(int i = 0; i < k; i++){
            if(countRequests[i] == mx){
                res.push_back(i);
            }
        }

        return res; 



    }
};