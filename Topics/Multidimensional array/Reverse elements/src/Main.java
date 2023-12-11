class ArrayOperations {
    public static void reverseElements(int[][] twoDimArray) {
        for (int r = 0; r < twoDimArray.length; r++){
            int[] actualRow = twoDimArray[r];

            int[] reversedRow = new int[actualRow.length];
            int revIdx = actualRow.length - 1;
            for (int elem = 0; elem < actualRow.length; elem++){
                reversedRow[revIdx] = actualRow[elem];
                revIdx--;
            }

            twoDimArray[r] = reversedRow;
        }
    }
}
