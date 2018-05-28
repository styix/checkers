package pl.sdacademy.checkers;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;
import pl.sdacademy.checkers.controller.GameController;
import pl.sdacademy.checkers.model.Board;
import pl.sdacademy.checkers.model.Color;
import pl.sdacademy.checkers.model.Move;
import pl.sdacademy.checkers.view.ConsoleView;

public class Main {

    public static void main(String[] args) {

        ConsoleView view = new ConsoleView();
        view.runApp();

    }
}
