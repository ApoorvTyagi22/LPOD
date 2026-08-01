class Solution {
public:
    // need diff = p1_score - p2_score >= 0 for true
    int solve(int i, int j, int isPlayer1, vector<int>& nums){ // i, j, 0/1
        if(i > j){
            return 0; 
        }
        
        if(isPlayer1 == 1){// then this player 1 turn and he picks i 
           int c1 = solve(i + 1, j, 0, nums) + nums[i];
           int c2 = solve(i, j - 1, 0, nums) + nums[j];
           return max(c1, c2);
        } else { // this is player2
           int c1 = solve(i + 1, j, 1, nums) - nums[i];
           int c2 = solve(i, j - 1, 1, nums) - nums[j];
           return min(c1, c2);
        }
    }

    bool predictTheWinner(vector<int>& nums) {
        int n = nums.size() - 1; 
        return (solve(0, n, 1, nums) >= 0) ? true : false;
    }
};