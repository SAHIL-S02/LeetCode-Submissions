class Solution {
    public int minAddToMakeValid(String s) {
        int i = 0;
        int j = 0;
        for (char ch : s.toCharArray()){
            if(ch == '('){
                i++;
            }else{
                if(i > 0){
                    i--;
                }else{
                    j++;
                }
            }
        }
        return i + j;
    }
}