package utils;

import java.util.function.Predicate;
import java.util.Scanner;

public class inputUtils {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static String askInput(String message,Predicate<String> validator) {
		String input;
		while(true) {
			System.out.print(message);
			input = sc.nextLine();
			
			if(validator.test(input)) {
				return input;	
			}
			
			
			
		}
		
	}
	
}
