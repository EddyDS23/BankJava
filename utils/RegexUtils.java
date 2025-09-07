package utils;

public class RegexUtils {

	public static boolean checkNumber(String number) {
		return number.matches("^[0k-9]{8,15}$");
	}
	
	public static boolean checkAge(String age) {
		return age.matches("^[0-9]{2}$");
	}
	
	public static boolean checkEmail(String email) {
		return email.matches("^[a-zA-Z0-9.-]+@[a-zA-Z]+\\.[a-z]{2,}$");
	}
	
	public static boolean checkName(String name) {
		return name.matches("^[\\p{L} ]+$");
	}
	
	public static boolean checkLastname(String lastname) {
		return lastname.matches("^[\\p{L} ]+$");
	}
	
	public static boolean checkPin(String pin) {
		return pin.matches("^[0-9]{4}$");
	}
	
	public static boolean checkNumberAccount(String numberAccount) {
		return numberAccount.matches("^[0-9]{11}");
	}

	public static boolean checkNumberCardDebit(String numberCardDebit) {
		return numberCardDebit.matches("^[0-9]{16}$");
	}
	
	public static boolean checkAmount(String amount) {
		return amount.matches("^\\d+(\\.\\d{1,2)?$");
	}
	
}
