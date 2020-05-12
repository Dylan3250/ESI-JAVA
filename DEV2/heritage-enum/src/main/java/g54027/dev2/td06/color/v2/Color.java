package g54027.dev2.td06.color.v2;

public enum Color {
    BLACK("\033[30m"),
    RED("\033[31m"),
    GREEN("\033[32m"),
    YELLOW("\033[33m"),
    BLUE("\033[34m"),
    MAGENTA("\033[35m"),
    CYAN("\033[36m"),
    WHITE("\033[37m");

    private final String code;

    private Color(String code) {
        this.code = code;
    }

    public String color(String text) {
        return this.code + text + "\033[m";
    }

    @Override
    public String toString() {
        return code;
    }
}
