import java.util.ArrayList;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        ArrayList<String> substrings = new ArrayList();
        
        if (s.length() < 2){return s.length();}
        String temp = "";
        int mx= 0;
        for (int i = 0; i < s.length(); i++){
            String ch = Character.toString(s.charAt(i));
            if(!(temp.contains(ch))){
                temp += ch;
            }
            else{
                temp = temp.substring(temp.indexOf(ch)+1);
                temp += ch;
            }
            System.out.println(temp);
            substrings.add(temp);
        }
        for (int i = 0; i < substrings.size(); i++){
            if (substrings.get(i).length() > mx){
                mx = substrings.get(i).length();
            }
        }
        return mx;
    }
}