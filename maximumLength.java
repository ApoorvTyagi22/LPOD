class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<>();// val -> multiplicity 
        int n = nums.length; 
        for(int i = 0; i < n; i++) 
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);

        int best = 1; 

        if(cnt.get(1) != null){
            int c = cnt.get(1);
            best = Math.max(best, (c % 2 == 1) ? c : c - 1);
        }

        for(Map.Entry<Integer, Integer> entry : cnt.entrySet()){
            int key = entry.getKey(); 
            if(key == 1) continue; 
            long x = key; 
            int pairs = 0;
            while(cnt.get((int) x) != null && cnt.get((int) x) >= 2 && x <= 1000000000L / x) {
                pairs++; 
                x = x * x; 
            }

            int len = (cnt.get((int) x) != null ? (2 * pairs + 1) : (2 * pairs - 1));
            best = Math.max(best, len);

        }


        return best; 

    }
}