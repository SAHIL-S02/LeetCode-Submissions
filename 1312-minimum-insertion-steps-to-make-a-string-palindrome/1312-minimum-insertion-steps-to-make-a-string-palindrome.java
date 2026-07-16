class Solution {
    public int check(int n, int m, String s, String t, int memo[][]){
		if (n < 0 || m < 0){
			return 0;
		}
		if(memo[n][m] != -1){
			return memo[n][m];
		}
		if(s.charAt(n) == t.charAt(m)){
			return memo[n][m] = 1+ check(n-1, m -1, s, t, memo);
		}
		int cs1 = check(n -1, m, s, t, memo);
		int cs2 = check(n, m-1, s, t, memo);
		int cs3 = check(n-1, m-1, s, t, memo);
		return memo[n][m] = Math.max(Math.max(cs1, cs2), cs3);
	}
	public int lcs(String s, String t) {
		int memo[][] = new int[s.length()][t.length()];
		for(int arr[]:memo){
			Arrays.fill(arr, -1);
		}
		return check(s.length()-1, t.length()-1, s, t, memo);
    }
    public int minInsertions(String s) {
        String reversed = new StringBuilder(s).reverse().toString(); 

        return s.length() - lcs(reversed, s);
    }
}