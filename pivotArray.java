class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int lessThanCntt = 0; 
        int equalToPivotCnt = 0; 
        int n = nums.length; 
        for(int i = 0; i < n; i++){
            if(nums[i] < pivot){
                lessThanCntt++;
            } else if (nums[i] == pivot){
                equalToPivotCnt++;
            }
        }

        int i = 0; 
        int j = lessThanCntt;
        int k = lessThanCntt + equalToPivotCnt;
        int[] res = new int[n];

        for(int step = 0; step < n; step++){
            if(nums[step] < pivot){
                res[i] = nums[step];
                i++;
            } else if (nums[step] == pivot){
                res[j] = nums[step];
                j++;
            } else {
                res[k] = nums[step];
                k++;
            }
        }

        return res; 
        
    }
}