class Solution {
public:
    typedef long long ll;
    ll MOD = 1e9 + 7;


    ll solve(vector<int>& nums, vector<ll>& fact, vector<ll>& invFact){
        int n = nums.size();
        if(n < 3){
            return 1; 
        }

        vector<int> leftSub, rightSub; 
        int root = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] < root){
                leftSub.push_back(nums[i]);
            } else {
                rightSub.push_back(nums[i]);
            }
        }

        ll x = solve(leftSub, fact, invFact); ll y = solve(rightSub, fact, invFact);
        // n-1Cleft.size
        ll z = ((fact[n - 1] * invFact[leftSub.size()]) % MOD
                              * invFact[rightSub.size()]) % MOD;


        return (((x * y) % MOD) * z) % MOD; 
    }
    // a^b
    ll findPower(ll a, ll b){
        if(b == 0) return 1; 
        ll half  = findPower(a, b / 2);
        half = (half * half) % MOD; 
        if(b % 2){
            half =( half * a ) % MOD; 
        }

        return half; 

    }
    int numOfWays(vector<int>& nums) {
        int n = nums.size();
        vector<ll> fact(n + 1, 1);
        for(int i = 1; i <= n; i++){
            fact[i] = (i * fact[i - 1]) % MOD;
        }
        vector<ll> invFact(n + 1, 1);
        invFact[n] = findPower(fact[n], MOD - 2);
        for(int i = n; i >= 1; i--){
            invFact[i - 1] = (i * invFact[i]) % MOD; 
        }
        // nCr = n!/(n - r)! * (r)!
        ll ans = solve(nums, fact, invFact);

        return (int)((ans - 1 + MOD) % MOD);
    }
};