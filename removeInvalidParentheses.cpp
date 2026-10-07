class Solution {
public:
    int n;
    int maxLen;
    unordered_set<string> st;      

    void solve(int i, string& curr, string& s, int count){
        if(count < 0) return;

        if(i == n){
            if(count == 0){
                int len = (int)curr.length();
                if(len > maxLen){
                    maxLen = len;
                    st.clear();
                }
                if(len == maxLen) st.insert(curr);
            }
            return; 
        }

        if(s[i] != '(' && s[i] != ')'){
            curr.push_back(s[i]);
            solve(i + 1, curr, s, count);
            curr.pop_back();
            return; 
        }

        curr.push_back(s[i]);
        solve(i + 1, curr, s, count + (s[i] == '(' ? 1 : -1));
        curr.pop_back();
        solve(i + 1, curr, s, count);
    }

    vector<string> removeInvalidParentheses(string s) {
        n = s.length();
        st.clear();
        maxLen = -1;
        string curr = "";
        solve(0, curr, s, 0);    
        return vector<string>(begin(st), end(st));    
    }
}; 