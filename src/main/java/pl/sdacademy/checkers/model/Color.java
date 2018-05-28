package pl.sdacademy.checkers.model;

public enum Color {

    BLACK('B'),
    WHITE('W');

    private char color;

    Color(char color){
        this.color = color;
    }

    public char getColor() {
        return color;
    }
}
