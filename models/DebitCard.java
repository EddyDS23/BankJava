package models;

public class DebitCard extends Card{


	
	public DebitCard(String bankName, Account account) {
		super(bankName,account);
	}

	public double getBalance() {
		return getAccount().getBalance();
	}

	
	public boolean depositByCard(double amount) {
		return getAccount().deposit(amount);
	}
	
	public boolean withDrawByCard(double amount) {
		return getAccount().withDraw(amount);
	
	}
	
	
	
	
}
