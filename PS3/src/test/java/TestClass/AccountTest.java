package TestClass;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Exceptions.InsufficientFundsException;
import Main.Account;

public class AccountTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testAccount() throws InsufficientFundsException {
		int id = 1122;
		double balance = 20000;
		double annualInterestRate = 4.5;
		double withdraw = 2500;
		double deposit = 3000;
		
		Account testAccount = new Account(id, balance);
		testAccount.setAnnualInterestRate(annualInterestRate);
		double MonthlyInterestRate = annualInterestRate / 12;
		assertEquals(testAccount.getMonthlyInterestRate(), MonthlyInterestRate, 0.375);
		
		
		testAccount.withdram(withdraw);
		System.out.println("You have withdrew $" + withdraw);
		double balanceafterwithdraw = balance - withdraw;
		assertEquals(testAccount.getBalance(),balanceafterwithdraw,17500);
		
		testAccount.deposit(deposit);
		System.out.println("You have deposited $" + deposit);
		double balanceafterdeposit = balance + deposit;
		assertEquals(testAccount.getBalance(),balanceafterdeposit,20500);
		
		System.out.println("Balance: $" + testAccount.getBalance());
		System.out.println("Monthly Interest Rate: " +testAccount.getMonthlyInterestRate());
		System.out.println("Date Created: " + testAccount.getDateCreated());
		
		
		
	}
	@Test(expected = InsufficientFundsException.class)
	public void testException() throws InsufficientFundsException{
		Account testAccount = new Account();
		
		testAccount.setBalance(1000);
		testAccount.withdram(1100);
		

	}

}
