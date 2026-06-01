class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length; 
        int currCollect = 0;
        int currCost = 0; 
        for(int i = n - 1; i >= 0; i--){
            if(currCollect == 2){
                currCollect = 0;
                continue; 
            } else{
                currCollect++; 
                currCost += cost[i];
            }
        }

        return currCost; 
    }
}