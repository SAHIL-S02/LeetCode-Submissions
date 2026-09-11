class Solution {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];

        // Count frequency of each digit
        for (int digit : digits) {
            count[digit]++;
        }

        int answer = 0;

        // Check every 3-digit even number
        for (int num = 100; num <= 998; num += 2) {
            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            // Temporarily use the digits
            count[a]--;
            count[b]--;
            count[c]--;

            // All required digits are available
            if (count[a] >= 0 && count[b] >= 0 && count[c] >= 0) {
                answer++;
            }

            // Restore the digits
            count[a]++;
            count[b]++;
            count[c]++;
        }

        return answer;
    }
}