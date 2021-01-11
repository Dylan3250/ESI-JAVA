package esi.atl.g54027.td08;

public class TestBoxSubtyping {

    public static void main(String[] args) {
        // Box<Object> box = new Box<Integer>(new Integer(42)); -- Peut pas convertir un <Object> en <Integer>, sinon dans une Box on pourrait avoir des doubles etc.
        Box<Integer> box = new Box<Integer>(new Integer(42));
        Object value = box.getElement();
        System.out.println(box);
        System.out.println(value);
        // box.setElement(new Double(43)); -- La box doit être des integers
        System.out.println(box);
    }
}