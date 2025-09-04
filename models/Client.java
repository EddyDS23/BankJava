package models;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person{

	private String number;
	private String email;
	private List<Account> accounts = new ArrayList<>();
	
	
	public Client(String name, String lastname, String age, String number, String email) {
		super(name, lastname, age);
		this.number = number;
		this.email =email;
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Account> getAccounts(){
		return accounts;
	}
	
}
