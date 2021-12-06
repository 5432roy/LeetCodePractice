package ChampagneTower;

public class ChampagneTower {

    public static void main(String[] args){
        System.out.println(champagneTower(25, 6, 1));
    }

    public static double champagneTower(int poured, int query_row, int query_glass) {
            double[][] memo = new double[query_row + 1][query_row + 1];
            memo[0][0] = poured;

            for(int row = 1; row <= query_row; row++){
                double pre = (memo[row - 1][0] - 1) / 2;
                memo[row][0] = memo[row][row] = pre >= 0 ? pre : 0;
            }

            for(int row = 2; row <= query_row; row++){
                for(int col = 1; col < row; col++){
                    double left, right;
                    left = (memo[row - 1][col - 1] - 1) / 2 > 0 ? (memo[row - 1][col - 1] - 1) / 2 : 0;
                    right = (memo[row - 1][col] - 1) / 2 > 0 ? (memo[row - 1][col] - 1) / 2 : 0;
                    memo[row][col] = left + right;
                }
            }

        //debug
        for(int row = 0; row <= query_row; row++){
            for(int i = 0; i < query_row - row; i++)
            System.out.print("  ");
            for(int col = 0; col <= row; col++){
                System.out.print(memo[row][col] + "  ");
            }
            System.out.println();
        }

        return memo[query_row][query_glass] > 1 ? 1 : memo[query_row][query_glass];
    }
    
}
