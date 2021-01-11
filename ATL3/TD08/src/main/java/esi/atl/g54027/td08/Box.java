package esi.atl.g54027.td08;

public class Box<T> {
    T element;

    public Box(T element) {
        this.element = element;
    }
    public T getElement() {
        return element;
    }
    public void setElement(T element) {
        this.element = element;
    }
    @Override
    public String toString() {
        return "[" + element + "]";
    }
    public static void main(String[] args) {
        Box<Integer> box = new Box<Integer>(42);
        // var box = new Box<Integer>(42); -- le meilleur de JDK10
        // Box<Integer> box = new Box<Integer>(new Integer(42)); -- pas besoin de créer un new Integer vu que ce sont des integers.
        // box.setElement(new Double(43)); -- double ne peut pas être convertis en int
        Integer value = box.getElement();
        System.out.println(box);
        System.out.println(value);
        box.setElement(43);
        System.out.println(box);
    }
}