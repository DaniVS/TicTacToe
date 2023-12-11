package tictactoe;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final char EMPTY_CELL = ' ';
    private static final String GAME_CONTINUES = "Game not finished";

    public static void main(String[] args) {
        String gameGrid = """
                ---------
                | %s %s %s |
                | %s %s %s |
                | %s %s %s |
                ---------
                """;

        char[] emptyCells = "         ".toCharArray();
        char[][] gameBoard = initGameBoard(emptyCells);
        printGameState(gameGrid, gameBoard);

        Scanner scanner = new Scanner(System.in);
        String errorMsg;
        String userMove;
        String gameStatus;

        char toMove = 'X';
        while (scanner.hasNextLine()){
            userMove = scanner.nextLine();
            errorMsg = validateAndMove(gameBoard, userMove, toMove);

            if (!errorMsg.isEmpty()){
                System.out.println(errorMsg);
                continue;
            }

            gameStatus = checkGame(gameBoard);

            if (gameStatus.equals("Draw") || gameStatus.equals("X wins") || gameStatus.equals("O wins")){
                printGameState(gameGrid, gameBoard);
                System.out.println(gameStatus);
                break;
            }

            printGameState(gameGrid, gameBoard);

            toMove = toggleMove(toMove);
        }
    }

    public static char[][] initGameBoard(char[] userInput) {
        char[][] game = new char[3][3];

        int idx = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                game[row][col] = userInput[idx + row + col];
            }
            idx += 2;
        }

        return game;
    }

    private static void printGameState(String gameGrid, char[][] gameBoard) {
        String printUpdatedGrid = String.format(
                gameGrid,
                gameBoard[0][0], gameBoard[0][1], gameBoard[0][2],
                gameBoard[1][0], gameBoard[1][1], gameBoard[1][2],
                gameBoard[2][0], gameBoard[2][1], gameBoard[2][2]);

        System.out.println(printUpdatedGrid);
    }

    public static String checkGame(char[][] gameBoard) {
        if (isImpossible(gameBoard)){
            return "Impossible";
        }

        if (!isFinished(gameBoard)){
            return GAME_CONTINUES;
        }

        if (isTheWinner('X', gameBoard)){
            return "X wins";
        }

        if (isTheWinner('O', gameBoard)){
            return "O wins";
        }

        if (isDraw(gameBoard)){
            return "Draw";
        }

        return GAME_CONTINUES;
    }

    private static boolean isImpossible(char[][] gameBoard) {
        if (tooMuchOfTheSameSymbol(gameBoard)){
            return true;
        }

        if (tooMuchWinners(gameBoard)){
            return true;
        }

        return false;
    }

    private static boolean tooMuchOfTheSameSymbol(char[][] gameBoard) {
        int xCount = 0;
        int oCount = 0;

        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++){
                if (gameBoard[row][col] == 'X'){
                    xCount++;
                }
                if (gameBoard[row][col] == 'O'){
                    oCount++;
                }
            }
        }

        if (Math.abs(xCount - oCount) > 1){
            return true;
        }

        return false;
    }

    private static boolean isEmpty(char[][] gameBoard) {
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++){
                if (gameBoard[row][col] != EMPTY_CELL){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isFinished(char[][] gameBoard) {
        if (isEmpty(gameBoard)){
            return false;
        }

        if (getSpaceLeft(gameBoard) >= 3 && !thereIsAWinner(gameBoard)){
            return false;
        }

        return true;
    }

    private static boolean thereIsAWinner(char[][] gameBoard) {
        return isTheWinner('X', gameBoard) || isTheWinner('O', gameBoard);
    }

    private static int getSpaceLeft(char[][] gameBoard) {
        int spacesLeft = 0;
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++){
                if (gameBoard[row][col] == EMPTY_CELL){
                    spacesLeft++;
                }
            }
        }
        return spacesLeft;
    }

    private static boolean isTheWinner(char symbol, char[][] gameBoard) {
        // winning combinations:
        // first row, second row third row
        // first col, second col, third col
        // first diagonal, second diagonal
        char[] firstRow = gameBoard[0];
        char[] secondRow = gameBoard[1];
        char[] thirdRow = gameBoard[2];

        char[] firstColumn = getColumn(0, gameBoard);
        char[] secondColumn = getColumn(1, gameBoard);
        char[] thirdColumn = getColumn(2, gameBoard);

        char[] firstDiagonal = getDiagonal("1st", gameBoard);
        char[] secondDiagonal = getDiagonal("2nd", gameBoard);

        List<char[]> combinations = Arrays.asList(
                firstRow, secondRow, thirdRow,
                firstColumn, secondColumn, thirdColumn,
                firstDiagonal, secondDiagonal);

        for (char[] combination : combinations){
            if (isAWin(symbol, combination)){
                return true;
            }
        }
        return false;
    }

    private static char[] getColumn(int columnIndex, char[][] gameBoard) {
        char[] theColumn = new char[3];

        for (int r=0; r<3; r++){
            theColumn[r] = gameBoard[r][columnIndex];
        }

        return theColumn;
    }

    private static char[] getDiagonal(String i, char[][] gameBoard) {
        char[] theDiagonal = new char[3];

        if (i.equals("1st")){
            theDiagonal[0] = gameBoard[0][0];
            theDiagonal[1] = gameBoard[1][1];
            theDiagonal[2] = gameBoard[2][2];
        }

        if (i.equals("2nd")){
            theDiagonal[0] = gameBoard[0][2];
            theDiagonal[1] = gameBoard[1][1];
            theDiagonal[2] = gameBoard[2][0];
        }

        return theDiagonal;
    }

    private static boolean isAWin(char symbol, char[] combination) {
        int symbolCount = 0;

        for (int i=0; i<combination.length; i++){
            if (combination[i] == symbol){
                symbolCount++;
            }
        }

        if (symbolCount == 3){
            return true;
        }

        return false;
    }

    public static boolean isDraw(char[][] gameBoard) {
        if (isFinished(gameBoard) &&
                !thereIsAWinner(gameBoard) &&
                getSpaceLeft(gameBoard)==0){
            return true;
        }

        return false;
    }

    private static boolean tooMuchWinners(char[][] gameBoard) {
        if (isTheWinner('X', gameBoard) && isTheWinner('O', gameBoard)){
            return true;
        }

        return false;
    }

    private static boolean isInRange(int userMove) {
        return userMove >= 1 && userMove <=3;
    }

    private static boolean makeTheMove(char[][] gameBoard, int[] userMoves, char symbol) {
        if (gameBoard[userMoves[0]][userMoves[1]] == EMPTY_CELL) {
            gameBoard[userMoves[0]][userMoves[1]] = symbol;
            return true;
        }

        return false;
    }

    private static String validateAndMove(char[][] gameBoard, String userMove, char symbol) {
        int[] userMoves = new int[2];

        String[] splitMoves = userMove.split(" ");

        try {
            userMoves[0] = Integer.valueOf(splitMoves[0]);
            userMoves[1] = Integer.valueOf(splitMoves[1]);
        } catch (NumberFormatException nfe){
            return "You should enter numbers!";
        }

        if (isInRange(userMoves[0]) && isInRange(userMoves[1])){
            userMoves[0]--;
            userMoves[1]--;
        } else {
            return "Coordinates should be from 1 to 3!";
        }

        if (!makeTheMove(gameBoard, userMoves, symbol)){
            return "This cell is occupied! Choose another one!";
        }

        return "";
    }

    private static char toggleMove(char alreadyMoved) {
        if (alreadyMoved == 'X')
            return 'O';

        return 'X';
    }
}
