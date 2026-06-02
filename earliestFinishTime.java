class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length; 
        int m = waterStartTime.length; 
        int res = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // see if we can do i -> j, or j -> i; 
                // i -> j: 
                int i_time = landStartTime[i] + landDuration[i];
                int waterStart = waterStartTime[j]; 
                int j_time = waterDuration[j];
                if(waterStart >= i_time){
                   j_time = (waterStart - i_time) + waterDuration[j];
                }
                int choice1 = j_time + i_time; 
                res = Math.min(res, choice1);

                // second j -> i; 

                int k_time = waterStartTime[j] + waterDuration[j];
                int landStart = landStartTime[i]; 
                int l_time = landDuration[i];
                if(landStart >= k_time){
                   l_time = (landStart - k_time) + landDuration[i];
                }
                int choice2 = k_time + l_time;

                res = Math.min(res, choice2);
            }
        }

        return res; 
    }
}