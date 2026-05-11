class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length; 
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int currNum = nums[i];
            String numString = Integer.toString(currNum);
            for(int j = 0; j < numString.length(); j++){
                int curr = (int) (numString.charAt(j) - '0');
                arr.add(curr);
            }
        }   
        int[] res = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
                res[i] = arr.get(i);
        }

        return res; 
    }
}