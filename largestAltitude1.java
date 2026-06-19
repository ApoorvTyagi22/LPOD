class Solution {
    public int largestAltitude(int[] gain) {
        int maxAlt = 0; 
        int curr = 0;
        for(int val : gain){
            curr += val;
            maxAlt = Math.max(curr, maxAlt);
        }

        return maxAlt;
    }
}