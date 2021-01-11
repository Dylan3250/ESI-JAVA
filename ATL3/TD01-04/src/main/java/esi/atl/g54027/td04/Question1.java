package esi.atl.g54027.td04;

//class A {
//
//    int foo() {
//        return 1;
//    }
//
//    int zork() {
//        return this.bar();
//    }
//
//    int bar() {
//        return 3;
//    }
//}
//
//class B extends A {
//
//    int foo() {
//        return super.zork();
//    }
//}
//
//class C extends B {
//
//    int zork() {
//        return this.foo() + 5;
//    }
//
//    int bar() {
//        return 7;
//    }
//}
//
//public class Question1 {
//
//    public static void main(String[] args) {
//        A a = new A();
//        System.out.println(a.zork()); // 3
//        B b = new B();
//        System.out.println(b.zork()); // 3
//        C c = new C();
//        System.out.println(c.zork()); // 12 car le this est remplacé par C même dans A 
//        B e = new C();
//        System.out.println(e.zork()); // 12 car l'objet est de type C et il va chercher dans C s'il n'y a pas dans B
//        A f = new C();
//        System.out.println(f.zork()); // 12
//        A g = new B();
//        System.out.println(g.zork()); // 3 car appel la méthode de A
//    }
//}
