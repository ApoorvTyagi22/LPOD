class Solution {
public:
    typedef long long ll; 
    int M = 1e9 + 7;
    
    ll findPower(ll a, ll b){
        if(b == 0){
            return 1; 
        }

        ll half = findPower(a, b / 2);
        half = (half * half) % M; 
        if(b % 2 == 1){
            half = (half * a) % M; 
        }

        return half; 

    }

    bool check(int mid, vector<int>& nums, int base) {

        int n = nums.size(); 

        ll hash = 0; 

        unordered_map<ll, int> mp; 

        ll p = findPower(base, mid - 1);

        int i = 0; 
        int j = 0; 

        while(j < n){
            hash = (hash * base + nums[j]) % M; 
            if(j - i + 1 < mid){
                j++; 
            } else {
                mp[hash]++;

                hash = (hash - (p * nums[i]) % M + M) % M; 
                i++; 
                j++; 
            }    
        }


        for(auto& it : mp){
            if(it.second == 1){
                return true;
            }
        }

        return false; 
    }
    int smallestUniqueSubarray(vector<int>& nums) {
        int n = nums.size();

        int base = *max_element(begin(nums), end(nums)) + 1; 

        int l = 1;
        int r = n; 


        int res = n;
        while(l <= r){
            int mid = l + (r - l)/2;

            if(check(mid, nums, base)){
                res = mid; 
                r = mid - 1; 
            } else {
                l = mid + 1; 
            }

        }

        return res; 
    }
};