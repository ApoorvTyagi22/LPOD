class Solution {
public:
    bool isValid(string s) {
        int n = s.length();

        stack<char> stk; 

        for(int i = 0; i < n; i++){
            if(s[i] == ')'){
                if(stk.empty() || stk.top() != '('){
                    return false; 
                }
                stk.pop();
            }
            else if(s[i] == '}'){
                if(stk.empty() || stk.top() != '{'){
                    return false; 
                }
                stk.pop();
            }
            else if(s[i] == ']'){
                if(stk.empty() || stk.top() != '['){
                    return false; 
                }
                stk.pop();
            } else {
                stk.push(s[i]);
            }
        }
        return stk.empty(); 
    }
}; 