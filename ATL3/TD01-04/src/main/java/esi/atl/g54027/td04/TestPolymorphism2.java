package esi.atl.g54027.td04;

class Figure {

    public void add(Figure f) {
        System.out.println("Figure:add(Figure)");
    }
}

class Rectangle extends Figure {

    @Override
    public void add(Figure f) {
        System.out.println("Rectangle:add(Figure)");
    }

    public void add(Rectangle r) {
        System.out.println("Rectangle:add(Rectangle)");
    }
}

class Square extends Rectangle {

    @Override
    public void add(Figure f) {
        System.out.println("Square:add(Figure)");
    }

    public void add(Square s) {
        System.out.println("Square:add(Square)");
    }
}

public class TestPolymorphism2 {

    public static void main(String[] args) {
        Figure fs = new Square();
        fs.add(fs); // Question 1
        // Square:add(Figure)

        Rectangle rs = new Square();
        rs.add(fs); // Question 2
        // Square:add(Figure)

        rs.add(new Square()); // Question 3
        // Rectangle:add(Rectangle)

        Square ss = new Square();
        ss.add(rs); // Question 4
        // Rectangle:add(Rectangle)
    }
}
