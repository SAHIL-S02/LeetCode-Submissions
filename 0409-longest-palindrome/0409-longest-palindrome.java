class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch : s.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }
        int res = 0;
        int ff = 0;
        for(char ch : hm.keySet()){
            if(hm.get(ch)%2 == 0){
                res += hm.get(ch);
            }else{
                res += (hm.get(ch) - 1);
                ff = 1;
            }
        }
        if(hm.containsValue(1)){
            return res +1;
        }else{
            return res+ff;
        }
    }
}