package day3;

import java.util.Scanner;

public class MenuApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MathOperations math = new MathOperations();
        int choice;

        do {
            System.out.println("1. Print Table of a Number");
            System.out.println("2. Calculate Factorial");
            System.out.println("3. Check Prime Number");
            System.out.println("4. Print Fibonacci Series");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number: ");
                    int tableNum = sc.nextInt();
                    math.printTable(tableNum);
                    break;
                case 2:
                    System.out.print("Enter number: ");
                    int factNum = sc.nextInt();
                    System.out.println("Factorial: " + math.calculateFactorial(factNum));
                    break;
                case 3:
                    System.out.print("Enter number: ");
                    int primeNum = sc.nextInt();
                    if (math.checkPrime(primeNum)) {
                        System.out.println("Prime Number");
                    } else {
                        System.out.println("Not a Prime Number");
                    }
                    break;
                case 4:
                    System.out.print("Enter number of terms: ");
                    int terms = sc.nextInt();
                    math.printFibonacci(terms);
                    break;
                case 5:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}