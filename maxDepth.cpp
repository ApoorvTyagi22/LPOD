class Solution {
public:
    int maxDepth(string s) {
        int n = s.length();
        int maxCnt = 0; 
        int curr = 0; 
        for(int i = 0; i < n; i++){
            if(s[i] == '('){
                curr++; 
            } else if(s[i] == ')'){
                curr--; 
            }
            maxCnt = max(maxCnt, curr);
        }

        return maxCnt;
    }
};