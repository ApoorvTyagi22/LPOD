class Solution {
public:
    string reverseParentheses(string s) {
        int n = s.length();
        stack<int> stk; 
        string res = "";
        int i = 0;
        while(i < n){
            if(s[i] == '('){
                stk.push(res.length());
            } else if(s[i] == ')'){
                int l = stk.top();
                stk.pop();
                reverse(res.begin() + l, res.end());
            } else {
                res.push_back(s[i]);
            }
            i++;
        }

        return res;  
    }
};