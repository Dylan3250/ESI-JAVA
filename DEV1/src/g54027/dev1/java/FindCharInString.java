package g54027.dev1.java;

import java.util.Scanner;

public class FindCharInString {
    
    public static boolean contain(String phrase, char lettre) {
        boolean isContain = false;
        int i = 0;
        
        while (!isContain && i < phrase.length()) {
            
            if (Character.toLowerCase(phrase.charAt(i))
                    == Character.toLowerCase(lettre)) {
                isContain = true;
            }
            i++;
        }
        return isContain;
    }
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Veuillez entrer une phrase à vérifier : ");
        String phrase = keyboard.nextLine();
        System.out.print("Veuillez un caractère à vérifier : ");
        String verifCaract = keyboard.next();
        
        System.out.println(contain(phrase, verifCaract.charAt(0)));
    }
    
}
