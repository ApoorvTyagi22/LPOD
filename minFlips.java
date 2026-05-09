class Solution {
    public int minFlips(String s) {
        int n = s.length();
        if(n < 3) return 0;
        int oneCount = 0;
        int zeroCount = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1'){
                oneCount++;
            } else {
                zeroCount++;
            }
        }

        // operations to make it all 1 (flip all zeroes)
        // Or make it all zero 
        int minOps = Math.min(zeroCount, oneCount);

        // have a single one 
        if(oneCount > 0) {minOps = Math.min(minOps, oneCount - 1);}

        // lastly have 2 ones but at the end an zero in the middle 
        int tmp = 0;
        if(s.charAt(0) == '0') tmp++;
        if(s.charAt(n - 1) == '0') tmp++;

        for(int i = 1; i < n - 1; i++){
            
            if(s.charAt(i) == '1') tmp++;
        }

        return Math.min(tmp, minOps);
        
    }
}