package utils;

public class RegexUtils {

	public static boolean checkNumber(String number) {
		return number.matches("^[0-9]{8,15}$");
	}
	
	public static boolean checkEmail(String email) {
		return email.matches("^[a-zA-Z0-9.-]+@[a-zA-Z]+\\.[a-z]{2,}$");
	}
	
}
