package models;

import java.util.ArrayList;
import java.util.List;

import utils.AccountUtils;


public class Bank {

	private List<Client> clients;
	private List<Account> accounts;
	private List<Card> cards;
	
	public Bank() {
		this.clients = new ArrayList<>();
		this.accounts = new ArrayList<>();
		this.cards = new ArrayList<>();
	}
	
	
	public Client registerUser(String name, String lastname, String age, String number, String email) {
	
		if(searchClientByEmail(email)) {
			return null;
		}
		
		Client client = new Client(name, lastname, age, number, email);
		
		clients.add(client);
		
		return client;
	}
	
	public Client getCurrentUser(String email) {
		for(Client c : clients) {
			if(c.getEmail().equals(email)) {
				return c;
			}
		}
		return null;
		
	}
	
	public boolean searchClientByEmail(String email) {
		for(Client c : clients) {
			if(c.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}
		
	
	
	//Metodos para la cuenta
	public Account registerAccountToClient(AccountUtils.AccountType accountType,Client client) {
		Account account = new Account(accountType,client);
		accounts.add(account);
		return account;
	}
	
	
	public Account getAccountByNumber(String numberAccount) {
		for(Account account : accounts) {
			if(account.getNumberAccount().equals(numberAccount)) {
				return account;
			}
		}
		return null;	
	}
	
	
	//Metodos para las tarjetas de debito
	public Card registerDebitCardFromAccount(String bankName, Account account) {
		if(account == null) {
			return null;
		}
		
		DebitCard debitcard = new DebitCard(bankName, account);
		
		cards.add(debitcard);
		account.addCard(debitcard);
		return debitcard;
	}
	
	public DebitCard getDebitCard(String numberDebitCard) {
		Card card = getCardByNumber(numberDebitCard);
		
		if(card instanceof DebitCard) {
			return (DebitCard) card;
		}
		
		return null;
	}
	
	
	public boolean payWithDebitCard(String numberDebitCard, String pin ,double amount) {
		DebitCard debitCard = getDebitCard(numberDebitCard);
		
		if(debitCard == null || !debitCard.getPin().equals(pin) || debitCard.getAccount().getBalance() < amount) {
			return false;
		}
		
		debitCard.getAccount().withDraw(amount);
		return true;	
	}
	
	//Metodos para la tarjeta de credito

	public Card registerCreditCardFromAccount(String bankName,Account account, double limitCredit) {
		if(account == null) {
			return null;
		}
		
		CreditCard creditcard = new CreditCard(bankName,account,limitCredit);
		
		cards.add(creditcard);
		account.addCard(creditcard);
		return creditcard;	
	}
	
	public CreditCard getCreditCard(String numberCreditCard) {
			Card card = getCardByNumber(numberCreditCard);
		
			if(card instanceof CreditCard) {
				return (CreditCard) card;
			}
		
			return null;
	}
	
	
	public boolean payWithCreditCard(String numberCreditCard, String pin, double amount) {
		CreditCard creditCard = getCreditCard(numberCreditCard);
		
		if(creditCard == null || !creditCard.getPin().equals(pin) || creditCard.getCurrentDebt() + amount > creditCard.getLimitCredit() ) {
			return false;
		}
		
		creditCard.buy(amount);
		return true;
		
	}
	

	
	
	//Metodos para transacciones 
	public boolean transfer(String fromAccountNumber, String toFromAccount, double transferAmount) {
		Account fromAccount  = getAccountByNumber(fromAccountNumber);
		Account toAccount = getAccountByNumber(toFromAccount);
		
		if(fromAccount == null || toAccount == null || fromAccount.getBalance() < transferAmount || transferAmount <= 0) {
			return false;
		}
		
		fromAccount.withDraw(transferAmount);
		toAccount.deposit(transferAmount);
		return true;
		
	}
	
	public boolean depositToAccount(String toAccountNumber, double depositAmount) {
		Account toAccount = getAccountByNumber(toAccountNumber);
		if(toAccount == null || depositAmount <= 0) {
			return false;
		}
		
		toAccount.deposit(depositAmount);
		return true;
		
	}
	
	//Operacion sin tarjeta
	public boolean withDrawToAccount(String toAccountNumber, String nip, double withDrawAmount) {
		
		Account toAccount = getAccountByNumber(toAccountNumber);
		if(toAccount == null || toAccount.getBalance() < withDrawAmount) {
			return false;
		}
		
		if(!toAccount.getPin().equals(nip)) {
			return false;
		}
		
		toAccount.withDraw(withDrawAmount);
		return true;
		
	}
	
	
	//Metodos genericos
	public  Card getCardByNumber(String numberCard) {
		for(Card c: cards) {
			if(c.getNumberCard().equals(numberCard)) {
				return c;
			}
			
		}
		return null;
	}
	
	
}
