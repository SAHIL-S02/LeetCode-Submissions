class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int low = 0;
        int re = Integer.MIN_VALUE;
        int ma = 0;
        for(int high = 0; high < s.length(); high++){
            char curr = s.charAt(high);
            map[curr-'A']++;
            int len = high - low +1;
            ma = Math.max(ma, map[curr-'A']);
            int diff = len -ma;
            while(diff > k){
                char temp = s.charAt(low);
                map[temp -'A']--;
                low++;
                len = high - low +1;
                diff = len - ma;
            }
            re = Math.max(re, len);
        }
        return re;
    }
}