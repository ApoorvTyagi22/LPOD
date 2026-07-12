class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length; 
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 1; 
        for(int i = 0; i < n; i++){
            if(!map.containsKey(copy[i])){
                map.put(copy[i], cnt);
                cnt++;
            }
        }
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = map.get(arr[i]);
        }

        return res; 

    }
}