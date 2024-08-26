package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    static Scanner sc = new Scanner(System.in);
    static int[] prices = new int[24];

    public static void main(String[] args) {

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
                    inputPrices();
                    break;
                case "2":
                    calculateStats(prices);
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

        }while (!choice.equalsIgnoreCase("e"));
    }

    private static void inputPrices() {
        System.out.println("Ange priser för varje timme i hela ören: ");

        for (int i = 0; i < prices.length; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.printf("Pris mellan %02d-%02d: ", i, i + 1);

                try{
                    prices[i] = sc.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Ogiltig inmatning, endast heltal är tillåtna.");
                }
            }
        }
    }

    private static void calculateStats(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int mid = 0;
        int sum = 0;
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < prices.length; i++) {
            sum += 0;
            if(prices[i] < min) {
                min = prices[i];
                minIndex = i;
            }
            if(prices[i] > max) {
                max = prices[i];
                maxIndex = i;
            }
            mid = sum / prices.length;
        }

        System.out.println("Lägsta pris: " + min + " öre, klockan: " + minIndex + ".");
        System.out.println("Högsta pris: " + max + " öre, klockan: " + maxIndex + ".");
        System.out.println("Medelpriset på dygnet: " + mid + ".");
    }
}
