package Main;

import java.util.Date;
import Exceptions.InsufficientFundsException;


public class Account {
	
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	
	public Account() {
		id = 0;
		balance = 0;
		annualInterestRate = 0;
		this.dateCreated = new Date();
	}
	
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = 0;
		this.dateCreated = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	
	public double getMonthlyInterestRate() {
		return (annualInterestRate / 12);
	}
	
	
	public void withdraw(double amount) throws InsufficientFundsException {
		
		if (amount <= balance) {
			balance -= amount;
		} else {
			throw new InsufficientFundsException(amount);
		}
	}
	


	public void deposit(double amount) {
		balance += amount;
	}
	
	

}
