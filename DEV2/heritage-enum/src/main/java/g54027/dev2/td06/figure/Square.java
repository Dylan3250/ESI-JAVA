package g54027.dev2.td06.figure;

public class Square extends Rectangle {

    public Square(double side) {
        super(side, side);
    }

    @Override
    public double getWidth() {
        throw new UnsupportedOperationException("Impossible d'accéder à la largeur");
    }

    @Override
    public double getLength() {
        throw new UnsupportedOperationException("Impossible d'accéder à la hauteur");
    }

    public double getSide() {
        return this.width;
    }

    public double getSideByLength() {
        return super.getLength();
    }

    public static void main(String[] args) {
        Square sqrt = new Square(10);
        System.out.println(sqrt.getArea());
        System.out.println(sqrt.getSideByLength());

        Rectangle[] allFigures = {
            new Square(10),
            new Rectangle(20, 20)
        };

        for (Rectangle figure : allFigures) {
            System.out.println(figure.getArea());
        }

        Square square = new Square(42);
        Rectangle rectangle = new Rectangle(42, 42);
        System.out.println(square.getClass() == rectangle.getClass());
        System.out.println(square instanceof Rectangle);
    }
}
