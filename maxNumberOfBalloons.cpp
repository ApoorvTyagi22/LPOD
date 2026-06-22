class Solution {
public:
    int maxNumberOfBalloons(string text) {
        map<char, int> mp;
        for(char& ch : text){
            if(ch != 'b' && ch != 'a' && ch != 'l' && ch != 'o' && ch != 'n')   continue; 
            mp[ch]++;
        }
        mp['l'] = mp['l'] / 2; 
        mp['o'] = mp['o'] / 2; 

        return min({mp['b'],mp['a'],mp['l'],mp['o'],mp['n']});
    }
};