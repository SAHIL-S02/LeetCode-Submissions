class Solution {
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 1;
        int sumEven = 2;
        int i = 1;
        int j = 2;
        while(n != 1){
            sumOdd += i +2;
            i = i+2;
            sumEven += j + 2;
            j = j + 2;
            n--;
        }
        System.out.println(sumOdd);
        return gcd(sumOdd, sumEven);
    }
}