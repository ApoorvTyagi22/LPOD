class Solution {
    public String processStr(String s) {
        int n = s.length();
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '*'){
                // remove last char
                if(str.length() > 0){
                    str.deleteCharAt(str.length() - 1);
                }
            } else if(s.charAt(i) == '#'){
                // duplicate the curren resulst and append 
                int currentLen = str.length();
                for(int j = 0; j < currentLen; j++){
                    str.append(str.charAt(j));
                }
            }else if(s.charAt(i) == '%'){  
                // reveuse the current string 
                StringBuilder temp = new StringBuilder();
                for(int j = str.length() - 1; j >= 0; j--){
                    temp.append(str.charAt(j));
                }
                str = temp;
            } else{
                // append as it is 
                str.append(s.charAt(i));
            }
        }

        return str.toString();
    }
}