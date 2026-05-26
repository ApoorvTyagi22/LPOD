class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int[] freq = new int[52];
        for(int i = 0; i < n; i++){
            char curr = word.charAt(i);
            if(curr >= 'a' && curr <= 'z'){
                freq[curr - 'a']++;
            } else {
                freq[curr - 'A' + 26]++;
            }
        }
        int count = 0; 
        for(int i = 0; i < 26; i++){
            if(freq[i] > 0 && freq[i + 26] > 0){
                count++;
            }
        }

        return count; 





    }
}