package utils;

import java.util.function.Predicate;
import java.util.Scanner;

public class inputUtils {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static String askInput(String message,Predicate<String> validator, String msgError) {
		String input;
		while(true) {
			System.out.print(message);
			input = sc.nextLine();
			
			if(validator.test(input)) {
				return input;	
			}else {
				System.out.println(msgError);
				ThreadUtils.sleep(2000);
				
			}	
			
		}
		
	}
	
	public static String askInputSpecial(String message,Predicate<String> validator,Predicate<Integer> validator_two, String msgError) {
		String input;
		while(true) {
			System.out.print(message);
			input = sc.nextLine();
			
			if(validator.test(input) && validator_two.equals(input)) {
				return input;	
			}else {
				System.out.println(msgError);
				ThreadUtils.sleep(2000);
				
			}	
			
		}
		
	}
	
}
