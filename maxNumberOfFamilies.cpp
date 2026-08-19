class Solution {
public:
    int maxNumberOfFamilies(int n, vector<vector<int>>& reservedSeats) {
        unordered_map<int, int> map; // row -> mask (10 bits) 1 for seat taken 

        for(int i = 0; i < reservedSeats.size(); i++){
            int row = reservedSeats[i][0];
            int seat = reservedSeats[i][1];
            map[row] |= (1 << seat);
        }

        int res = (n - map.size()) * 2; 

        int groupA = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int groupB = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int groupC = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

        for(auto& [row, seatMask] : map){
            bool isGroupA = ((groupA & seatMask) == 0);
            bool isGroupB = ((groupB & seatMask) == 0);
            bool isGroupC = ((groupC & seatMask) == 0);
            if(isGroupA && isGroupC){
                res += 2; 
            } else if(isGroupA || isGroupB || isGroupC){
                res += 1; 
            }
        }

        return res; 


    }
};