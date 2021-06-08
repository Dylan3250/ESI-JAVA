package Ex02Compte;

public class Operation extends Thread {

    private Compte account;

    public Operation(Compte account) {
        this.account = account;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            account.deposerArgent(10);
            account.retirerArgent(10);
            System.out.println("Somme du compte : " + account.getSomme());
            if (account.getSomme() < 0) {
                System.exit(0);
            }
        }
    }
}
