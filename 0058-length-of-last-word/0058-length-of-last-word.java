class Solution {
    public int lengthOfLastWord(String s) {
        String[] d= s.split(" ");
        return d[d.length -1].length();
    }
}