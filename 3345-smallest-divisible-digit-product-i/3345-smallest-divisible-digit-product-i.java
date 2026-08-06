class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int pro = 1;
            int temp = n;
            while(temp > 0){
                pro *= temp %10;
                temp /= 10; 
            }
            if(pro % t == 0){
                return n;
            }
            n++;
        }
    }
}