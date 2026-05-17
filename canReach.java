class Solution {
    public boolean canReach(int[] arr, int start) {
        return solve(arr, start);
    }

    public boolean solve(int[] arr, int idx){
        if(idx >= arr.length || idx < 0 || arr[idx] < 0){
            return false; 
        }

        if(arr[idx] == 0){
            return true; 
        }
        int val = arr[idx];
        arr[idx] *= -1;

        boolean a = solve(arr, idx + val);
        boolean b = solve(arr, idx - val);

        return a || b; 
    }
}