class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int count = 0;
        for(int i = 0; i < g.length; ){
            if(j >= s.length){
                break;
            }
            if(s[j] >= g[i]){
                i++;
                j++;
                count++;
            }else{
                j++;
            }
        }
        return count;
    }
}