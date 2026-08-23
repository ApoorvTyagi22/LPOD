class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftQuestionMark = 0; 
        int rightQuestionMark = 0; 
        int leftSum = 0; 
        int rightSum = 0; 

        for(int i = 0; i < n; i++){
            if(num.charAt(i) == '?'){
                if(i < n / 2){
                    leftQuestionMark++; 
                } else {
                    rightQuestionMark++; 
                }
            } else {
                if(i < n / 2){
                    leftSum += num.charAt(i) - '0';
                } else {
                    rightSum+= num.charAt(i) - '0';
                }
            }
        }

        int totalQuestion = leftQuestionMark + rightQuestionMark;
        if(totalQuestion % 2 == 1){
            return true;
        }

        int left = 2 * leftSum + 9 * leftQuestionMark;
        int right = 2 * rightSum + 9 * rightQuestionMark;

       return (left == right) ? false : true; 
    }
}