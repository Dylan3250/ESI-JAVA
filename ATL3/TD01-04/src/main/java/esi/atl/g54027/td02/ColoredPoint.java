package esi.atl.g54027.td02;

public class ColoredPoint extends Point {

    private int color;  // A 32-bit integer of the form: 0xRRGGBBAA 
    // where AA represents the alpha value

    public ColoredPoint(double x, double y, int color) {
//        System.out.println(" test " );
        super(x, y);
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    @Override
    public String toString() {
//        return this.x +" − "+ this.y +" − "+ this.color;
        return super.toString() + " - " + String.format("%08X", color);
    }
}
