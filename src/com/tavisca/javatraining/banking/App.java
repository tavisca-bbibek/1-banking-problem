package com.tavisca.javatraining.banking;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Bank xyzBank = new Bank("XYZ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        do {
            System.out.println("Welcome to - " + xyzBank.getName() + " bank");
            System.out.println("1. Open account");
            System.out.println("2. Close account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Report of the day");
            System.out.print("Your input: ");

            switch (choice) {
                case 1:
                    xyzBank.openAccount();
                    break;
                case 2:
                    xyzBank.closeAccount();
                    break;
                case 3:
                    xyzBank.deposit();
                    break;
                case 4:
                    xyzBank.withdraw();
                    break;
                case 5:
                    xyzBank.printTransactions();
                    break;
                default:
                    System.out.println("Invalid input, Bye!");
            }
        } while (choice >= 1 && choice <= 5);
    }
}
