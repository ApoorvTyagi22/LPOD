#include <iostream>
#include <ios>
#include <vector>
#include <string>
#include <algorithm>
#include <map>
#include <set>
#include <cmath>
#include <queue>
#include <stack>
#include <numeric>
#include <iomanip>
#include <functional>
#include <unordered_set>
#include <unordered_map>

// PBDS Library for ordered_set
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>

using namespace std;
using namespace __gnu_pbds;

typedef tree<int, null_type, less<int>, rb_tree_tag, tree_order_statistics_node_update> ordered_set;
typedef long long ll;

// Standard Fast IO
#define fast_io std::ios_base::sync_with_stdio(false); std::cin.tie(NULL); std::cout.tie(NULL);

long long gcd(long long a, long long b) {
return b == 0 ? a : gcd(b, a % b);
}
long long lcm(long long a, long long b) {
if (a == 0 || b == 0) return 0;
return (a / gcd(a, b)) * b; 
}
void solve() {
    int n; cin >> n; 

    vector<ll> a(n);
    for(auto& x : a) cin >> x; 

    ll best = a[0];


    for(int j = 1; j < n; j++){
        ll mx = a[0], mn = a[0];

        for(int i = 1; i < j; i++){
            ll nmx = max({a[i], mx + a[i], 2*mx + a[i], mn + a[i], 2*mn + a[i]});
            ll nmn = min({a[i], mx + a[i], 2*mx + a[i], mn + a[i], 2*mn + a[i]});
            mx = nmx; mn = nmn;
        }

        best = max({best, a[j], a[j] + mx, a[j] - mn});

    }

    cout << best << "\n";
}

int main() {
    fast_io;
    int t = 1;
    if (!(cin >> t)) t = 1;
    while(t--) {
        solve();
    }
    return 0;
}