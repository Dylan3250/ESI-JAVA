package esi.atl.g54027.td09;

import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.ToIntFunction;

public class InterfaceStandard {

    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point(11.5, 0);

        // --------------------------------
        // IntPredicate
        // --------------------------------
        IntPredicate eq0 = (nb) -> nb == 0;
        IntPredicate max10 = (nb) -> nb <= 10;

        System.out.println("P1 : X = 0 ? : " + eq0.test((int) p1.getX()));
        System.out.println("P2 : X = 0 ? : " + eq0.test((int) p2.getX()));
        System.out.println("P1 : X = 0 AND max10 ? : " + eq0.and(max10).test((int) p1.getX()));
        System.out.println("P2 : X = 0 AND max10 ? : " + eq0.and(max10).test((int) p2.getX()));
        System.out.println();

        // --------------------------------
        // BiPredicate
        // --------------------------------
        BiPredicate<Double, Double> sameValue = (x, y) -> Objects.equals(x, y);
        System.out.println("P1 = P2 : Y ? : " + sameValue.test(p1.getY(), p2.getY()));
        System.out.println("P1 = P2 : X ? : " + sameValue.test(p1.getX(), p2.getX()));
        System.out.println();

        // --------------------------------
        // DoubleConsumer
        // --------------------------------
        DoubleConsumer dc = (d) -> System.out.println("Value exp 2 : " + Math.pow(d, 2));
        dc.accept(p1.getX()); // return void
        System.out.println();

        // --------------------------------
        // ToIntFunction
        // --------------------------------
        ToIntFunction<Point> XtoIntFct = (d) -> (int) d.getX();
        System.out.println(XtoIntFct.applyAsInt(p2));
        System.out.println();

        // --------------------------------
        // IntToDoubleFunction
        // --------------------------------
        DoubleFunction<Point> XtoDoubleFct = (e) -> new Point(e, e); // here
        Point p3 = XtoDoubleFct.apply(2.1);
        System.out.println(p3);
        System.out.println();

        // --------------------------------
        // IntToDoubleFunction
        // --------------------------------
        IntToDoubleFunction cos = Math::cos;
        System.out.println(cos.applyAsDouble(5));
        System.out.println();
        
        // Bons examples : https://www.jmdoudoux.fr/java/dej/chap-lambdas.htm
    }

}
