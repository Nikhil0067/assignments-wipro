package day3;

import java.util.Scanner;

public class StringAssignmentApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringUtility util = new StringUtility();
        String inputStr;

        System.out.print("Enter a string: ");
        inputStr = sc.nextLine();

        int choice;
        do {
            System.out.println("1. Count Vowels");
            System.out.println("2. Count Consonants");
            System.out.println("3. Check Palindrome");
            System.out.println("4. Reverse String");
            System.out.println("5. Convert to Uppercase");
            System.out.println("6. Convert to Lowercase");
            System.out.println("7. Replace a Word");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Vowels: " + util.countVowels(inputStr));
                    break;
                case 2:
                    System.out.println("Consonants: " + util.countConsonants(inputStr));
                    break;
                case 3:
                    System.out.println(util.isPalindrome(inputStr) ? "Palindrome" : "Not a Palindrome");
                    break;
                case 4:
                    System.out.println("Reversed String: " + util.reverseString(inputStr));
                    break;
                case 5:
                    System.out.println("Uppercase: " + util.toUpperCase(inputStr));
                    break;
                case 6:
                    System.out.println("Lowercase: " + util.toLowerCase(inputStr));
                    break;
                case 7:
                    System.out.print("Enter word to replace: ");
                    String oldWord = sc.nextLine();
                    System.out.print("Enter new word: ");
                    String newWord = sc.nextLine();
                    inputStr = util.replaceWord(inputStr, oldWord, newWord);
                    System.out.println("Updated String: " + inputStr);
                    break;
                case 8:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 8);

        sc.close();
    }
}
