package tictactoe;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    @Test
    void emptyBoard_gameNotFinished(){
        String input = "         ";

        char[][] gameBoard = Main.initGameBoard(input.toCharArray());

        assertEquals("Game not finished", Main.checkGame(gameBoard));
    }

    @Test
    void onlyOneSymbol_gameNotFinished(){
        String input = "X        ";

        char[][] gameBoard = Main.initGameBoard(input.toCharArray());

        assertEquals("Game not finished", Main.checkGame(gameBoard));
    }

    @Test
    void tooMuchOfTheSameSymbol_impossilbe(){
        String input = "XX_______";

        char[][] gameBoard = Main.initGameBoard(input.toCharArray());

        assertEquals("Impossible", Main.checkGame(gameBoard));
    }

    @Test
    void xWins(){
        String input = "XXXOO____";

        char[][] gameBoard = Main.initGameBoard(input.toCharArray());

        assertEquals("X wins", Main.checkGame(gameBoard));
    }

    @Test
    void oWins(){
        String input = "OOOXX____";

        char[][] gameBoard = Main.initGameBoard(input.toCharArray());

        assertEquals("O wins", Main.checkGame(gameBoard));
    }

    @Test
    void isDraw(){
        String input = "XOXOOXXXO";

        char[][] gameBoard = Main.initGameBoard(input.toCharArray());

        assertEquals("Draw", Main.checkGame(gameBoard));
    }

    @Test
    void ifBothWin_shouldBeImpossible(){
        String input = "XO_XO_XOX";

        char[][] gameBoard = Main.initGameBoard(input.toCharArray());

        assertEquals("Impossible", Main.checkGame(gameBoard));
    }

    @Disabled("This case is not managed yet, the game stops before reaching this situation")
    @Test
    void sameSymbolWinsMultipleTimes_shouldBeImpossible(){
        String input = "XXXOXOOOX";

        char[][] gameBoard = Main.initGameBoard(input.toCharArray());

        assertEquals("Impossible", Main.checkGame(gameBoard));
    }
}

