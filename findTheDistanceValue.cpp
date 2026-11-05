class Solution {
public:
    int findTheDistanceValue(vector<int>& arr1, vector<int>& arr2, int d) {
        sort(begin(arr2), end(arr2));
        int n = arr2.size();
        int cnt = 0; 
        for(int i = 0; i < arr1.size(); i++){
            int idx = lower_bound(begin(arr2), end(arr2), arr1[i]) - begin(arr2);
            if(idx >= n) cnt += (abs(arr1[i] - arr2[n - 1]) > d);
            else if(idx == 0) cnt += (abs(arr1[i] - arr2[0]) > d);
            else cnt += (abs(arr1[i] - arr2[idx]) > d) && (abs(arr1[i] - arr2[idx - 1]) > d);
        }

        return cnt; 
    }
};
