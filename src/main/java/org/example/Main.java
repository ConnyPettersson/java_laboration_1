package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
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
                    sortPrices();
                    break;
                case "4":
                    bestStartTime();
                    break;
                case "e":
                    System.out.println("Programmet avslutas...");
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
            sum += prices[i];
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
        System.out.println("Medelpriset på dygnet: " + mid + " öre.");
    }

    private static void sortPrices() {
        List<HourPrice> hourPrices = new ArrayList<>();

        for (int i = 0; i < prices.length; i++) {
            hourPrices.add(new HourPrice(prices[i],  i));
        }

        Collections.sort(hourPrices);

        System.out.println("Priser sorterade från lägsta till högsta: ");

        for (HourPrice hp : hourPrices) {
            System.out.printf("%02d-%02d %d öre\n", hp.hour, hp.hour + 1, hp.price);
        }
    }

    static class HourPrice implements Comparable<HourPrice> {
        int price;
        int hour;

        HourPrice(int price, int hour) {
            this.price = price;
            this.hour  = hour;
        }

        @Override
        public int compareTo(HourPrice other) {
            return Integer.compare(this.price, other.price);
        }
    }

    private static void bestStartTime() {
        int currentPrice = 0;
        int minPrice = Integer.MAX_VALUE;
        int bestStartHour = 0;

        for (int i = 0; i < 4; i++) {
            currentPrice += prices[i];
        }

        minPrice = currentPrice;

        for(int i = 1; i < 21; i++) {
            currentPrice =  currentPrice - prices[i - 1] + prices[i + 3];

            if(currentPrice < minPrice) {
                minPrice = currentPrice;
                bestStartHour = i;
            }
        }

        System.out.println("Billigaste laddningstid (4h) är kl " + bestStartHour + " till " + (bestStartHour + 3) + " med en totalkostnad på " + minPrice + " öre.");
    }
}
