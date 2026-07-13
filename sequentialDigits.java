class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        ArrayDeque<Integer> que = new ArrayDeque<>();
        for(int i = 1; i <= 8; i++){
            que.add(i);
        }

        List<Integer> res = new ArrayList<>();

        while(!que.isEmpty()){
            int curr = que.poll();
            if(curr >= low && curr <= high){
                res.add(curr);
            }
            int lastDig = curr % 10;
            if(lastDig + 1 <= 9){
                int newNum = (curr * 10) + (lastDig + 1);
                que.add(newNum);
            }
        }   

        return res; 
    }
}   