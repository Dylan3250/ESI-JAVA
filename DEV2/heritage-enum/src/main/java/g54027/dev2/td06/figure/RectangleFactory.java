package g54027.dev2.td06.figure;

public class RectangleFactory {

    public static Figure makeRectangle(double length, double width) {
        return (length == width) ? new Square(width) : new Rectangle(length, width);
    }
}
