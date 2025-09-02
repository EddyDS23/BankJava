package models;

import java.time.LocalDate;
import utils.CardUtils;

public class CreditCard extends Card{
	
	//private static final double interestRate = 0.30;
	
	private double limitCredit;
	private double currentDebt=0;
	private double balanceFavor=0;
	private int courtDay;
	private int paymentDay;
	
	public CreditCard(String bankName,Account account,double limitCredit) {
		super(bankName,account);
		this.limitCredit = limitCredit;
		this.courtDay = CardUtils.getCourtDate();
		this.paymentDay = CardUtils.getPaymentDate();
		
	}
	
	
	public double getCurrentDebt() {
		return currentDebt;
	}
	
	public double getLimitCredit() {
		return limitCredit;
	}
	
	public boolean buy(double amount) {
		if((currentDebt + amount) <= limitCredit ) {
			currentDebt += amount - balanceFavor;
			return true;
		}
		return false;
		
	}
	
	public boolean payDebt(double amount) {
		if(amount < 0) {
			return false;
		}
		
		if(amount > currentDebt) {
			currentDebt = 0;
			balanceFavor = (currentDebt - amount)*(-1);
			return true;
		}
		
		currentDebt-=amount;
		return true;
		
	}
	
	public LocalDate getCourtDate(LocalDate today) {
		return LocalDate.of(today.getYear(), today.getMonth(),courtDay);
	}
	
	public LocalDate getPaymentDate(LocalDate today) {
		return LocalDate.of(today.getYear(), today.getMonth(),paymentDay);
	}
	
}
