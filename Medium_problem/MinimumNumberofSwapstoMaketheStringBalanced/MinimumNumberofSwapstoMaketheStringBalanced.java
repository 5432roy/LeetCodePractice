package MinimumNumberofSwapstoMaketheStringBalanced;

public class MinimumNumberofSwapstoMaketheStringBalanced {

    public int minSwaps(String str){
        int opening = 0, tail = str.length() - 1;
        int res = 0;
        for(int head = 0; head < tail; head++){
            while(str.charAt(tail) != '[') tail--;
            opening += str.charAt(head) == '[' ? 1 : -1;
            if(opening < 0){
                res++;
                opening += 2;
                tail--;
            }
        }
        return res;
    }
    
}
