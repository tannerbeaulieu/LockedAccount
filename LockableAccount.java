// COURSE: CSCI1620
// TERM: Fall 2019
//
// NAME: Tanner Beaulieu
// RESOURCES: I referenced the lab source files and the book for reference

/**
 * Emulates a simple account with basic information and the ability to be locked and unlocked. An unlocked account shows
 * all information while a locked account will hide many of the details. This demonstrates how encapsulation can be used
 * to implement information hiding; as class designers we have full control over what information can be accessed, how
 * it is accessed, and how it is altered.n
 */
public class LockableAccount
{

	//Class data members go here
	
	// the maximum value an account number can have
	private static int ACCOUNT_NUM_MAX; 
	// the minimum value an account number can have
	private static int ACCOUNT_NUM_MIN;
	// the account number for the account
	private int accountNumber;
	// the user's email address
	private java.lang.String emailAddress;
	// whether the account is locked or not
	private boolean locked; 
	//any notification the user may have; if this value is null there there is no notification
	private java.lang.String notification;
	// the user's password
	private java.lang.String password;
	// the user's username
	private java.lang.String userName;
	
	//Constructor goes here
	
	/**
	 * constructor used to create a new LockableAccount.
	 * Any String is valid for userName, emailAddress, and password. 
	 * The accountNumber is a controlled value and should be set using the same rules as the setAccount method.
	 * A newly created account will be locked.
	 * @param userNameIn - Account user name
	 * @param accountNumberIn - Requested account number for the account
	 * @param emailAddressIn - Account email address
	 * @param passwordIn - Account password
	 */
	public LockableAccount(java.lang.String userNameIn, int accountNumberIn, java.lang.String emailAddressIn, java.lang.String passwordIn)
	{
		userName = userNameIn; 
		emailAddress = emailAddressIn;
		password = passwordIn;
		if (accountNumberIn >= ACCOUNT_NUM_MIN && accountNumberIn <= ACCOUNT_NUM_MAX)
			
			accountNumber = accountNumberIn;
		
		else
			accountNumber = -1;
		
		
	}
	
	/**
	 * Attempts to set the account number to the requested value. 
	 *  If the passed value is between the account minimum and maximum inclusive, accountNumber will be set to the passed value.
	 *  If the account number is not within the valid range, accountNumber will be set to -1 to denote an invalid account number.
	 * @param accountNumberIn - The account number requested
	 */
	public void setAccountNumber(int accountNumberIn)
	{
		
		if (accountNumberIn >= ACCOUNT_NUM_MIN && accountNumberIn <= ACCOUNT_NUM_MAX)
		
			accountNumber = accountNumberIn;
		
		else
			accountNumber = -1;
		
	}
	
	/**
	 * locks the account
	 */
	public void lock()
	{
		locked = true;
	}
	
	/**
	 * Attempts to unlock the account with the passed password String.
	 * Only if the passed password matches the account's password the account will be unlocked by setting locked to false. 
	 * Returns true if successfully unlocked, false otherwise. If the password passed is null it is treated the same as an incorrect password.
	 * @param passwordIn
	 * @return Whether or not the account is unlocked
	 */
	public boolean unlock(java.lang.String passwordIn)
	{
		if (password.equals(passwordIn))
		{
			locked = false;
		}
		else 
			locked = true;
		return locked;
			
	}

	/**
	 * Sets the notification of the account.
	 * @param notificationIn - The notification String.
	 */
	public void addNotification(java.lang.String notificationIn)
	{
		notification = notificationIn;
	}
	
	/**
	 * Returns the account's email address; the String returned depends on the locked state of the account.
	 *  If the account is not locked it will return the emailAddress as it is stored. If the account is locked 
	 *  the String will be the first character of the emailAddress with the remainder of the characters in the emailAdress as asterisks *.
	 * @return The full or partially hidden email address of the account
	 */
	public java.lang.String getEmailAddress()
	{
		String result = "";
		int length = emailAddress.length();
		
		if (!locked)
			result = emailAddress;
		else
		{
			for(int i = 1; i < length; i++)
			{
				//char asterisk = emailAddress.charAt(i);
				
				
				
			}
			
		}
		return result;
			
	}
	
	/**
	 * Returns the account number; the String returned depends on the locked state of the account and if the account number is valid.
	 *  If the account number is invalid returns the String "Invalid account number,
	 *  please contact customer support" whether or not the account is unlocked. 
	 * If the account number is valid and the account is unlocked it will return the account number as a String;
	 *  if the account is locked it will return asterisks in place of the digits.
	 * @return The notification String
	 */
	public java.lang.String getAccountNumberString()
	{
		
	}
	
	/**
	 * Returns the notification; the String returned depends on the locked state of the account and if there is a notification. 
	 * If there is no notification returns the String "No notification". 
	 * If there is a notification and the account is unlocked it will return the notification. 
	 * If there is a notification and the account is locked it will return the String "You have a notification".
	 * @return The notification string
	 */
	public java.lang.String getNotification()
	{
		String results = "";
		if (!locked)
		{
			if (notification == null)
				results = "No notification";
			if (notification != null)
				results = notification;	
		}
		if (locked == true && notification != null)
			results = "You have a notification";
		return results;
	}
	//Do not change toString	
	/**
	 * Returns the information of the account; the String returned depends on the locked state of the account.
	 * If the account is unlocked it will clear the notification by setting it to null. Uses the getter methods
	 * for account number, email address, and notification to ensure the appropriate values are displayed
	 * depending on the locked state of the account.
	 * @return A String representing this account
	 */
	public String toString()
	{
		String out;
		
		if (locked)
		{
			out = "***LOCKED ACCOUNT***";
		}
		else
		{
			out = "***UNLOCKED ACCOUNT***";
		}
		out += String.format("\nUser Name: %s\nAccount Number: %s\nEmail Address: %s\n%s",
				userName, getAccountNumberString(), getEmailAddress(), getNotification());
		
		if (!locked)
		{
			notification = null;
		}
		
		return out;
	}
	
}
