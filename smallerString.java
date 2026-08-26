class Solution {
    String smallerString(String a, String b){
        int n = a.length();
        int m = b.length();
        int i = 0; int j = 0;
        // return the string who first sees a one other doesnt 
        while(i < n && j < m){
            int numA = a.charAt(i) - '0';
            int numB = b.charAt(j) - '0';
            i++; j++; 
            if(numA == numB){
                // same both 1 or 0 
                continue; 
            } else if(numA > numB){
                return b; 
            } else {
                return a; 
            }
        }

        return a;
    }
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        String res = "";
        int i = 0; 
        int j = 0; 
        int oneCnt = 0; 
        int bestLen = Integer.MAX_VALUE; 
        while(j < n){
            if(s.charAt(j) - '0' == 1){
                oneCnt++; 
            }
            while(oneCnt > k || (oneCnt == k && s.charAt(i) == '0')){
                    if(s.charAt(i) - '0' == 1){
                        oneCnt--; 
                    }
                    i++; 
                }
            if(oneCnt == k){
                int tempLen = j - i + 1; 
                if(tempLen < bestLen){
                    bestLen = j - i + 1;
                    res = s.substring(i, j + 1); 
                } else if(tempLen == bestLen){
                    // pick the lexicographially smaller one 
                    res = smallerString(s.substring(i, j + 1), res);
                }
                 
            }
            j++; 
        }
        return res; 
    }
}