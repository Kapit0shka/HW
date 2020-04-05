package horstmann4chapter.color;

public enum Color{
    BLACK("Black"), RED("Red"),  BLUE("Blue"),  GREEN("Green"),
    CYAN("Cyan"),  MAGENTA("Magenta"),  YELLOW("Yellow"), WHITE("White");

    String color;

    Color (String color) {
        this.color = color;
    }

    public Color getRed() {
        return RED;
    }

    public Color getGreen() {
        return GREEN;
    }

    public Color getBlue() {
        return BLUE;
    }
}
