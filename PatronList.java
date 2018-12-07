package ATM;

public class PatronList {
	private BankPatron pat1;
	private BankPatron pat2;
	private BankPatron pat3;
	private BankPatron pat4;
	private BankPatron pat5;
	
	PatronList()
	{
		pat1 = null;
		pat2 = null;
		pat3 = null;
		pat4 = null;
		pat5 = null;
	}
	public boolean addPatron(BankPatron stud)
	{
		if(pat1 == null)
		{
			stud = new BankPatron();
			return true;
		}
		else if(pat2 == null)
		{
			stud = new BankPatron();
			return true;
		}
		else if(pat3 == null)
		{
			stud = new BankPatron();
			return true;
		} 
		else if(pat4 == null)
		{
			stud = new BankPatron();
			return true;
		}
		else if(pat5 == null) 
		{
			stud = new BankPatron();
			return true;
		}
		else 
		{
			return false;
		}
	}
	public boolean addPatron(String first, String last, double sal, double cashHand)
	{
		if(pat1 == null)
		{
			pat1 = new BankPatron(first, last, sal, cashHand);
			return true;
		}
		else if(pat2 == null)
		{
			pat2 = new BankPatron(first, last, sal, cashHand);
			return true;
		}
		else if(pat3 == null)
		{
			pat3 = new BankPatron(first, last, sal, cashHand);
			return true;
		} 
		else if(pat4 == null)
		{
			pat4 = new BankPatron(first, last, sal, cashHand);
			return true;
		}
		else if(pat5 == null) 
		{
			pat5 = new BankPatron(first, last, sal, cashHand);
			return true;
		}
		else 
		{
			return false;
		}
	}
	public BankPatron returnPatron(int i) 
	{
		switch(i)
		{
		case 0:
			return pat1;
		case 1:
			return pat2;
		case 2:
			return pat3;
		case 3:
			return pat4;
		case 4:
			return pat5;
		default:
			return null;	
		}
	}
	public BankPatron searchPatron(String fullName1)
	{
		String fullName = fullName1;
		if(pat1 != null) 
		{
			if(pat1.getFullName().equalsIgnoreCase(fullName))
			{
				return pat1;
			}
		}
		if(pat2 != null) 
		{	
		    if(pat2.getFullName().equalsIgnoreCase(fullName))
			{
				return pat2;
			}
		}
		if(pat3 != null)
		{
			if(pat3.getFullName().equalsIgnoreCase(fullName))
			{
				return pat3;
			}
		}
		if(pat4 != null)
		{
			if(pat4.getFullName().equalsIgnoreCase(fullName))
			{
				return pat4;
			}
		}
		if(pat5 != null)
		{
			if(pat5.getFullName().equalsIgnoreCase(fullName))
			{
				return pat5;
			}
		}
		return null;
		
		
		
	}
	public boolean removePatron(String fullName1)
	{
		//Changes the value of the select patron to null
		//Essentially removing them from the bank
		BankPatron temp = searchPatron(fullName1);
		if(temp.getFullName().equalsIgnoreCase(pat1.getFullName()))
		{
			pat1 = null;
			pat1 = null;
			return true;
		}
		else if(temp.getFullName().equalsIgnoreCase(pat2.getFullName()))
		{
			pat2 = null;
			return true;
		}
		else if(temp.getFullName().equalsIgnoreCase(pat3.getFullName()))
		{
			pat3 = null;
			return true;
		}
		else if(temp.getFullName().equalsIgnoreCase(pat4.getFullName()))
		{
			pat4 = null;
			return true;
		}
		else if(temp.getFullName().equalsIgnoreCase(pat5.getFullName()))
		{
			pat5 = null;
			return true;
		}
		else
		{
			return false;
		}
	}
	public String returnInfo(BankPatron pat)
	{
		String s, s1, s2;
		if(pat != null)
		{
			System.out.print(pat.getFullName());
			if(pat.account1 != null)
			{
				s = (" " + pat.account1.getType() + " "  + pat.account1.getAccountNum() + " Balance: " + pat.account1.checkBalance() 
				+ " Rate: " + pat.account1.getRate());
				if(pat.account2 != null)
				{
					s1 = (pat.account2.getType() + " "  + pat.account2.getAccountNum() + " Balance: " + pat.account2.checkBalance() 
					+ " Rate: " + pat.account2.getRate());
					return s + System.lineSeparator() + s1;
				}
				else 
				{
					return s;
				}
			
			}
		}
		s2 = ("");
		return s2;
	}
	
	
	


}
