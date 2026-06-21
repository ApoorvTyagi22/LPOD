class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        int i = 0;
        int n = costs.length; 
        while(coins > 0 && i < n){
            if(costs[i] <= coins){
                res++; 
                coins -= costs[i];
            } else {
                coins = -1; 
            }
            i++;
        }

        return res; 
    }
}