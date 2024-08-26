package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         String choice;

        do {
            System.out.println("Elpriser");
            System.out.println("========");
            System.out.println("1. Inmatning");
            System.out.println("2. Min , Max och Medel");
            System.out.println("3. Sortera");
            System.out.println("4. Bästa Laddningstid (4h)");
            System.out.println("e. Avsluta");

            choice = sc.next();

            switch (choice.toLowerCase()) {
                case "1":
                    //choice 1
                    break;
                case "2":
                    //choice 2
                    break;
                case "3":
                    //choice 3
                    break;
                case "4":
                    //choice 4
                    break;
                case "e":
                    // choice e
                    break;
                default:
                    System.out.println("Ogiltigt val, försök igen.");
            }

        }while (choice.equalsIgnoreCase("e"));
    }
}
