class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length; 
        int half = n/2; 

        int minValueIdx = 0; 
        int maxValueIdx = 0; 

        for(int i = 0; i < n; i++){
            if(nums[minValueIdx] > nums[i]){
                minValueIdx = i; 
            }
            if(nums[maxValueIdx] < nums[i]){
                maxValueIdx = i; 
            }
        }

        int first = Math.min(minValueIdx, maxValueIdx);
        int second = Math.max(minValueIdx, maxValueIdx);

        int c1 = second + 1; 
        int c2 = n - first;
        int c3 = (first + 1) + (n - second);
        return Math.min(c1, Math.min(c2, c3));
    }
}