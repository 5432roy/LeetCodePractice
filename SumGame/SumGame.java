package SumGame;

public class SumGame {

    public static void main(String[] args){

        String num = "45??";
        System.out.println(sumGame(num));

    }
    
    public static boolean sumGame(String num){
        int sum = 0, moves = 0, length = num.length() / 2;

        for(int i = 0; i < length; i++){
            if(num.charAt(i) == '?') moves++;
            else sum += Character.getNumericValue(num.charAt(i));

            if(num.charAt(i + length) == '?') moves--;
            else sum -= Character.getNumericValue(num.charAt(i + length));
        }
        System.out.println(moves + ", " + -moves / 2 * 9);

        if(moves % 2 == 0 && sum == -moves / 2 * 9) return false;

        return true;
    }
}
