class Solution {
    public String minWindow(String s, String t) {
        int low = 0;
        int length = Integer.MAX_VALUE;
        String re = "";
        int req = 0;
        int formed = 0;
        HashMap<Character, Integer> og = new HashMap<>();
        for (char c : t.toCharArray()) {
            og.put(c, og.getOrDefault(c, 0) + 1);
        }
        req = og.size();
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int high = 0; high < s.length(); high++){
            char curr = s.charAt(high);
            if(!hm.containsKey(curr)){
                hm.put(curr, 1);
            }else{
                hm.put(curr, hm.get(curr)+1);
            }
            if (og.containsKey(curr)
                    && hm.get(curr).intValue() == og.get(curr).intValue()) {
                formed++;
            }
            while(req == formed){
                int currL = high - low +1;
                if(currL < length){
                    re = s.substring(low, high+1);
                    length = currL;
                }
                char remove = s.charAt(low);

                hm.put(remove, hm.get(remove) - 1);
                low++;
                if (og.containsKey(remove)
                        && hm.get(remove) < og.get(remove)) {
                    formed--;
                }
            }
        }
        return re;
    }
}