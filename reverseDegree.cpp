class Solution {
public:
    int reverseDegree(string s) {
        int n = s.length(); 
        int res = 0; 
        for(int i = 0; i < n; ++i){
            int currPs = (s[i] - 'a');
            int contr = (25 - currPs + 1) * (i + 1);
            res += contr;
        }

        return res;
    }
};