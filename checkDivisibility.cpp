class Solution {
    public boolean checkDivisibility(int n) {
        int digitProduct = 1; 
        int digitSum = 0; 

        int temp = n; 
        while(temp > 0){
            int currDig = temp % 10; 
            digitSum += currDig;
            digitProduct *= currDig;
            temp /= 10;
        }

        return (n % (digitSum + digitProduct) == 0); 
    }
}