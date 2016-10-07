package TestClass;

import Main.Account;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Exceptions.InsufficientFundsException;



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
	public void testAccount() {
		int id = 1122;
		double balance = 20000;
		double annualInterestRate = 4.5;
		
		Account testAccount = new Account(id, balance);
		testAccount.setAnnualInterestRate(annualInterestRate);
		double MonthlyInterestRate = annualInterestRate / 12;
		assertEquals(testAccount.getAnnualInterestRate(),annualInterestRate , 4.5);
		assertEquals(testAccount.getMonthlyInterestRate(), MonthlyInterestRate, 0.375);
		assertEquals(testAccount.getId(),id);
		
		
		System.out.println("Balance: $" + testAccount.getBalance());
		System.out.println("Monthly Interest Rate: " +testAccount.getMonthlyInterestRate());
		System.out.println("Date Created: " + testAccount.getDateCreated());
		
		
		
	}
	@Test
	public final void testWithdraw() throws InsufficientFundsException {
		int id = 1122;
		double balance = 20000;
		double withdraw = 2500;
		Account testWithdraw = new Account(id, balance);
		testWithdraw.withdraw(withdraw);
		System.out.println("You have withdrew $" + withdraw);
		double balanceafterwithdraw = balance - withdraw;
		assertEquals(testWithdraw.getBalance(),balanceafterwithdraw,17500);
		System.out.println("Your balance now is $" + balanceafterwithdraw);
	}
	
	@Test
	public final void testDeposit() throws InsufficientFundsException {
		int id = 1122;
		double balance = 20000;
		double deposit = 3000;
		Account testDeposit = new Account(id, balance);
		testDeposit.deposit(deposit);
		System.out.println("You have deposited $" + deposit);
		double balanceafterdeposit = balance + deposit;
		assertEquals(testDeposit.getBalance(),balanceafterdeposit,20500);
		System.out.println("Your balance now is $" + balanceafterdeposit);
	}
	


	
	@Test(expected = InsufficientFundsException.class)
	public final void testException() throws InsufficientFundsException{
		
		Account testWithdraw = new Account();
		double amount = 100;
		InsufficientFundsException FundsExcep = new InsufficientFundsException(amount);
		
		testWithdraw.setId(1);
		testWithdraw.setBalance(1000);
		FundsExcep.getAmount();
		
		
	testWithdraw.withdraw(1100);
		
	}

}
