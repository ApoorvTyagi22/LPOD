class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length; 

        HashMap<Integer, Integer> numberToGroup = new HashMap<>(); 
        HashMap<Integer, LinkedList<Integer>> groupNumToVals = new HashMap<>();
        int groupNumber = 0; 
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);
        numberToGroup.put(copy[0], groupNumber);
        groupNumToVals.put(0, new LinkedList<>());
        groupNumToVals.get(0).add(copy[0]);

        for(int i = 1; i < n; i++){
            if(Math.abs(copy[i] - copy[i - 1]) > limit){
                groupNumber++; 
            }
            numberToGroup.put(copy[i], groupNumber);
            groupNumToVals.putIfAbsent(groupNumber, new LinkedList<>());
            groupNumToVals.get(groupNumber).add(copy[i]);
        }

        int[] res = new int[n];

        for(int i = 0; i < n; i++){
            int currVal = nums[i];
            int group = numberToGroup.get(currVal);

            int smallestValue = groupNumToVals.get(group).pollFirst(); 
            res[i] = smallestValue; 
        }

        return res; 
    }
}