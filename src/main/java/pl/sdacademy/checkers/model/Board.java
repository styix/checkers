package pl.sdacademy.checkers.model;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

import java.util.Arrays;

public class Board {

    private char EMPTY = ' ';
    char[][] board = new char[8][8];
    Color white = Color.WHITE;
    Color black = Color.BLACK;

    TextIO textIO = TextIoFactory.getTextIO();

    public Board() {

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                board[x][y] = EMPTY;
            }
        }
    }

    public void setBoard() {

        for (int x = 0; x < 8; x++)
            for (int y = 0; y < 8; y++)
                board[x][y] = EMPTY;

        board[0][0]=board[0][2]=board[0][4]=board[0][6]=white.getColor();
        board[1][1]=board[1][3]=board[1][5]=board[1][7]=white.getColor();
        board[2][0]=board[2][2]=board[2][4]=board[2][6]=white.getColor();

        board[7][1]=board[7][3]=board[7][5]=board[7][7]=black.getColor();
        board[6][0]=board[6][2]=board[6][4]=board[6][6]=black.getColor();
        board[5][1]=board[5][3]=board[5][5]=board[5][7]=black.getColor();

    }

    public void printBoard(Board array){
        TextIO textIO = TextIoFactory.getTextIO();
        for (char[] b : board) {
            textIO.getTextTerminal().println((Arrays.toString(b)));
        }
    }

    public char[][] getBoard() {
        return board;
    }
}
