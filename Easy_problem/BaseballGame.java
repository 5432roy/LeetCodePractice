package Easy;

public class BaseballGame {
    
    public int calPoints(String[] ops) {
        int[] list = new int[ops.length];
        int i = -1;

        for(String str : ops){
            if(str.equals("+")) list[i + 1] = list[i] + list[i - 1];
            else if(str.equals("D")) list[i + 1] = (list[i] << 1);
            else if(str.equals("C")){
                list[i] = 0;
                i -= 2;
            }
            else list[i + 1] = Integer.parseInt(str);
            i++;
        }
        
        int res = 0;
        for(int val : list){
            res += val;
        }
        
        return res;
    }
    
}
