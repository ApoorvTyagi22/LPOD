class Solution {
public:
    int scoreOfParentheses(string s) {
        int n = s.length();
        int open = 0; 
        int res = 0; 
        for(int i = 0; i < n; i++){
            if(s[i] == '('){
                open++; 
            } else {
                // its a closed if open is 1 then closed is 1
                open--; 
                if(s[i - 1] =='(') res += (1 << open);
            }
        }
        return res; 
    }
};