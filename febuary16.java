import java.util.Arrays;

public class febuary16{
    public static void main(String[] args) {
		/*System.out.println(isMatrixIdentical(new int[][] { { 1, 2, 3 }, { 8, 4, 6 }, { 4, 5, 7 } },
				new int[][] { { 1, 2, 3 }, { 8, 4, 6 }, { 4, 5, 7 } }));
		printSumOfRowsAndColumns(new int[][] {  					{1,2,1},
												{4,5,1},
												{7,8,1},
												{1,1,1},
												{4,5,1}});
		System.out.println(isIndentityMatrix(new int[][] {
			{1, 0, 0},
            		{0, 1, 0},
            		{0, 0, 1}  	}));

		System.out.println(isSymmetric(new int[][] {
			{6,5,2},
			{5,0,9},
			{2,9,3}		}));*/
        //HW
        frequencyOfOddAndEven(new int[][] {{1,3,5},
                {2,4,1},
                {7,8,9}});
        System.out.println("Sum is: "+sumOfAntiDiagonalMatrix(new int[][] {{1,5,7},
                {2,6,8},
                {5,8,2}}));
        printMatrixRow(new String[][] {{"Hello","Geekster"},
                {"Good","Day"}});

    }

    private static void printMatrixRow(String[][] mat) {
        int row=0;
        for(String[] val:mat) {
            System.out.println("Row "+(row++)+" : "+String.join("",val));
        }
    }

    private static int sumOfAntiDiagonalMatrix(int[][] mat) {
        int row=mat.length-1,col=mat[0].length-1;
        int sum=0;
        for(int i=0;i<=row;i++) {
            for(int j=col;j>=0;j--) {
                if(i+j==row)
                    sum+=mat[i][j];
            }
        }
        return sum;
    }

    private static void frequencyOfOddAndEven(int[][] mat) {
        int odd=0,even=0;
        for(int[] arr:mat) {
            for(int val:arr) {
                if(val%2==0) even++;
                else odd++;
            }
        }
        System.out.println("Even = "+even+"\nOdd ="+odd);
    }



    public static boolean isSymmetric(int mat[][]) {
        int row = mat.length, col = mat[0].length;
        if (row != col) {
            return false;
        } else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (mat[i][j] != mat[j][i]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private static boolean isIndentityMatrix(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        if (col != row) {
            return false;
        } else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if ((mat[i][j] != 1 && i == j) || (mat[i][j] != 0 && i != j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void printSumOfRowsAndColumns(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        System.out.print("Row Sum :");
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < col; j++) {
                sum += mat[i][j];
            }
            System.out.print(sum + " ");
        }
        System.out.println();
        System.out.print("Column Sum :");
        for (int i = 0; i < col; i++) {
            int sum = 0;
            for (int j = 0; j < row; j++) {
                sum += mat[j][i];
            }
            System.out.print(sum + " ");
        }
    }

    private static boolean isMatrixIdentical(int[][] mat1, int[][] mat2) {
        int row1 = mat1.length, col1 = mat1[0].length, row2 = mat2.length, col2 = mat2[0].length;
        if (row1 != row2 || col1 != col2) {
            return false;
        } else {
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col1; j++) {
                    if (mat1[i][j] != mat2[i][j])
                        return false;
                }
            }
            return true;
        }
    }
}