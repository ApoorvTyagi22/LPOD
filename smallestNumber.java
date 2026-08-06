class Solution {

    int getDigitSum(int num){
        int sum = 1; 
        while(num > 0){
            int digit = num % 10; 
            sum *= digit; 
            num /= 10; 
        }
        return sum;
    }
    public int smallestNumber(int n, int t) {
        boolean answer = false; 
        int res = -1; 
        while(!answer){
            int num = n; 
            int sum = getDigitSum(n); 
            if(sum % t == 0){
                answer = true; 
                res = num; 
            }
            n++; 
        }

        return res; 
    }
}