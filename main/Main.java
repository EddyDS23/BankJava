package main;

import models.DebitCard;
import models.Account;
import models.Client;
import utils.AccountUtils;

public class Main {

	public static void main(String[]args) {
		
		Client client = new Client("Mario","Martinez","10","55502191","mario@gmail.com");
		
		Account account = new Account(AccountUtils.AccountType.AHORRO,client);
	
		DebitCard dc = new DebitCard("Banamex",100.00,account);
		
		System.out.println(dc.getExpireDateWithFormat());
		System.out.println(dc.getBalance());
		
		System.out.println(account.getClient().getName());
	}
	
}
