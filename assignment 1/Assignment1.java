package day3;

import java.util.Scanner;

public class Assignment1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char repeat;
		
		do {
			System.out.println("********** MENU **********");
			System.out.println("1. Print Table of a Number");
			System.out.println("2. Calculate Factorial");
			System.out.println("3. Check Prime Number");
			System.out.println("4. Print Fibonacci Series");
			System.out.println("5. Exit");
			System.out.println("**************************");
			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				System.out.print("Enter the number: ");
				int tn = sc.nextInt();
				for (int i = 1; i <=10; i++) {
					System.out.println(tn + "X" + i + "=" + (tn * i));
				} break;
				
			 case 2:
                 System.out.print("Enter the number: ");
                 int factNum = sc.nextInt();

                 if (factNum > 10) {
                     System.out.println("Please enter a number <= 10.");
                 } else if (factNum < 0) {
                     System.out.println("Enter Positive number");
                 } else {
                     int fact = 1;
                     for (int i = 1; i <= factNum; i++) {
                         fact *= i;
                     }
                     System.out.println("Factorial of " + factNum + " is: " + fact);
                 }
                 break;

			 case 3:
                 System.out.print("Enter the number: ");
                 int primeNum = sc.nextInt();
                 boolean isPrime = true;
                 int i = 2;
                 while (i <= primeNum / 2) {
                     if (primeNum % i == 0) {
                         isPrime = false;
                         break;
                     }
                     i++;
                 }
                 if (primeNum <= 1) {
                     isPrime = false;
                 }
                 System.out.println(primeNum + (isPrime ? " is a Prime Number" : " is not a Prime Number"));
                 break;

			 case 4:
                 System.out.print("Enter the number of terms: ");
                 int terms = sc.nextInt();
                 int a = 0, b = 1;
                 System.out.print("Fibonacci Series: ");
                 for (int j = 1; j <= terms; j++) {
                     System.out.print(a + " ");
                     int next = a + b;
                     a = b;
                     b = next;
                 }
                 System.out.println();
                 break;
                 
			 case 5:
				 System.out.println("Exit");
				 sc.close();
				 return;

			 default:
                 System.out.println("Invalid choice.");
			}
			
			System.out.println("Back to Menu? (Y/N): ");
			repeat = sc.next().charAt(0);
		} while (repeat == 'Y' || repeat == 'y');
		sc.close();
	}

}
