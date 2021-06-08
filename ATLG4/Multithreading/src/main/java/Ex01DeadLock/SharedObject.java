package Ex01DeadLock;

public class SharedObject {

    public void showValueA(String name) {
        synchronized ("A") {
            System.out.println(name + " est dans showValueA et va attendre un peu");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " appel showValueB");
            showValueB(name);
            System.out.println(name + " a terminé showValueA");
        }
    }

    public void showValueB(String name) {
        synchronized ("B") {
            System.out.println(name + " est dans showValueB et va attendre un peu");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " appel showValueA");
            showValueA(name);
            System.out.println(name + " a terminé showValueB");
        }
    }

}
