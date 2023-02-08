package SumofSquareNumbers;

public class SumofSquareNumbers {

    public boolean judgeSquareSum(int num){
        if(num < 0) return false;
        int head = 0, tail = (int)Math.sqrt(num);
        while(tail >= head){
            int cur = head * head + tail * tail;
            if(cur == num) return true;
            if(cur > num) tail--;
            else head++;
        }
        return false;
    }
    
}
