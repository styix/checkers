package pl.sdacademy.checkers.model;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import pl.sdacademy.checkers.controller.GameController;

public class Move {

    TextIO textIO = TextIoFactory.getTextIO();
    private final char[][] board;
    public char LEFT = 'l';
    public char RIGHT = 'r';
    private char EMPTY = ' ';
    Color white = Color.WHITE;
    Color black = Color.BLACK;

    public Move(Board board) {
        this.board = board.getBoard();
    }

    GameController gc = new GameController();

    public void movePiece(int x, int y, char direction, Color color) {

        boolean checkMove = gc.checkPosition(x, y, direction, color);

        if (board[x][y] == black.getColor() && checkMove == true) {
            if (direction == LEFT) {
                int position = y;
                board[x][y] = EMPTY;
                position--;
                board[x - 1][position] = black.getColor();
            }

            if (direction == RIGHT) {
                int position = y;
                board[x][y] = EMPTY;
                position++;
                board[x - 1][position] = black.getColor();
            }
        } else if (checkMove == false){
            textIO.getTextTerminal().println("Incorrect move!");
        }

        if (color == white && checkMove == true) {
            if (board[x][y] == white.getColor()) {
                if (direction == LEFT) {
                    int position = y;
                    board[x][y] = EMPTY;
                    position--;
                    board[x + 1][position] = white.getColor();
                }

                if (direction == RIGHT) {
                    int position = y;
                    board[x][y] = EMPTY;
                    position++;
                    board[x + 1][position] = white.getColor();
                }
            } else if (checkMove == false){
                textIO.getTextTerminal().println("Incorrect move!");
            }
        }
    }
}
