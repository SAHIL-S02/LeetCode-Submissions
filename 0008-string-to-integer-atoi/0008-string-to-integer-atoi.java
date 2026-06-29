class Solution {
    public int myAtoi(String s) {
        long result = 0;
        boolean na = false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ' && i == 0){
                s = s.substring(1, s.length());
                i = -1;
                //System.out.print(1);
                continue;
            }
            if(s.charAt(i) == '-' && i == 0){
                na = true;
                //System.out.print(2);
                continue;
            }
            if(s.charAt(i) == '+' && i == 0){
                na=false;
                //System.out.print(3);
                continue;
            }
            if(s.charAt(i) == '0' ||s.charAt(i) == '1' ||s.charAt(i) == '2' ||s.charAt(i) == '3' ||s.charAt(i) == '4' ||s.charAt(i) == '5' ||s.charAt(i) == '6' ||s.charAt(i) == '7' ||s.charAt(i) == '8' ||s.charAt(i) == '9'){
                
                result = result*10 + Integer.parseInt(s.substring(i, i+1));
                if(na && -result < Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }else if(!na && result > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
            }else{
                break;
            }
            
        }
        System.out.print(s);
        if(na){
            return (int)-result;
        }else{
            return (int)result;
        }
        
    }
}