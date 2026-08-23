class Solution {
    int getRank(int[] sorted, int m, int value){
        // return the index of the value in range [0, m)
        int low = 0; 
        int high = m;

        while(low < high){
            int mid = low + (high - low)/2;
            if(sorted[mid] < value){
                // search right
                low = mid + 1; 
            } else {
                high = mid; 
            }
        }

        return low; 
    }
    // point update
    void updateSegTree(int[] segmentTree, int l, int r, int idx, int rank){
        if(l == r){
            // increase the frequency here 
            segmentTree[idx]++; 
            return; 
        }

        int mid = l + (r - l)/2; 
        if(rank <= mid){
            // then go update left tree
            updateSegTree(segmentTree, l, mid, 2*idx + 1, rank);
            
        } else {
            // otherwise update right tree
            updateSegTree(segmentTree, mid + 1, r, 2 * idx + 2, rank);
        }

        segmentTree[idx] = segmentTree[2*idx + 1] + segmentTree[2*idx + 2];
    }
    // return freq of all rank in lowerRank and upperRank
    int query(int[] segmentTree, int l, int r, int idx, int lowerRank, int upperRank){
        // completely out of l and r 
        if(r < lowerRank || l > upperRank){
            return 0; 
        }
        // completely inside 
        if(l >= lowerRank && r <= upperRank){
            return segmentTree[idx];
        }

        int mid = l + (r - l)/2; 

        // query left 
        int leftSum = query(segmentTree, l, mid, 2*idx + 1, lowerRank, upperRank);
        int rightSum = query(segmentTree, mid + 1, r, 2*idx + 2, lowerRank, upperRank);
        return leftSum + rightSum;
    }


    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int m = 0; 
        for(int i = 0; i < sorted.length; i++){
            if(i == 0 || sorted[i] != sorted[i - 1]){
                sorted[m] = sorted[i];
                m++; 
            }
        }

        // now sorted[0 ... m - 1] holds the distinct values. m is the size of the segment tree
        int[] segTreeArr1 = new int[4 * m]; // frequency Segment tree storing the freq of values in arr1
        int[] segTreeArr2 = new int[4 * m]; // frequency Segment tree storing the freq of values in arr2

        // no build as initial the freq of all elemnets is 0 
        // call update on bath with nums[0] and nums[1] respectively.
        int rank1 = getRank(sorted, m, nums[0]);
        int rank2 = getRank(sorted, m, nums[1]);
        updateSegTree(segTreeArr1, 0, m - 1, 0, rank1); // tree, int l, int r, int i, int val, 
        updateSegTree(segTreeArr2, 0, m - 1, 0, rank2); 
        int a1Cnt = 1;
        int a2Cnt = 1;  
        ArrayList<Integer> arr1 = new ArrayList<>(); 
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for(int i = 2; i < n; i++){ 
            int rank3 = getRank(sorted, m, nums[i]);
            int cnt1 = query(segTreeArr1, 0, m - 1, 0, rank3 + 1, m - 1); // tree, sorted, int l, int r, int val
            int cnt2 = query(segTreeArr2, 0, m - 1, 0, rank3 + 1, m - 1);            
            if(cnt1 > cnt2){
                updateSegTree(segTreeArr1, 0, m - 1, 0, rank3);
                arr1.add(nums[i]);
                a1Cnt++; 
            } else if(cnt1 < cnt2){
                updateSegTree(segTreeArr2, 0, m - 1, 0, rank3);
                arr2.add(nums[i]);
                a2Cnt++; 
            } else if(a1Cnt < a2Cnt){
                updateSegTree(segTreeArr1, 0, m - 1, 0, rank3);
                arr1.add(nums[i]);
                a1Cnt++; 
            } else if(a2Cnt < a1Cnt){
                updateSegTree(segTreeArr2, 0, m - 1, 0, rank3);
                arr2.add(nums[i]);
                a2Cnt++; 
            } else {
                updateSegTree(segTreeArr1, 0, m - 1, 0, rank3);
                arr1.add(nums[i]);
                a1Cnt++; 
            }
        }


        int[] res = new int[n];
        for(int i = 0; i < arr1.size(); i++){
            res[i] = arr1.get(i);
        } 
        int shift = arr1.size();
        for(int i = shift; i < shift + arr2.size(); i++){
            res[i] = arr2.get(i - shift);
        }

        return res; 
    }
}