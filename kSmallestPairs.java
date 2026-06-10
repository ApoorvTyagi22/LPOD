class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> {
                return Integer.compare(a[0], b[0]);
            });
        List<List<Integer>> res = new ArrayList<>();
        Set<Long> visited = new HashSet<>();

        minHeap.offer(new int[]{nums1[0] + nums2[0], 0, 0});
        visited.add(0L);

        int i = 0; 
        int j = 0; 
        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            i = curr[1];
            j = curr[2];
            res.add(new ArrayList<>(List.of(nums1[i], nums2[j])));
            // now add the following pairs (i, j + 1), and (i + 1, j)
            if(res.size() >= k) break; 
            if(j + 1 < nums2.length){
                long key = (long) i * nums2.length + (j + 1);
                if (visited.add(key))
                    minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
            if(i + 1 < nums1.length){
                long key = (long) (i + 1) * nums2.length + j;
                if (visited.add(key))
                    minHeap.offer(new int[] {nums1[i + 1] + nums2[j], i + 1, j});
            }
        }
        return res; 

    }
}