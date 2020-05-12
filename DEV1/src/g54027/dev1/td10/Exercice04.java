package g54027.dev1.td10;

public class Exercice04 {

    public static boolean estPalindrome(String phrase) {
        int n = phrase.length();
        boolean isPalindrome = true;

        for (int i = 0; i < phrase.length() / 2 && isPalindrome; ++i) {
            if (phrase.charAt(i) != phrase.charAt(n - i - 1)) {
                isPalindrome = false;
            }
        }

        return isPalindrome;
    }

    public static void main(String[] args) {
        System.out.println(estPalindrome("kayak"));
        System.out.println(estPalindrome("kaak"));
        System.out.println(estPalindrome("test pas palindrome"));
        System.out.println(estPalindrome(""));
    }
}
