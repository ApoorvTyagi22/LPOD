class Solution {
    public boolean isPossible(int val, int[][] tasks){
        int currHealth = val; 

        for(int i = 0; i < tasks.length; i++){
            // ith task 
            int actual =  tasks[i][0];
            int minimum = tasks[i][1];

            if(minimum > currHealth) return false; 

            // otherwise currHealth <= minimum
            currHealth -= actual;
        }


        return true; 
    }

    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        int l = 0; 
        int r = (int)1e9;
        int res = 0;
        while(l <= r){
            int mid = l + (r - l)/2;

            if(isPossible(mid, tasks)){
                res = mid; 
                r = mid - 1; 
            } else{
                l = mid + 1; 
            }
        }

        return res; 
    }
}
