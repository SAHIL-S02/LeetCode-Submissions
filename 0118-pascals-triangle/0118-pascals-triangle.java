class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lis = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            lis.add(new ArrayList<>());
        }
        lis.get(0).add(1);
        for(int i = 1 ; i < numRows; i++){
            for(int j = 0; j < i+1; j++){
                if(j == 0 || j == i){
                    lis.get(i).addLast(1);
                }
                else{
                    lis.get(i).add((lis.get(i-1).get(j-1) + lis.get(i-1).get(j)));
                }
            }
        }
        return lis;
    }
}