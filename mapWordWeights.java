class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder res = new StringBuilder();
        for(String word : words){
            int l = word.length();
            int sum = 0;
            for(int i = 0; i < l; i ++){
                sum = (sum + (weights[word.charAt(i) - 'a'])) % 26;
            }
            res.append((char)('z' - sum));
            
        }

        return res.toString();
    }
}