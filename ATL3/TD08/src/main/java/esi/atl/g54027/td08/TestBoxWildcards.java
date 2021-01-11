package esi.atl.g54027.td08;

public class TestBoxWildcards {
    public static void main(String[] args) {
        Box<?> box;
        box = new Box<Integer>(new Integer(42));
        box = new Box<Object>(new Integer(42));

        Object value = box.getElement();
        System.out.println(box);
        System.out.println(value);
        // box.setElement(new Integer(43)); -- Box d'object pas de Integer
        System.out.println(box);
    }
}