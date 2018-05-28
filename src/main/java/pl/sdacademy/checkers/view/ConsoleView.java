package pl.sdacademy.checkers.view;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import pl.sdacademy.checkers.controller.GameController;
import pl.sdacademy.checkers.model.Board;
import pl.sdacademy.checkers.model.Color;
import pl.sdacademy.checkers.model.Move;

public class ConsoleView {

    TextIO textIO = TextIoFactory.getTextIO();
    Board board = new Board();
    Move move = new Move(board);
    GameController gc = new GameController(board);

    public void runApp(){
        boolean close = false;
        while(close == false){
            textIO.getTextTerminal().setBookmark("reset");
           int action = textIO.newIntInputReader().read("MENU:\n1.START NEW GAME" + " || 2.EXIT");
           if (action == 1){

               boolean back = false;
               board.setBoard();

               while(back == false) {

                   Color color = null;
                   int x = 0;
                   int y = 0;
                   char direction = ' ';

                   board.printBoard(board);
                   gc.checkScore();
                   textIO.getTextTerminal().println();
                   int userAction = textIO.newIntInputReader().read("CHOOSE ACTION:\n" +
                           "1.MOVE\n2.BACK");

                   if (userAction == 1){
                       int player = textIO.newIntInputReader().read("CHOOSE PLAYER:\n1.WHITE \n2.BLACK");
                       if (player == 1){
                           color = Color.WHITE;
                           textIO.getTextTerminal().print("CHOOSE PIECE\n");
                           x = textIO.newIntInputReader().read("X: ");
                           y = textIO.newIntInputReader().read("Y: ");
                           textIO.getTextTerminal().print("CHOOSE DIRECTION\n");
                           direction = textIO.newCharInputReader().read("LEFT: l / RIGHT: r");
                       }
                       if (player == 2){
                           color = Color.BLACK;
                           textIO.getTextTerminal().print("CHOOSE PIECE\n");
                           x = textIO.newIntInputReader().read("X: ");
                           y = textIO.newIntInputReader().read("Y: ");
                           textIO.getTextTerminal().print("CHOOSE DIRECTION\n");
                           direction = textIO.newCharInputReader().read("LEFT: l / RIGHT: r");
                       }
                       move.movePiece(x, y, direction, color);
                       textIO.getTextTerminal().resetToBookmark("reset");
                   } else if (userAction == 2){
                       back = true;
                   }
               }
           }
           if (gc.closeApp() == true) {
               textIO.getTextTerminal().dispose();
               close = true;
           }
        }
    }
}
