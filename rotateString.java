class Solution {

    // brute force
    public boolean rotateString(String s, String goal) {
        int startIdx = 0; 
        if (s.length() != goal.length()) return false;
        int n = s.length();
        for(int i = 0; i < goal.length(); i++){
            if(goal.charAt(i) == s.charAt(0)){
                // possible sequence so loop through here 
                boolean possible = false;
                for(int j = 0; j < s.length(); j++){
                    if(goal.charAt((i + j) % n) != s.charAt(j)){
                        break;
                    } 
                    if(j == n - 1){
                        possible = true;
                    }
                }
                if(possible) return true; 
            }
        }

        return false; 
    }


    // concatenation
    public boolean rotateString2(String s, String goal) {
        if(s.length() != goal.length()) return false; 

        String doubleString = s + s; 

        return doubleString.contains(goal);
    }

}