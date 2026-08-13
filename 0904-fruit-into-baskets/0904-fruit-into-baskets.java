class Solution {
    public int totalFruit(int[] fruits) {
        int k = 2;
        int re = Integer.MIN_VALUE;
        int low = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int high = 0; high < fruits.length; high++){
            int curr = fruits[high];
            if(hm.containsKey(curr)){
                hm.put(curr, hm.get(curr) +1);
            }else{
                hm.put(curr, 1);
            }
            while(hm.size() > k){
                int temp = fruits[low];
                if(hm.get(temp) == 1){
                    hm.remove(temp);
                }else{
                    hm.put(temp, hm.get(temp)-1);
                }
                low++;
            }
            if(hm.size() < k || hm.size() == k){
                re = Math.max(re, high - low +1);
            }
        }
        return re;
    }
}