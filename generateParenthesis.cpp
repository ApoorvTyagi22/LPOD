class Solution {
public:
    void solve(int n, int cnt, string& temp, vector<string>& res){
        if(temp.size() ==  2 * n){
            if(cnt == 0) res.push_back(temp);
            return; 
        }

        // two choices close a bracket
        if(cnt > 0){
            int newCnt = cnt - 1; 
            string newString = (temp += ')');
            solve(n, cnt - 1, newString, res);
            temp.erase(temp.length() - 1, 1);
        }
        // otherwise tryopening a new one 
        if(cnt < n){
            int newCnt = cnt + 1; 
            string newString = (temp += '(');
            solve(n, newCnt, newString, res);
            temp.erase(temp.length() - 1, 1);
        }
    }   
    vector<string> generateParenthesis(int n) {
        vector<string> res; 
        string temp;
        solve(n, 0, temp, res);
        return res; 
    }
};class Solution {
public:
    void solve(int n, int cnt, string& temp, vector<string>& res){
        if(temp.size() ==  2 * n){
            if(cnt == 0) res.push_back(temp);
            return; 
        }

        // two choices close a bracket
        if(cnt > 0){
            int newCnt = cnt - 1; 
            string newString = (temp += ')');
            solve(n, cnt - 1, newString, res);
            temp.erase(temp.length() - 1, 1);
        }
        // otherwise tryopening a new one 
        if(cnt < n){
            int newCnt = cnt + 1; 
            string newString = (temp += '(');
            solve(n, newCnt, newString, res);
            temp.erase(temp.length() - 1, 1);
        }
    }   
    vector<string> generateParenthesis(int n) {
        vector<string> res; 
        string temp;
        solve(n, 0, temp, res);
        return res; 
    }
};