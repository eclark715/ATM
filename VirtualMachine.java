package ATM;

import java.util.Scanner;

public class VirtualMachine {
	static BankPatron pat1, pat2, pat3, pat4, pat5;
	static PatronList list1 = new PatronList();
	static String choice1, fullName;
	private static Scanner scan = new Scanner(System.in);
	private static Scanner scan1 = new Scanner(System.in);

	public static void main(String[] args)
	{
		System.out.println("Welcome to the CSE 110 Bank");
		mainMenu();
	}
	
	
	public static String mainMenu()
	{
		String name, name1, nameFull;
		double cashOnHand, salary;
		String choice;
		System.out.println("a. List the Patrons");
		System.out.println("b. Add New Patrons");
		System.out.println("c. Remove Patron");
		System.out.println("d. Patron Specific Actions");
		System.out.println("e. Quit");
		
		do
		{
			//The above code is printed and choice scans the input
			choice = scan.next();
			//If input is not equal to a, b, c, d, or e then it runs the code below
			while(!choice.equals("a") && !choice.equals("b") && !choice.equals("c") && !choice.equals("d") && !choice.equals("e"))
			{
				System.out.println("Invalid Input");
				System.out.println("a. List the Patrons");
				System.out.println("b. Add New Patrons");
				System.out.println("c. Remove Patron");
				System.out.println("d. Patron Specific Actions");
				System.out.println("e. Quit");
				choice = scan.next();
			}
		}
		//However if input is equal to a, b, c, d, or e then it will exit the loop
		while(!choice.equals("a") && !choice.equals("b") && !choice.equals("c") && !choice.equals("d") && !choice.equals("e"));
		
		//Prints out each patrons information
		if(choice.equals("a"))
		{
			System.out.println("Patrons currently at the bank: ");
			if(pat1 != null)
			{
				System.out.println(list1.returnInfo(pat1));
				if(pat2 != null)
				{
					System.out.println(list1.returnInfo(pat2));
					if(pat3 != null)
					{
						System.out.println(list1.returnInfo(pat3));
						if(pat4 != null)
						{
							System.out.println(list1.returnInfo(pat4));
							if(pat5 != null){System.out.println(list1.returnInfo(pat5));}
						}
						
						
					}
				}
			}
			
			else
			{
				System.out.println("None");
			}
			mainMenu();
		}
		//Initializes a patron using given information
		else if(choice.equals("b"))
		{
			System.out.println("What is the first name of the patron? ");
			name = scan.next();
			System.out.println("Their last name? ");
			name1 = scan.next();
			System.out.println("Their yearly Salary? ");
			salary = scan.nextDouble();
			scan.nextLine();
			System.out.println("How much cash do they have on hand? ");
			cashOnHand = scan.nextDouble();
			list1.addPatron(name, name1, salary, cashOnHand);

			if(pat1 == null)
			{
				//returnPatron indexed at 0
				//patron's indexed at 1
				pat1 = list1.returnPatron(0);

				System.out.println("Welcome to the bank, " + name);
			}
			else if(pat2 == null)
			{
				pat2 = list1.returnPatron(1);
				System.out.println("Welcome to the bank, " + name);
			}
			else if(pat3 == null)
			{
				pat3 = list1.returnPatron(2);
				System.out.println("Welcome to the bank, " + name);
			}
			else if(pat4 == null)
			{
				pat4 = list1.returnPatron(3);
				System.out.println("Welcome to the bank, " + name);
			}
			else if(pat5 == null)
			{
				pat5 = list1.returnPatron(4);
				System.out.println("Welcome to the bank, " + name);
			}
			else
			{
				System.out.println("The line at the bank is full already!");
			}
			mainMenu();
			
		}
		//Done
		else if(choice.equals("c"))
		{
				System.out.println("Type the full name of the patron you want to remove? ");
				nameFull = scan1.nextLine();
				
				if(pat1 == null && pat2 == null && pat3 == null && pat4 == null && pat5 == null)
				{
					System.out.println("There is no patron with that name");
					mainMenu();
				}
				if(nameFull.equalsIgnoreCase(pat1.getFullName()))
				{
					System.out.println(pat1.getFullName() + " left the bank");
					//Removes it from the list
					list1.removePatron(pat1.getFullName());
					//Actually sets the object to null
					pat1 = null;
				}
				else if(nameFull.equalsIgnoreCase(pat2.getFullName()))
				{
					System.out.println(pat2.getFullName() + " left the bank");
					list1.removePatron(pat2.getFullName());
					pat2 = null;
				}
				else if(nameFull.equalsIgnoreCase(pat3.getFullName()))
				{
					System.out.println(pat3.getFullName() + " left the bank");
					list1.removePatron(pat3.getFullName());
					pat3 = null;
				}
				else if(nameFull.equalsIgnoreCase(pat4.getFullName()))
				{
					System.out.println(pat4.getFullName() + " left the bank");
					list1.removePatron(pat4.getFullName());
					pat4 = null;
				}
				else if(nameFull.equalsIgnoreCase(pat5.getFullName()))
				{
					System.out.println(pat5.getFullName() + " left the bank");
					list1.removePatron(pat5.getFullName());
					pat5 = null;
					
				}
				else{System.out.println("There is no one at the bank with that name");}
				
			mainMenu();

		}
		
		else if(choice.equals("d"))
		{
			if(pat1 == null && pat2 == null && pat3 == null && pat4 == null && pat5 == null)
			{
				System.out.println("There is no one in the bank");
				mainMenu();
			}
			
			System.out.println("Type the full name of the patron you want: ");
			fullName = scan1.nextLine();
			
			if(list1.searchPatron(fullName) == pat1){patronMenu(pat1);}
			else if(list1.searchPatron(fullName) == pat2){patronMenu(pat2);}
			else if(list1.searchPatron(fullName) == pat3){patronMenu(pat3);}
			else if(list1.searchPatron(fullName) == pat4){patronMenu(pat4);}
			else if(list1.searchPatron(fullName) == pat5){patronMenu(pat5);}
			else
			{
				System.out.println("There is no patron with that name");
				mainMenu();
			}
		}
		
		else
		{
			System.out.println("Thank you for coming.");
			System.exit(1);
		}
		return choice;
	}
	//Strictly receives input and relays it to patronChoices
	public static void patronMenu(BankPatron pat)
	{
		System.out.println("What did you want to do with " + pat.getFullName());
		System.out.println("a. Add New Account");
		System.out.println("b. Close Account");
		System.out.println("c. Get Paid");
		System.out.println("d. Apply Interest to Accounts");
		System.out.println("e. Make Deposit");
		System.out.println("f. Make Withdraw");
		System.out.println("g. Return to Main Menu");
		do 
		{
			choice1 = scan.next();
			while(!choice1.equals("a") && !choice1.equals("b") && !choice1.equals("c") && !choice1.equals("d")
					&& !choice1.equals("e") && !choice1.equals("f") && !choice1.equals("g"))
				{
					System.out.println("Invalid input");
					System.out.println("a. Add New Account");
					System.out.println("b. Close Account");
					System.out.println("c. Get Paid");
					System.out.println("d. Apply Interest to Accounts");
					System.out.println("e. Make Deposit");
					System.out.println("f. Make Withdraw");
					System.out.println("g. Return to Main Menu");
				}
		}
		while(!choice1.equals("a") && !choice1.equals("b") && !choice1.equals("c") && !choice1.equals("d")
					&& !choice1.equals("e") && !choice1.equals("f") && !choice1.equals("g"));
		patronChoices(pat);
			
	}
	
	static public String accountMenu()
	{
		String choice;
		System.out.println("a. Checkings");
		System.out.println("b. Savings");
		System.out.println("c. CD");
		System.out.println("d. Money Market");
		System.out.println("e. IRA");
		choice = scan.next();
		return choice;
	}
	//Takes input from patronMenu to run
	static public void patronChoices(BankPatron pat)
	{
		int i;
		double rate;
		String input;
		
			if(choice1.equals("a"))
			{
				System.out.println("Which account type did you want? ");
				input = accountMenu();
				System.out.println("Please input the interest rate");
				rate = scan.nextDouble();
				chooseAccount(pat,  rate, input);
			}
			else if(choice1.equals("b"))
			{
				System.out.println("Which account (1 or 2) did you want to remove? ");
				i = scan.nextInt();
				pat.removeAccount(i);
			}
			else if(choice1.equals("c")){pat.getPaycheck();}
			else if(choice1.equals("d")){addInterest(pat);}
			else if(choice1.equals("e")){doDeposit(pat);}
			else if(choice1.equals("f")){doWithdraw(pat);}
			else if(choice1.equals("g")){mainMenu();}
			patronMenu(pat);
			
		
		
	}
	//Asks for specific account to make 
	static public void chooseAccount(BankPatron pat, double rate, String choice)
	{
		AccountType type;
		if(choice.equals("a"))
		{
			type = AccountType.Checking;
			pat.makeAccount(rate, type);
		}
		else if(choice.equals("b"))
		{
			type = AccountType.Savings;
			pat.makeAccount(rate, type);		
		}
		else if(choice.equals("c"))
		{
			type = AccountType.CD;
			pat.makeAccount(rate, type);
		}
		else if(choice.equals("d"))
		{
			type = AccountType.MoneyMarket;
			pat.makeAccount(rate, type);
		}
		else
		{
			type = AccountType.IRA;
			pat.makeAccount(rate, type);
		}
		patronMenu(pat);
	}
	static public void addInterest(BankPatron pat)
	{
		if(pat.account1 != null && pat.account2 != null)
		{
			pat.account1.applyInterest();
			pat.account2.applyInterest();
		}
		else if(pat.account1 != null){pat.account1.applyInterest();}
		else{System.out.println("There is no account to add interest to");}
	}
	//Deposits money for whichever selected patron
	static public void doDeposit(BankPatron pat)
	{
		int input;
		double choice;
		
		System.out.println("Which account (1 or 2) would you like to deposit to? ");
		input = scan.nextInt();
		System.out.println("How much would you like to deposit? ");
		choice = scan.nextDouble();
		
		if(pat.makeDeposit(choice, input) == true){System.out.println("Deposit Made.");}
		else if(pat.makeDeposit(choice,  input) == false){System.out.println("Patron does not have enough cash on hand!");}
	}
	//Withdraws money for whichever selected patron
	static public void doWithdraw(BankPatron pat)
	{
		int input;
		double choice;
		System.out.println("Which account (1 or 2) would you like to deposit to? ");
		input = scan.nextInt();
		System.out.println("How much would you like to withdraw? ");
		choice = scan.nextDouble();
		
		if(pat.makeWithdraw(choice, input) == true){System.out.println("Withdrawal was succesful");}
		else if(pat.makeWithdraw(choice, input) == false){System.out.println("The withdrawal was unsuccesful");}
	}

}
