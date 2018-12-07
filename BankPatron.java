package ATM;

public class BankPatron {
	String firstName;
	String lastName;
	double salary;
	double cashOnHand;
	public BankAccount account1;
	public BankAccount account2;
	public AccountType type;
	
	
	//Default constructor
	BankPatron()
	{
		firstName = "Jerry";
		lastName = "Smith";
		salary = 40000;
		cashOnHand = 10;
		account1 = null;
		account2 = null;
	}
	//Regular constructor
	BankPatron(String f, String l, double s, double c)
	{
		firstName = f;
		lastName = l;
		salary = s;
		cashOnHand = c;
	}
	public String getFullName()
	{
		return firstName + " " + lastName;
	}
	public double getCash()
	{
		return cashOnHand;
	}
	public double getSalary()
	{
		return salary;
	}
	public double getPaycheck()
	{
		double paycheck = salary / 26;
		cashOnHand += paycheck;
		return cashOnHand;
	}
	//returns type of BankAccount
	public BankAccount getAccountType(int i) {
		if(i == 1 && account1 != null)
		{
			return account1;
		}
		else if(i == 2 && account2 != null)
		{
			return account2;
		}
		else
			return null;
	}
	public boolean makeDeposit(double amount, int j)
	{
		if(amount <= cashOnHand)
		{
			if(getAccountType(j) == account1)
			{
				cashOnHand -= amount;
				account1.deposit(amount);
				return true;
			}
			else if(getAccountType(j) == account2)
			{
				cashOnHand -= amount;
				account2.deposit(amount);
				return true;
			}
			else
			{
				System.out.println("No account of that selection");
				return false;
			}
			
		}
		else
		{
			return false;
		}
	
	}
	public boolean makeWithdraw(double amount, int j)
	{
		if(getAccountType(j) == account1)
		{
			account1.withdraw(amount);
			cashOnHand += amount;
			return true;
		}
		else if(getAccountType(j) == account2)
		{
			account2.withdraw(amount);
			cashOnHand += amount;
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public boolean makeAccount(double rate, AccountType type)
	{
		if(account1 == null)
		{
			account1 = new BankAccount(null, null, rate, type);
			System.out.println("Account successfully added!");
			return true;
		}
		else if(account2 == null)
		{
			account2 = new BankAccount(null, null, rate, type);
			System.out.println("Account successfully added!");
			return true;
		}
		else
		{
			System.out.println("Account could not be added");
			return false;
		}
	}
	//Removes the account chosen by integer 
	public boolean removeAccount(int i)
	{
		if(i == 1)
		{
			if(account1 != null)
			{
				account1 = null;
				System.out.println("Account succesfully removed!");
				return true;
			}
			else
			{
				System.out.println("Account could not be removed");
				return false;
			}
		}
		else if(i == 2)
		{
			if(account1 != null)
			{
				account1 = null;
				System.out.println("The account was succesfully removed");
				return true;
			}
			else
			{
				System.out.println("The account could not be removed");
				return false;
			}
		}
		else
		{
			System.out.println("There was no account of the choice to remove");
			return false;
		}
		
	}
	
	

}
