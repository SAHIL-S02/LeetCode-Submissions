class Solution {
    public int reverse(int x) {
        int rs = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            if (rs > Integer.MAX_VALUE / 10 ||
                (rs == Integer.MAX_VALUE / 10 && digit > 7))
                return 0;

            if (rs < Integer.MIN_VALUE / 10 ||
                (rs == Integer.MIN_VALUE / 10 && digit < -8))
                return 0;

            rs = rs * 10 + digit;
        }
        return rs;
    }
}