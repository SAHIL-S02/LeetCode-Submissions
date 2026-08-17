class Solution {
    public String minWindow(String s, String t) {
        int low = 0;
        int length = Integer.MAX_VALUE;
        String re = "";
        HashMap<Character, Integer> og = new HashMap<>();
        for (char c : t.toCharArray()) {
            og.put(c, og.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int high = 0; high < s.length(); high++){
            char curr = s.charAt(high);
            if(!hm.containsKey(curr)){
                hm.put(curr, 1);
            }else{
                hm.put(curr, hm.get(curr)+1);
            }
            boolean flg = true;
            for(char key : og.keySet()){
                if(og.get(key) > hm.getOrDefault(key, 0)){
                    flg = false;
                    break;
                }
            }
            while(flg && low <= high){
                int currL = high - low +1;
                if(currL < length){
                    re = s.substring(low, high+1);
                    length = currL;
                }
                char remove = s.charAt(low);

                hm.put(remove, hm.get(remove) - 1);
                low++;
                for(char key : og.keySet()){
                    if(og.get(key) > hm.getOrDefault(key, 0)){
                        flg = false;
                        break;
                    }
                }
            }
        }
        return re;
    }
}