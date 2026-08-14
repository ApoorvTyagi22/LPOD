class Solution {
public:
    int maximumLengthSubstring(string s) {
        int n = s.length();
        unordered_map<int, int> cnt; 

        int i = 0, j = 0; 
        int bestLen = 0;
        while(j < n){
            // if j is not in set add and update ans 
            if(cnt[s[j] - 'a'] < 2){               
                cnt[s[j] - 'a']++; 
                bestLen = max(bestLen, j - i + 1);
            } else {
                // its in the set and either => 
                while(cnt[s[j] - 'a'] >= 2){
                    cnt[s[i] - 'a']--; 
                    i++; 
                }
                cnt[s[j] - 'a']++; 
            }
            j++;
        }

        return bestLen; 
    }
};