class Solution {
    public double angleClock(int hour, int minutes) {
        double total_hour = hour + (double)minutes/60;

        // 12 hour -> 360 
        // 6 hour -> 180 
        // 1 hour -> 30
        double hourAngle = total_hour * 30; 

        // 60 minute -> 360 
        // 30 -> 180 
        // 1 -> 6
        double minuteAngle = minutes * 6; 

        double ans = Math.abs(hourAngle - minuteAngle);

        if(ans > 180){
            return 360 - ans;
        } else {
            return ans; 
        }


        
    }
}