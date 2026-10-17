class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> list = new Stack<>();
        int i = temp.length - 1;
        st.push(i);
        list.push(0);
        i--;
        while(i >= 0){
            if(st.isEmpty()){
                list.push(0);
                st.push(i);
                i--;
                continue;
            }
            if(temp[st.peek()] > temp[i]){
                list.push(st.peek() - i);
                st.push(i);
                i--;
            }else{
                while(!st.isEmpty() && temp[st.peek()] <= temp[i]){
                    st.pop();
                }
            }
        }
        int[] res = new int[list.size()];
        for(int j = 0; j < res.length; j++){
            res[j] = list.pop();
        }
        return res;
    }
}