package Ex02Compte;

public class Main {
    
    public static void main(String[] args) {
        Compte account = new Compte();
        for (int i = 0; i < 20; i++) {
            Operation operation = new Operation(account);
            operation.start();
        }
    }
}
