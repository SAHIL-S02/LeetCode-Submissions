class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        List<Integer> zeroGroups = new ArrayList<>();
        int ones = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            } else {
                if (i > 0 && s.charAt(i - 1) == '0') {
                    int last = zeroGroups.size() - 1;
                    zeroGroups.set(last, zeroGroups.get(last) + 1);
                } else {
                    zeroGroups.add(1);
                }
            }
        }

        int maxMerge = 0;
        for (int i = 0; i + 1 < zeroGroups.size(); i++) {
            maxMerge = Math.max(maxMerge, zeroGroups.get(i) + zeroGroups.get(i + 1));
        }

        return ones + maxMerge;
    }
}