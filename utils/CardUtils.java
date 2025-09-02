package utils;

import java.util.Random;

import java.time.LocalDate;
import java.time.YearMonth;


public class CardUtils {

	private static final Random random = new Random();
	
	public static String generateNumberCard() {
		
		StringBuilder cardNumber = new StringBuilder();
		
		for(int i = 0; i < 16; i++) {
			cardNumber.append(random.nextInt(10));
		}
		
		return cardNumber.toString();
		
	}
	
	public static String generateCCV() {
		StringBuilder ccv = new StringBuilder();
		
		for(int i = 1; i <= 3; i++) {
			ccv.append(random.nextInt(10));
		}
		
		return ccv.toString();
	}
	
	public static String generatePIN() {
		StringBuilder pin = new StringBuilder();
		
		for(int i = 1; i <= 4; i++) {
			pin.append(random.nextInt(10));
		}
		
		return pin.toString();
	}
	
	public static LocalDate getDateToday() {
		return LocalDate.now();
	}
	
	public static LocalDate expireDate() {
		  YearMonth expirationYM =  YearMonth.now().plusYears(5);
		  
		  return expirationYM.atEndOfMonth();
	}
	
	public static Integer getCourtDate() {
		return LocalDate.now().plusDays(30).getDayOfMonth();
	}
	
	public static Integer getPaymentDate() {
		 return LocalDate.now().plusDays(55).getDayOfMonth();
	}
	
	
	
}
