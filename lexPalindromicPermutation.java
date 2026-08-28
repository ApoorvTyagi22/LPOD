class Solution {
    char midChar = '$'; 
    int halfLen; 
    String res; 

    private boolean solve(StringBuilder halfRes, String target, int[] freq, int i, boolean isGreater){
        if(halfRes.length() == halfLen){
            StringBuilder temp = new StringBuilder(halfRes.toString());
            StringBuilder reverse = new StringBuilder(temp.toString()).reverse();
            if(midChar != '$'){
                temp.append(midChar); 
            }
            
            temp.append(reverse);
            if(temp.toString().compareTo(target) > 0){
                res = temp.toString(); 
                return true; 
            } else {
                return false; 
            }
        }



        for(char ch = 'a'; ch <= 'z'; ch++){
            if(freq[ch - 'a'] == 0) continue; 
            if(!isGreater && ch < target.charAt(i)) continue; 
            // choose 
            halfRes.append(ch); 
            freq[ch - 'a']--; 
            // explore 
            boolean newGreater = isGreater || ch > target.charAt(i);
            if(solve(halfRes,target, freq, i + 1, newGreater)){
                return true; 
            } 

            // unchoose 
            halfRes.deleteCharAt(halfRes.length() - 1);
            freq[ch - 'a']++; 
        }

        return false; 
    }

    public String lexPalindromicPermutation(String s, String target) {
        StringBuilder halfRes = new StringBuilder();
        int n = s.length();
        halfLen = n/2; 
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++; 
        }
        int oddCnt = 0;
        for(char ch = 0; ch < 26; ch++){
            if(freq[ch] % 2 == 1){
                // odd ca
                oddCnt++; 
                midChar = (char) (ch + 'a'); 
            }
            freq[ch] /= 2; 
        }
        
        if(oddCnt > 1){
            return ""; // more than 1 mid char not possible. 
        }


        if(solve(halfRes, target, freq, 0, false)){
            return res; 
        } else {
            return "";
        }
    }
}