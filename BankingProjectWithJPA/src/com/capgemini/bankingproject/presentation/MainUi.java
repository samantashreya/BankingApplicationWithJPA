package com.capgemini.bankingproject.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.bankingproject.bean.Customer;
import com.capgemini.bankingproject.bean.Transcation;
import com.capgemini.bankingproject.exception.BankJpaException;
import com.capgemini.bankingproject.service.BankingServiceImpl;
import com.capgemini.bankingproject.service.IBankingService;

public class MainUi {
	public static void main(String[] args) {
		String continueChoice;
		boolean continueValue = false;

		Scanner scanner = null;
		do {

			System.out.println("*** welcome to Banking Application");
			System.out.println("1.Register/Create account");
			System.out.println("2.Show Balance");
			System.out.println("3.Deposit");
			System.out.println("4.Withdraw");
			System.out.println("5.Fund Transfer");
			System.out.println("6.Print Transactions");

			IBankingService service = new BankingServiceImpl();

			int choice = 0;
			boolean choiceFlag = false;

			do {
				scanner = new Scanner(System.in);
				System.out.println("Enter input:");
				try {
					choice = scanner.nextInt();
					choiceFlag = true;

					boolean nameFlag = false;

					String name = "";
					switch (choice) {

					case 1:
						do {
							scanner = new Scanner(System.in);
							System.out.println("Enter Customer name:");
							name = scanner.nextLine();
							try {
								service.custNameValidation(name);
								nameFlag = true;
							} catch (BankJpaException e) {
								nameFlag = false;
								System.err.println(e.getMessage());
							}
						} while (!nameFlag);

						String mobile = "";
						boolean mobileFlag = false;
						do {
							scanner = new Scanner(System.in);
							System.out.println("Enter mobile :");
							try {
								mobile = scanner.nextLine();
								service.custMobValidation(mobile);
								mobileFlag = true;
							} catch (InputMismatchException e) {
								mobileFlag = false;
								System.err.println("Cost should be in digits");
							} catch (BankJpaException e) {
								mobileFlag = false;
								System.err.println(e.getMessage());
							}
						} while (!mobileFlag);

						String email = "";
						boolean emailFlag = false;
						do {
							scanner = new Scanner(System.in);
							System.out.println("Enter email :");
							try {
								email = scanner.nextLine();
								service.custEmailValidation(email);
								emailFlag = true;
							} catch (InputMismatchException e) {
								emailFlag = false;
								System.err.println("Cost should be in digits");
							} catch (BankJpaException e) {
								emailFlag = false;
								System.err.println(e.getMessage());
							}
						} while (!emailFlag);

						System.out.println("Enter customer address:");
						String address = scanner.nextLine();

						Customer customer = new Customer(name, mobile, email, address);

						try {
							double custId = service.addToCustomer(customer);
							System.out.println("Your custId is " + custId);
						} catch (BankJpaException e) {
							System.err.println(e.getMessage());
						}

						break;
					case 2: {

						boolean custFlag = false;
						do {
							scanner = new Scanner(System.in);
							System.out.println("Enter custId to check balance:");
							try {
								int custId = scanner.nextInt();
								service.validateDestinationAccount(custId);

								System.out.println(service.showBalance(custId));
								break;
							} catch (BankJpaException e) {
								custFlag = false;
								System.err.println(e.getMessage());
							}
						} while (!custFlag);

						break;
					}
					case 3: {

						boolean custFlag = false;
						do {
							scanner = new Scanner(System.in);
							System.out.println("Enter custId to deposit balance:");
							try {
								int custId = scanner.nextInt();
								service.validateDestinationAccount(custId);
								System.out.println("Enter amount to deposit");
								double amount = scanner.nextDouble();
								double finalBalance=service.depositBalance(custId, amount);
								System.out.println("Successfully deposited! Your updated balance is: "+finalBalance);
								break;
							} catch (BankJpaException e) {
								custFlag = false;
								System.err.println(e.getMessage());
							}
						} while (!custFlag);

						break;
					}

					case 4: {

						boolean custFlag = false;
						do {
							scanner = new Scanner(System.in);
							System.out.println("Enter custId to withdraw balance:");
							try {
								int custId = scanner.nextInt();
								service.validateDestinationAccount(custId);
								System.out.println("Enter amount to withdraw");
								double amount = scanner.nextDouble();
								double finalBalance=service.withdrawBalance(custId, amount);
								System.out.println("Money Withdraw Success! Your updated balance is: "+finalBalance);
								break;
							} catch (BankJpaException e) {
								custFlag = false;
								System.err.println(e.getMessage());
							}
						} while (!custFlag);
						break;
					}

					case 5: {

						boolean custFlag = false;
						do {
							scanner = new Scanner(System.in);
							System.out.println("Enter your customer Id to send money:");
							try {
								int sourceCustId = scanner.nextInt();
								service.validateDestinationAccount(sourceCustId);
								System.out.println("Enter custId to trasfer money:");
								int destinationCustId = scanner.nextInt();
								System.out.println("Enter your account number");
								long sourceAccNo = scanner.nextLong();
								System.out.println("Enter recipient account number");
								long destinationAccNo = scanner.nextLong();
								System.out.println("Enter amount to transfer");
								double amount = scanner.nextDouble();
								
								int transId= service.transferFunds(sourceCustId, destinationCustId,amount);
								System.out.println("Succesfull transaction with transaction Id:"+transId);
								break;
							} catch (BankJpaException e) {
								custFlag = false;
								System.err.println(e.getMessage());
							}
						} while (!custFlag);

						break;
					}

					case 6: {

						boolean custIdFlag = false;
						do {
							scanner = new Scanner(System.in);
							System.out.println("Enter custId to check transaction:");
							try {
								int custId = scanner.nextInt();
								//service.validateCustId(custId);
								System.out.println(service.printTransactionDetails(custId));
								custIdFlag=true;
								break;
							} catch (BankJpaException e) {
								custIdFlag = false;
								System.err.println(e.getMessage());
							}
						} while (!custIdFlag);

						break;
					}

					case 7:
						System.out.println("Thank u, visit again");
						System.exit(0);
						break;
					default:
						System.out.println("input should be 1,2,3,4,5,6,7");
						choiceFlag = false;
						break;
					}

				} catch (InputMismatchException exception) {
					choiceFlag = false;
					System.err.println("input should contain only digits");
				}
			} while (!choiceFlag);

			do {
				scanner = new Scanner(System.in);
				System.out.println("do you want to continue again [yes/no]");
				continueChoice = scanner.nextLine();
				if (continueChoice.equalsIgnoreCase("yes")) {
					continueValue = true;
					break;
				} else if (continueChoice.equalsIgnoreCase("no")) {
					System.out.println("thank you");
					continueValue = false;
					break;
				} else {
					System.out.println("enter yes or no");
					continueValue = false;
					continue;
				}
			} while (!continueValue);

		} while (continueValue);
		scanner.close();

	}

}
