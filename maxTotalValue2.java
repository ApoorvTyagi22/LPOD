class SegmentTree {
    int[] segTree; 
    int[] nums;
    boolean isMin;

    public SegmentTree(int[] nums, boolean isMin){
        this.nums = nums; 
        int n = nums.length; 
        this.isMin = isMin; 
        this.segTree = new int[4*n];
        buildSegmentTree(0, n - 1, 0);
    }

    private void buildSegmentTree(int l, int r, int i){    
        if(l == r){
            segTree[i] = nums[l];
            return; 
        }
        int mid = l + (r - l)/2; 
        buildSegmentTree(l, mid, 2*i + 1);
        buildSegmentTree(mid + 1, r, 2*i + 2);
        
        if(isMin){
            segTree[i] = Math.min(segTree[2*i+1],segTree[2*i+2]);
        } else {
            segTree[i] = Math.max(segTree[2*i+1],segTree[2*i+2]);
        }
    }

    private int querySegmentTree(int l, int r, int start, int end, int i){
        if(l > end || r < start){
            return isMin ? Integer.MAX_VALUE : Integer.MIN_VALUE; 
        } 

        if(l >= start && r <= end){
            return segTree[i];
        }

        int mid = l + (r - l)/2;
        int c1 = querySegmentTree(l, mid, start, end, 2*i+1);
        int c2 = querySegmentTree(mid+1, r, start, end, 2*i+2);

        if(isMin){
            return Math.min(c1, c2);
        } else {
           return Math.max(c1, c2);
        }
    }

    public int query(int l, int r, int n){
        return querySegmentTree(0, n - 1, l, r, 0);
    }
}
class Solution {
    private long getValue(SegmentTree minTree, SegmentTree maxTree, int l, int r, int n){
        int minVal = minTree.query(l, r, n); 
        int maxVal = maxTree.query(l, r, n);

        return (long) maxVal - minVal; 
    }
    
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length; 
        SegmentTree minTree = new SegmentTree(nums, true);
        SegmentTree maxTree = new SegmentTree(nums, false);

        PriorityQueue<long[]> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));

        
        for(int l = 0; l < n; l++){
            // r = n - 1;
            long subArrayVal = getValue(minTree, maxTree, l, n - 1, n); 
            maxHeap.offer(new long[]{subArrayVal, l, n - 1});
        }

        long res = 0; 

        while(k-- > 0){
            long[] curr = maxHeap.poll();
            res += curr[0];
            int l = (int)curr[1];
            int r = (int)curr[2];
            // we add same l, r-1 
            long val = getValue(minTree, maxTree, l, r - 1, n);
            maxHeap.offer(new long[]{val, l, r - 1});
        }

        return res; 
    }
}