class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        int i = temp.length - 1;
        st.push(i);
        list.addFirst(0);
        i--;
        while(i >= 0){
            if(st.isEmpty()){
                list.addFirst(0);
                st.push(i);
                i--;
                continue;
            }
            if(temp[st.peek()] > temp[i]){
                list.addFirst(st.peek() - i);
                st.push(i);
                i--;
            }else{
                st.pop();
            }
        }
        return list.stream()
           .mapToInt(Integer::intValue)
           .toArray();

    }
}