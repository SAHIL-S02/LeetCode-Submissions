class Solution {
    public String check(String s){
        int n = s.length() / 2;
        if(s.length() % 2 == 0){
            StringBuilder temp1 = new StringBuilder(s.substring(0, n));
            for(int i = 0; i < temp1.length(); i++){
                for(int j = i; j < temp1.length(); j++){
                    if(temp1.charAt(i) > temp1.charAt(j)){
                        char t = temp1.charAt(i);
                        temp1.setCharAt(i, temp1.charAt(j));
                        temp1.setCharAt(j, t); 
                    }
                }
            }
            return temp1.toString() + temp1.reverse().toString();
        }else{
            StringBuilder temp1 = new StringBuilder(s.substring(0, n));
            String midd = s.substring(n, n+1);
            for(int i = 0; i < temp1.length(); i++){
                for(int j = i; j < temp1.length(); j++){
                    if(temp1.charAt(i) > temp1.charAt(j)){
                        char t = temp1.charAt(i);
                        temp1.setCharAt(i, temp1.charAt(j));
                        temp1.setCharAt(j, t); 
                    }
                }
            }
            return temp1.toString() + midd + temp1.reverse().toString();
        }
        
        
    }
    public String smallestPalindrome(String s) {
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        char middle = 0;

        for (int i = 0; i < 26; i++) {

            // Put half of the occurrences in the left half
            for (int j = 0; j < cnt[i] / 2; j++) {
                left.append((char)('a' + i));
            }

            // If odd frequency, this is the middle character
            if ((cnt[i] & 1) == 1) {
                middle = (char)('a' + i);
            }
        }

        String right = new StringBuilder(left).reverse().toString();

        if (middle == 0)
            return left.toString() + right;

        return left.toString() + middle + right;
    }
}