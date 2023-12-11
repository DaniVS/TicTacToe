import org.junit.jupiter.api.Test;

public class ArrayOperationsTest {

    @Test
    void reverseOneDimArray(){
        int[][] arrayWithOnlyOneRow = new int[1][4];
        arrayWithOnlyOneRow[0][0] = 9;
        arrayWithOnlyOneRow[0][1] = 9;
        arrayWithOnlyOneRow[0][2] = 0;
        arrayWithOnlyOneRow[0][3] = 0;
        ArrayOperations.reverseElements(arrayWithOnlyOneRow);

        System.out.println("end of test");
    }

    @Test
    void reverseTwoDimArray(){
        int[][] arrayWithTwoRows = new int[2][4];
        arrayWithTwoRows[0][0] = 9;
        arrayWithTwoRows[0][1] = 9;
        arrayWithTwoRows[0][2] = 0;
        arrayWithTwoRows[0][3] = 0;
        arrayWithTwoRows[1][0] = 1;
        arrayWithTwoRows[1][1] = 2;
        arrayWithTwoRows[1][2] = 3;
        arrayWithTwoRows[1][3] = 4;

        ArrayOperations.reverseElements(arrayWithTwoRows);

        System.out.println("end of test");
    }
}
