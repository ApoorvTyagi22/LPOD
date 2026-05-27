class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lowerCase = new int[26];
        int[] upperCase = new int[26];
        int n = word.length();
        for(int i = 0; i < n; i++){
            char curr = word.charAt(i);
            int idx = 0; 
            if(curr >= 'a' && curr <= 'z'){
                idx = curr - 'a';
                if(lowerCase[idx] == -1) continue;
                if (upperCase[idx] > 0) {
                    lowerCase[idx] = -1;
                    upperCase[idx] = -1; 
                } else {
                    lowerCase[idx]++;
                }
            } else {
                idx = curr - 'A';
                if(upperCase[idx] == -1) continue;
                upperCase[idx]++;
            }
        }   
        int res = 0;
        for(int idx = 0; idx < 26; idx++){
            if(lowerCase[idx] == -1 || upperCase[idx] == -1){
                continue; 
            }
            if(lowerCase[idx] > 0 && upperCase[idx] > 0){
                res++;
            }
        }

        return res; 
    }
}