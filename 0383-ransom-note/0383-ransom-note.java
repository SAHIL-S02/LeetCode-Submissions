class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        int i = 0; 
        while(i < ransomNote.length() || i < magazine.length()){
            if(i < ransomNote.length()){
                char ch = ransomNote.charAt(i);
                hm1.put(ch, hm1.getOrDefault(ch, 0) + 1);
            }
            if(i < magazine.length()){
                char ch = magazine.charAt(i);
                hm2.put(ch, hm2.getOrDefault(ch, 0) + 1);
            }
            i++;
        }
        for(char ch : hm1.keySet()){
            if(hm1.get(ch) > hm2.getOrDefault(ch, 0)){
                return false;
            }
        }
        return true;
    }
}