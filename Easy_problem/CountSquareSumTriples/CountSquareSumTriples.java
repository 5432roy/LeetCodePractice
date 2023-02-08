package CountSquareSumTriples;

public class CountSquareSumTriples {
    public static void main(String[] args){
        System.out.println(countTriples(25));
    }

    public static int countTriples(int n){
        int sum = 0;
        for(int i = n; i > 4 ;i--){
            int left = 1, right = i - 1;
            while(right > left){
                int cur = left * left + right * right;
                if(cur > i * i) right--;
                else if(cur < i * i) left++;
                else {
                    sum++;
                    System.out.println(left+", "+right+", "+i);
                    right--;
                    left++;
                }
            }
        }
        return sum * 2;
    }
    
}
