package ReshapeTheMatrix;

public class ReshapeTheMatrix {
    
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6}};
        print(matrixReshape(matrix, 3, 2));
    }
//
    public static int[][] matrixReshape(int[][] mat, int r, int c){
        // check if the given r and c are valid to reshape the matrix
        // check if the given r and c are the shape of the origin matrix
        if(r * c == mat[0].length * mat.length && !(r == mat.length && c == mat[0].length)){
            int[][] reshapeMatrix = new int[r][c];
            int row = 0, col = 0;
            // put the element from original matrix to the reshape matrix
            // start from first row
            for(int i = 0; i < mat.length; i++){
                // go through every elements in that row
                for(int j = 0; j < mat[0].length; j++){
                    reshapeMatrix[row][col] = mat[i][j];
                    col++;
                    // if the current row is fulled, go to next row, and start from first col
                    if(col == c){
                        col = 0;
                        row++;
                    }
                }
                // given that the amount of elements will perfectly fit with the matrix, we don't need to check if it is too many elements
            }
            return reshapeMatrix;
        }

        return mat;

    }

    public static void print(int[][] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                System.out.print(array[i][j]+", ");
            }
            System.out.println();
        }
    }
}
