package models;

import java.util.ArrayList;
import java.util.List;
import utils.AccountUtils;



public class Account {

	private String numberAccount;
	private AccountUtils.AccountType accountType;
	private AccountUtils.AccountState accountStatus;
	private double balance;
	private Client client;
	private String pinAccount;
	private List<Card> cards = new ArrayList<>();
	
	
	public Account(AccountUtils.AccountType accountType,Client client) {
		this.numberAccount = AccountUtils.generateNumberAccount();
		this.accountType = accountType;
		this.accountStatus = AccountUtils.AccountState.ACTIVO;
		this.pinAccount = AccountUtils.generatePIN();
		this.client = client;
	}
	
	public String getNumberAccount() {
		return numberAccount;
	}
	
	public AccountUtils.AccountType getAccountType() {
		return accountType;
	}
	
	public AccountUtils.AccountState getAccountStatus(){
		return accountStatus;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String getPin() {
		return pinAccount;
	}
	
	public void setPin(String pinNew) {
		this.pinAccount = pinNew;
	}
	
	public boolean deposit(double amount) {
		if(amount < 1) {
			return false;
		}
		
		balance += amount;
		return true;
	}
	
	public boolean withDraw(double amount) {
		if(amount > balance) {
			return false;
		}
		
		balance -= amount;
		return true;
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public Client getClient() {
		return client;
	}
}
