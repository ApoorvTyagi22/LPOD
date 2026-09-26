class Solution {
public:
    string evaluate(string s, vector<vector<string>>& knowledge) {
        int n = s.length();
        unordered_map<string, string> map; 

        for(auto& vec : knowledge){
            map[vec[0]] = vec[1];
        }

        string result = ""; 
        string temp = "";
        bool isBracketOn = false; 
        int i = 0; 


        while(i < n){
            if(s[i] == '('){
                isBracketOn = true;
            } else if(s[i] == ')'){
                isBracketOn = false; 
                result += map.count(temp) ? map[temp] : "?";
                temp = "";
            } else if(isBracketOn){
                temp += s[i];
            } else {
                result += s[i];
            }
            i++;
        }

        return result; 

    }
};