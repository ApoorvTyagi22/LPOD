class Solution {
public:
    bool checkString(string s) {
        int n = s.length();
        bool bseen = false; 
        for(int i = 0; i < n; i++){
            // if a 
            if(s[i] == 'a'){
                // check if b saeeen
                if(bseen){
                    return false; 
                }

                // otherwise continue; 
            }
            if(s[i] == 'b'){
                bseen = true; 
            }
        }

        return true; 
    }
};