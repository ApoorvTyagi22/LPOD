class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] res = new int[m];
        int[] suffixMatch = new int[n];
        
        int matched = 0; 
        int j = m - 1; 
        for(int i = n - 1; i >= 0; i--){
            if(j >= 0 && word2.charAt(j) == word1.charAt(i)){
                matched++; 
                j--; 
            }
            suffixMatch[i] = matched; 
        }

        int i = 0; 
        j = 0; 
        int idx = 0;
        boolean canChange = true; 
        while(i < n && j < m){
            if(j < m && word1.charAt(i) == word2.charAt(j)){    
                res[idx++] = i;    
                j++; 
            } else if(canChange == true && i + 1 < n && suffixMatch[i + 1] >= m - j - 1){
                canChange = false; 
                res[idx++] = i; 
                j++; 
            }
            i++; 
        }

        return (j >= m) ? res : new int[0];
    }
}