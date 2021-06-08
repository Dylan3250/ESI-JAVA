package esi.atl.g54027.td04;

class A {

    public void a() {
        System.out.println("a de A");
    }

    public void b() {
        System.out.println("b de A");
    }
}

class B extends A {

    public void b() {
        System.out.println("b de B");
    }

    public void c() {
        System.out.println("c de B");
    }
}

public class Question2 {

    public static void main(String[] args) {
        A a1 = new A();
        A b1 = new B();
        // B a2 = new A(); A n'extends pas de B
        B b2 = new B();
        a1.a(); // a de A
        b1.a(); // a de A
        // a2.a() ; a2 pas défini
        b2.a(); // a de A
        a1.b(); // b de A
        b1.b(); // b de B
        // a2.a() ; a2 pas défini
        b2.a(); // a de A
        a1.b(); // b de A
        b1.b(); // b de B
        // a2.c() // a2 pas défini
        b2.c(); // c de B
        // ((B) a1).c();  erreur execution car new A ne peut pas être de type B
        ((B) b1).c(); // c de B
        // ((B)a2).c(); a2 pas défini
        ((B) b2).c(); // c de B
    }

}
