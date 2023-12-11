import java.awt.dnd.DropTarget;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];

        int rotatedRows = cols;
        int rotatedCols = rows;
        int[][] rotated = new int[rotatedRows][rotatedCols];

        int rrIdx;
        int rcIdx = rotatedCols -1; // the rotated column index proceeds backwards

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                matrix[r][c] = scanner.nextInt();

                rrIdx = c; // the matrix column is also the rotated row
                rotated[rrIdx][rcIdx] = matrix[r][c];
            }
            --rcIdx;
        }

        for (int pr = 0; pr < rotatedRows; pr++){
            for (int pc = 0; pc < rotatedCols; pc++){
                System.out.print(rotated[pr][pc] + " ");
            }
            System.out.println();
        }
    }
}
