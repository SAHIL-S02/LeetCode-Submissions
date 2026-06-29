class Solution {
    public boolean isPalindrome(int x) {
        String temp = Integer.toString(x);
        boolean o = true;
        for (int i =0; i <temp.length(); i++){
            if(!(temp.charAt(i) == temp.charAt(temp.length()-1-i))){
                o = false;
                break;
            }
        }
        return o;
    }
}