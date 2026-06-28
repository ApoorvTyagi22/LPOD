class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length; 
        int maxElm = -1; 

        Arrays.sort(arr);
        for(int i = 0; i < n; i++){
            if(i == 0)
                arr[i] = 1; 
            else if (Math.abs(arr[i - 1] - arr[i]) > 1)
                arr[i] = arr[i - 1] + 1; 
                maxElm = Math.max(maxElm, arr[i]);
        }

        return maxElm; 
    }
}