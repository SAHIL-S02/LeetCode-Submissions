class Solution {
    public int[] dailyTemperatures(int[] temp) {
        if (temp.length == 0) {
            return new int[0];
        }
        Stack<Integer> st = new Stack<>();
        int[] res = new int[temp.length];
        int i = temp.length - 1;
        st.push(i);
        res[i] = 0;
        i--;
        while(i >= 0){
            if(st.isEmpty()){
                res[i] = 0;
                st.push(i);
                i--;
                continue;
            }
            if(temp[st.peek()] > temp[i]){
                res[i] = st.peek() - i;
                st.push(i);
                i--;
            }else{
                st.pop();
            }
        }
        return res;
    }
}