package WeeklyContest249;

public class colorTheGrid {
    // not completed
    public static void main(String[] args){
        System.out.println(colortheGrid(1, 2));
    }

    public static int colortheGrid(int m, int n){
        int sum = 3;
        for(int i = 1; i < m + n - 1; i++){
            sum = sum * 2;
        }
        for(int i = n; i > 0; i--){
            sum = sum * n;
        }
        return sum;
    }
    
}
