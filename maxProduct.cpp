class Solution {
public:
    int maxProduct(int n) {
        vector<int> freq(10, 0);
        
        while(n > 0){
            int digit = n % 10; 
            n = n / 10; 
            freq[digit]++;
        }
        int best = 0; 
        int secondBest = 0; 

        for(int i = 9; i >= 1; i--){
            if(freq[i] > 0 && best == 0){
                best = i;
                freq[i]--; 
            } 
            if(freq[i] > 0 && secondBest == 0){
                secondBest = i;
                freq[i]--; 
            }
            if(best != 0 && secondBest != 0){
                return best * secondBest; 
            }
        }

        return 0;
    }
};