class Solution {
public:
    bool isRectangleOverlap(vector<int>& rec1, vector<int>& rec2) {
        int x1 = rec1[0]; int y1 = rec1[1];
        int x2 = rec1[2]; int y2 = rec1[3];
        int tx1 = rec2[0]; int ty1 = rec2[1];
        int tx2 = rec2[2]; int ty2 = rec2[3];
        bool res = false; 
        if(((x1 < tx2) && (tx1 < x2)) && 
            ((y1 < ty2) && (ty1 < y2))){
                res = true;
            }

        return res; 

    }
};