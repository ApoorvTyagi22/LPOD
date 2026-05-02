class Solution {
    private boolean isGood(int num){
    Map<Integer, Integer> rotate = Map.ofEntries(
            Map.entry(0, 0),
            Map.entry(1, 1),
            Map.entry(8, 8),
            Map.entry(2, 5),
            Map.entry(5, 2),
            Map.entry(6, 9),
            Map.entry(9, 6)
    );

        String n = String.valueOf(num);        
        StringBuilder newS = new StringBuilder();
        for(int i = 0; i < n.length(); i++){
            int currChar = n.charAt(i) - '0';
            if(!rotate.containsKey(currChar)) return false; 
            newS.append(rotate.get(currChar));
        }

        return !newS.toString().equals(n);
    }

    public int rotatedDigits(int n) {
        int cnt = 0;
        for(int i = 0; i <= n; i++){
            if(isGood(i)){
                cnt++;
            }
        }

        return cnt;
    }
}