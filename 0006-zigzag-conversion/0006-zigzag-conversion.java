class Solution {
    public String convert(String s, int numRows) {
        Queue<String> q = new LinkedList<>();
        if(numRows == 1){
            return s;
        }
        String result = "";
        for(int i = 0; i < s.length(); i++){
            q.add(s.substring(i, i+1));
        }
        String arr[] = new String[numRows];
        for(int i = 0; i < arr.length; i++){
            arr[i] = "";
        }
        int i = 0;
        boolean rev = false;
        while(!q.isEmpty()){
            arr[i] += q.remove();
            if(i >= numRows-1){
                rev = true;
            }
            if(i <= 0){
                rev = false;
            }
            if(rev){
                i--;
            }else{
                i++;
            }
        }
        System.out.print(arr[0]);
        for(int j = 0; j < arr.length; j++){
            result += arr[j];
        }
        return result;
    }
}