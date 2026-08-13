class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low = 0;
        int re = Integer.MIN_VALUE;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int high = 0; high < s.length(); high++){
            char curr = s.charAt(high);
            if(!hm.containsKey(curr)){
                hm.put(curr, 1);
            }else{
                hm.put(curr, hm.get(curr)+1);
            }
            while (hm.get(curr) > 1){
                char temp = s.charAt(low);
                if(hm.get(temp) == 1){
                    hm.remove(temp);
                }else{
                    hm.put(temp, hm.get(temp)-1);
                }
                low++;
            }
            re = Math.max(re, high - low + 1);
        }
        return re == Integer.MIN_VALUE? s.length() : re;
    }
}