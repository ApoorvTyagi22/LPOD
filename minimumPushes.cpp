class Solution {
public:
    int minimumPushes(string word) {
        vector<int> freq(26, 0);

        for(auto& ch : word){
            freq[ch - 'a']++;
        }


        sort(begin(freq), end(freq), greater<>());

        int res = 0;
        for(int i = 0; i < 26; i++){
            int key = (i / 8) + 1;
            res += key * freq[i];
        }

        return res; 

    }
};