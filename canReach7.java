class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if(s.charAt(n - 1) != '0') return false; 
        boolean[] dp = new boolean[n];
        dp[0] = true; 

        int rechableInWindow = 0; 

        for(int i = 0; i < n; i++){
            if(i >= minJump && dp[i - minJump]){
                rechableInWindow++;
            }

            if(i > maxJump && dp[i - maxJump - 1]){
                rechableInWindow--;
            }

            if(s.charAt(i) == '0' && rechableInWindow > 0){
                dp[i] = true; 
            }
        }

        return dp[n - 1];

    }
}