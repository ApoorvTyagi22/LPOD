class Solution {
    public boolean asteroidsDestroyed(long mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int n = asteroids.length; 

        for(int i = 0; i < n; i++){
            if(asteroids[i] > mass) return false; 
            mass += asteroids[i];
        }

        return true; 
    }
}