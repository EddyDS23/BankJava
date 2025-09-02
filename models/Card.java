package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import utils.CardUtils;

public class Card {

	private String numberCard;
	private String ccv;
	private String pin;
	private String bankName;
	private LocalDate issueDate;
	private LocalDate expirationDate;
	private boolean status;
	private Account account;
	
	public Card(String bankName,Account account) {
		this.numberCard = CardUtils.generateNumberCard();
		this.ccv = CardUtils.generateCCV();
		this.pin = CardUtils.generatePIN();
		this.bankName = bankName;
		this.issueDate = CardUtils.getDateToday();
		this.expirationDate = CardUtils.expireDate();
		this.status = true;	
		this.account = account;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
	public void isActive() {
		this.status = true;
	}
	
	public void cardBlocked() {
		this.status = false;
	}

	public String getNumberCard() {
		return numberCard;
	}

	public String getCcv() {
		return ccv;
	}

	public String getBankName() {
		return bankName;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	
	public String getIssueDateWithFormat() {
		return this.issueDate.format(DateTimeFormatter.ofPattern("MM/yy"));
	}
	
	public String getExpireDateWithFormat() {
		return this.expirationDate.format(DateTimeFormatter.ofPattern("MM/yy"));
	}
	
	public Account getAccount() {
		return account;
	}
	
	
	
	
}
