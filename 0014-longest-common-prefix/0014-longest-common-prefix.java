class Solution {
    public String longestCommonPrefix(String[] strs) {
        char temp;
        String data = "";
        int small = strs[0].length();
        for(int i = 0; i < strs.length; i++){
            if(small > strs[i].length()){
                small = strs[i].length();
            }
        }
        for (int i = 0; i <small; i++){
            temp = strs[0].charAt(i);
            for (int j = 0; j <strs.length; j++){
                 if(temp ==  strs[j].charAt(i)){
                    
                 }
                 else{
                    return data;
                 }
            }
            data = data + temp;
        }
        return data;
    }
}