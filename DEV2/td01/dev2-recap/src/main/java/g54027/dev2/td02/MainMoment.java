package g54027.dev2.td02;

public class MainMoment {

    public static void main(String[] args) {
        Moment moment1 = new Moment(12, 0, 0);
        Moment moment2 = new Moment(18, 30, 0);
        Moment moment3 = new Moment(23, 20, 30);
        Moment momentEquals = new Moment(12, 0, 0);
        Moment momentMidnight = new Moment();

        System.out.println("Moment1 pas égal à MomentEquals : " + moment1.equals(moment2));
        System.out.println("Moment1 égal à MomentEquals : " + moment1.equals(momentEquals));
        System.out.println("Minuit sans arguments : " + momentMidnight);
        System.out.println("Moment1 : " + moment1);
        System.out.println("Moment2 : " + moment2);
        System.out.println("Moment3 : " + moment3);
        System.out.println("Le moment3 (" + moment3 + ") converti en seconde donne : " + moment3.toSeconds() + " secondes.");
        System.out.println("Le moment3 (" + moment3 + ") viens après le moment2 : " + moment2 + " ? : " + moment3.compareTo(moment1));
    }
}