class Solution {
    public int maxNumberOfBalloons(String text) {
       HashMap<Character, Integer> al = new HashMap<>();
       al.put('b', 1);
       al.put('a', 1);
       al.put('l', 2);
       al.put('o', 2);
       al.put('n', 1);
       int min = Integer.MAX_VALUE;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch : text.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }
        for(char ch : al.keySet()){
            min = Math.min(min, hm.getOrDefault(ch, 0)/al.get(ch));
        }
        return min;
    }
}