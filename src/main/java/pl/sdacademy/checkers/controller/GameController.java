package pl.sdacademy.checkers.controller;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import pl.sdacademy.checkers.model.Board;
import pl.sdacademy.checkers.model.Color;

import java.util.Scanner;

public class GameController {

    TextIO textIO = TextIoFactory.getTextIO();
    char[][] board;

    public GameController() {
    }

    public GameController(Board board) {
        this.board = board.getBoard();
    }

    public boolean checkPosition(int x, int y, char direction, Color color) {
        if (color == Color.BLACK) {
            if (direction == 'l') {
                if (y == 0) {
                    return false;
                }
            }

            if (direction == 'r') {
                if (y == 7) {
                    return false;
                }
            }
        }

        if (color == Color.WHITE){
            if (direction == 'l') {
                if (y == 7) {
                    return false;
                }
            }

            if (direction == 'r') {
                if (y == 0) {
                    return false;
                }
            }
        }

        if (x <= 0 || x > 7) {
            return false;
        }
        return true;
    }

    public void checkScore(){
        int counterW = 12;
        int counterB = 12;

        for (char[] b : board) {
            for (char c : b) {
                if (c == 'W') {
                    counterB--;
                }
                if (c == 'B') {
                    counterW--;
                }
            }
        }
        textIO.getTextTerminal().println();
        textIO.getTextTerminal().println("White score: " + counterW + " || " + "Black score: " + counterB);
    }

//    public int userAction(){
//        textIO.newStringInputReader().read("MENU:\n1.START NEW GAME" + " || 2.EXIT");
//        int action = sc.nextInt();
//        textIO.getTextTerminal().println();
//        if(action > 0 && action < 3){
//            return action;
//        }
//        else throw new IllegalArgumentException("Incorrect value, please select one from the MENU");
//    }

    public boolean closeApp(){
        String decision = textIO.newStringInputReader().read("Exit application?\n [Y / N]");
        return decision.toLowerCase().equals("y");
    }

//    public void turnIntoSSJ4(){
//        if (board[])
//    }
}
