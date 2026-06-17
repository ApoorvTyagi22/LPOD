class Solution {
    public char processStr(String s, long k) {
        long L = 0; 
        int n = s.length();
        for(char ch : s.toCharArray()){
            if(ch == '*'){
                if(L > 0) L--;
            } else if(ch == '#'){
                L = L * 2; 
            } else if(ch == '%'){
                continue; 
            } else {
                L++;
            }
        }

        if(k >= L) {
            return '.';
        }

        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == '*'){
                L++; 
            } else if(s.charAt(i) == '#'){
                L = L / 2; 
                if(k >= L){
                    k = k - L;
                }
            } else if(s.charAt(i) == '%'){
                k = L - k - 1; 
            } else {
                L--;
            }
            

            if(L == k){
                return s.charAt(i);
            }
        }

        return '.';
    }
}