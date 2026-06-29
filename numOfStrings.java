class Solution {
    public int numOfStrings(String[] patterns, String word) {
        HashSet<String> set = new HashSet<>();
        int n = word.length();

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                set.add(word.substring(i, j + 1));
            }
        }

        int res = 0; 

        for(String pattern : patterns){
            if(set.contains(pattern)){
                res++;
            }
        }

        return res; 
    }
}