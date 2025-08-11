package day3;

public class MathOperations {

    public void printTable(int number) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
    }

    public int calculateFactorial(int number) {
        int fact = 1;
        for (int i = 2; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }

    public boolean checkPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public void printFibonacci(int terms) {
        int a = 0, b = 1;
        System.out.print("Fibonacci Series: " + a);
        if (terms > 1) {
            System.out.print(" " + b);
        }
        for (int i = 3; i <= terms; i++) {
            int next = a + b;
            System.out.print(" " + next);
            a = b;
            b = next;
        }
        System.out.println();
    }
}
