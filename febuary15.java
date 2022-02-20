import java.util.Arrays;

/*"1. add two 2D matrices to get the result matrix (Add the elements at corresponding rows and columns positions)
2. Given an M × N integer matrix, print it in spiral order
   Input:

	[  1   2   3   4  5 ]
	[ 16  17  18  19  6 ]
	[ 15  24  25  20  7 ]
	[ 14  23  22  21  8 ]
	[ 13  12  11  10  9 ]

	Output:

		1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25

3.  Change all elements of row `i` and column `j` in a matrix to 0 if cell `(i, j)` is 0
	Input :
		[ 1  1  0  1  1 ]
		[ 1  1  1  1  1 ]
		[ 1  1  1  0  1 ]
		[ 1  1  1  1  1 ]
		[ 0  1  1  1  1 ]

	Output:

		[ 0  0  0  0  0 ]
		[ 0  1  0  0  1 ]
		[ 0  0  0  0  0 ]
		[ 0  1  0  0  1 ]
		[ 0  0  0  0  0 ]"
*/
public class febuary15 {
    public static void main(String[] args) {
        printFirstSecondDiagonal(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
        addTwoDMatrix(new int[][]{{1,3,4},
                {2,4,3},
                {3,4,5}},	new int[][]{{1,3,4},
                {2,4,3},
                {1,2,4}});
        printMatrixInSpiralOrder(new int[][]{
                /*0*/  { 1,  2,  3, 4,  5},
                /*1*/  {16, 17, 18, 19, 6},
                /*2*/  {15, 24, 25, 20, 7},
                /*3*/  {14, 23, 22, 21, 8},
                /*4*/  {13, 12, 11, 10, 9}
        });
		/*convertMatrix(new int[][]{
            { 1, 1, 0, 1, 1 },
            { 1, 1, 1, 1, 1 },
            { 1, 1, 0, 1, 1 },
            { 1, 1, 1, 1, 1 },
            { 0, 1, 1, 1, 1 }
        });*/
        convertMatrix(new int[][]{
                { 1,  1,  0,  1,  1 },
                { 1,  1,  1,  1,  1 },
                { 1,  1,  1,  0,  1 },
                { 1,  1,  1,  1,  1 },
                { 0,  1,  1,  1,  1 }
        });
    }

    private static void convertMatrix(int[][] mat) {
        if (mat.length == 0)
            return;
        int row = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    for (int k = 0; k < row; k++) {
                        if (mat[i][k] != 0)
                            mat[i][k] = -1;
                    }
                    for (int l = 0; l < col; l++) {
                        if (mat[l][j] != 0)
                            mat[l][j] = -1;
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == -1) {
                    mat[i][j] = 0;
                }
            }
        }
        print2DMatrix(mat);
    }

    private static void printMatrixInSpiralOrder(int[][] mat) {
        int top = 0, left = 0, bottom = mat.length - 1, right = mat[0].length - 1;
        if (mat == null || mat.length == 0 || left > right)
            return;
        while (top <= bottom && left <= right) {
            // for top row
            for (int i = left; i <= right; i++) {
                System.out.print(mat[top][i] + " ");
            }
            top++;
            if (top > bottom)
                return;
            // for right column
            for (int i = top; i <= bottom; i++) {
                System.out.print(mat[i][right] + " ");
            }
            right--;
            if (left > right)
                return;
            // print bottom
            for (int i = right; i >= left; i--) {
                System.out.print(mat[bottom][i] + " ");
            }
            bottom--;
            if (top > bottom)
                return;
            for (int i = bottom; i >= top; i--) {
                System.out.print(mat[i][left] + " ");
            }
            left++;
        }
    }

    private static void addTwoDMatrix(int[][] mat1, int[][] mat2) {
        int res[][]=new int[mat1[0].length][mat1[0].length];
        for(int i=0;i<mat1[0].length;i++) {
            for(int j=0;j<mat2.length;j++) {
                res[i][j]=mat1[i][j]+mat2[i][j];
            }
        }
        print2DMatrix(res);
    }

    private static void print2DMatrix(int[][] mat) {
        for (int[] val: mat) {
            System.out.println(Arrays.toString(val));
        }
    }
    private static void printFirstSecondDiagonal(int[][] mat1) {
        for(int i=0;i<mat1[0].length;i++) {
            for(int j=0;j<mat1.length;j++) {
                if(i+j==mat1.length-1)
                    System.out.print(mat1[i][j]+" ");
                if(i==j) {
                    System.out.print(mat1[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
}