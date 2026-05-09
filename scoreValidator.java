class Solution {
    public int[] scoreValidator(String[] events) {
        int score = 0;
        int counter = 0; 
        int i = 0; 
        int n = events.length; 
        while(i < n && counter < 10){
            String curr = events[i];
            if(curr.equals("W")){
                counter++;
            } else if (curr.equals("WD") || curr.equals("NB")){
                score++;
            } else {
                score = score + (int) (curr.charAt(0) - '0');
            }
            i++;
        }

        return new int[] {score, counter};
    }
}