class Solution {
public:
    bool stoneGameIX(vector<int>& stones) {
        int n = stones.size();
        int c0 = 0, c1 = 0, c2 = 0; 
        for(int i = 0; i < n; i++){
            if(stones[i] % 3 == 0){
                c0++; 
            } else if(stones[i] % 3 == 1){
                c1++; 
            } else {
                c2++;
            }
        }
        bool aliceWin = false; 
        if(c0 % 2 == 0){
            // even no impact 
            if(c1 > 0 && c2 > 0){
                if(c2 >= c1 || c1 >= c2){
                    aliceWin = true; 
                }
            }
        } else {
            if(abs(c2 - c1) >= 3){
                aliceWin = true; 
            }
        }



        return aliceWin; 
    }
};