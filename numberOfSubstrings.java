class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int[] freq = new int[3];

        int i = 0; 
        int j = 0; 
        int res = 0; 
        while(j < n){
            freq[s.charAt(j) -'a']++;

            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
                res += (n - j);
                freq[s.charAt(i) - 'a']--;
                i++;
            }
            j++;
        }


        return res; 
    }
}