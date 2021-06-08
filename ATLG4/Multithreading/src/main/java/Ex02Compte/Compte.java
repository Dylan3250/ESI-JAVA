package Ex02Compte;

public class Compte {
    private double amount = 0;

    public synchronized void deposerArgent(double somme) {
        amount += somme;
    }

    public synchronized void retirerArgent(double somme) {
        amount -= somme;
    }

    public synchronized double getSomme() {
        return amount;
    }
}