package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter account data: ");
			System.out.print("Number: ");
			Integer number = sc.nextInt();

			System.out.print("Holder: ");
			sc.nextLine();
			String name = sc.nextLine();

			System.out.print("Initial Balance: ");
			Double balance = sc.nextDouble();

			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();

			Account acc = new Account(number, name, withdrawLimit);
			acc.deposit(balance);

			System.out.println();

			System.out.print("Enter amount for withdraw: ");
			Double withdraw = sc.nextDouble();
			acc.withdraw(withdraw);

			System.out.printf("New Balance: %.2f", acc.getBalance());
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}

		sc.close();
	}
}
