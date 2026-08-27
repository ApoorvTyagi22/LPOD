class Solution {
    String res = ""; 
    private boolean solve(StringBuilder curr, String s, String target, int[] freq, int i, boolean greater){
        
        if(i == s.length()){
            if(greater){
                // set answer aswell.
                res = curr.toString();
                return true; 
            } else {
                return false; 
            }
        }

        for(int j = 0; j < 26; j++){
            // choose 
            if(freq[j] == 0) continue; // cant use this 
            char toadd = (char) (j + 'a');
            if(!greater && toadd < target.charAt(i)) continue; // needs to be greater 
            // explore 
            curr.append(toadd); 
            freq[j]--; 
            boolean isGreater = greater || (toadd > target.charAt(i));
            if(solve(curr, s, target, freq, i + 1, isGreater)){
                return true; 
            }
            // undo 
            curr.deleteCharAt(curr.length() - 1); 
            freq[j]++; 
        }

        return false; 
    }

    public String lexGreaterPermutation(String s, String target) {
        StringBuilder curr = new StringBuilder();
        int n = s.length();
        int[] freq = new int[26];
        for(int i = 0; i < n; i++){
            freq[s.charAt(i) - 'a']++; 
        }
        if(solve(curr, s, target, freq, 0, false)){
            return res; 
        } else {
            return "";
        }
    }
}





