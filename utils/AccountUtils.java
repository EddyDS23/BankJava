package utils;

import java.util.Random;

public class  AccountUtils {
	
	public static final Random random = new Random();
	
	public enum AccountType{
		AHORRO,
		CORRIENTE,
		NOMINA,
		CREDITO,
	}
	
	
	public enum AccountState{
		ACTIVO,
		BLOQUEADO,
		CERRADO
	}
	
	public static String generateNumberAccount() {
		StringBuilder numberAccount = new StringBuilder();
		
		for(int i = 1; i <12; i++) {
			numberAccount.append(random.nextInt(10));
		}
		
		return numberAccount.toString();
		
	}
	
	public static String generatePIN() {
		StringBuilder pin = new StringBuilder();
		
		for(int i = 1; i <= 4; i++) {
			pin.append(random.nextInt(10));
		}
		
		return pin.toString();
	}
	
	
}

