package main;

import models.DebitCard;
import models.Account;
import models.Bank;
import models.Card;
import models.Client;
import utils.AccountUtils;
import utils.AccountUtils.AccountType;
import utils.inputUtils;
import utils.RegexUtils;
import utils.ThreadUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import interfaz.Principal;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	static Bank wachoPay = new Bank();
	
	public static void main(String[]args) {
		
		int options = 0;
		
		while(options != 4) {
			System.out.println("\n=== Bienvenido A WachoPay ====");
			System.out.println("1)Iniciar Sesion");
			System.out.println("2)Registarse");
			System.out.println("3)Operacion sin tarjeta");
			System.out.println("4)Salir");
			System.out.println("===============================");
			System.out.print("Eliga una opcion: ");
			options = sc.nextInt();
			sc.nextLine();
			
			
			switch(options) {
			case 1:
			Client client = loginMain();
			operationsLogueado(client);	
				break;
			case 2:
				registerClient();
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				
			}
			
		}
		
		
	}
	
	/*
	 * Metodo para el progreso de iniciar sesion como tambien las operaciones 
	 * */
	
	public static Client loginMain() {
		String email_check = inputUtils.askInput("Ingrese su email:", RegexUtils::checkEmail, "\nCredencial incorrecto,Ingrese denuevo\n");
		return wachoPay.getCurrentUser(email_check);
		
	}
	
	public static void operationsLogueado(Client client) {
	
		if(client == null) {
			System.out.println("\nCorreo no registrado\n");
			ThreadUtils.sleep(2000);
			return;
		}
		
		int options = 0;
		
		while(options != 2) {
			System.out.println(String.format("\n\n==== Bienvenido %s %s ======", client.getName(), client.getLastname()));
			System.out.println("1)Consultar saldo y cuenta");
			System.out.println("2)Salir");
			System.out.println("===============================");
			System.out.println("Escoga una opcion:");
			options = sc.nextInt();
			sc.nextLine();
			
			switch(options) {
			case 1:
				checkAccountBalance(client);
				break;
			case 2: 
				System.out.println("\n\nGracias por su preferencia\n");
				ThreadUtils.sleep(2000);
				break;
			}
		}
		
	}
	
	public  static void checkAccountBalance(Client client) {
		System.out.println("\n\n===== Cuentas ======");
		List<Account> accounts = new ArrayList<>();
		
		accounts = client.getAccounts();
		
		if(accounts.isEmpty()) {
			System.out.println("No hay cuentas existentes");
		}else {
			for(Account account: client.getAccounts()) {
				System.out.println(String.format("Cuenta: %s \nSaldo: %.2f \n", account.getNumberAccount(), account.getBalance()));
			}
		}
		System.out.println("=================");
	}
	
	
	/*
	 * Metodo donde se procesara el registro del cliente
	 */
			
	public static void registerClient() {
		
		String name = inputUtils.askInput("Nombre completo: ",RegexUtils::checkName, "\nCampo obligatorio y no se permiten numeros, Vuelva a intentarlo\n\n");
		String lastname = inputUtils.askInput("Apellido completo: ",RegexUtils::checkName, "\nCampo obligatorio y no se permiten numeros, Vuelva a intentarlo\n\n");
		String age = inputUtils.askInput("Edad: ", RegexUtils::checkAge, "\nCampo obligatorio y solo se permiten numeros de 2 cifras, vuelve a intentarlo\n\n");
		String number = inputUtils.askInput("Numero: ", RegexUtils::checkNumber, "Solo se permiten numeros y el rango es de 8 a 15 numeros, vuelve a intentarlo\\n\\n");
		String email = inputUtils.askInput("Correo eletronico: ", RegexUtils::checkEmail,"\nCampo obligatorio revisar correo, vuelve a intentarlo\\n\\n");
		
		Client client = new Client(name,lastname,age,number,email);
		
		if(wachoPay.getClients().add(client)) {
			Account account = new Account(AccountType.AHORRO, client);
			wachoPay.getAccount().add(account);
			client.getAccounts().add(account);
		}else {
			System.out.println("\nLo sentimos hubo un problema, intentelo despues");
		}
		
	}
	
	public static void optionsWithOutCard() {
		Integer options = 0;
		
		while(options != 3) {
			
			System.out.println("\n======== Options =========");
			System.out.println("1)Deposit");
			System.out.println("2)WithDraw");
			System.out.println("3)Salir");
			System.out.println("============================");
			System.out.println("Escoga un opcion");
			
			switch(options) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			default:
			}
			
		}
		
	}
	
	public static void depositWithOutCard() {
		
		Account account = null;
		
		String numberAccount = inputUtils.askInput("Numero de cuenta: ", RegexUtils::checkNumberAccount, "Solo numeros y 11 digitos\n\n");
		
		for(Account accountFound: wachoPay.getAccount()) {
			if(accountFound.getNumberAccount().equals(numberAccount)) {
				account = accountFound;
				break;
			}
		}
		
		if(account == null) {
			System.out.println("Cuenta inexistente\n\n");
			return;
		}
		
		
		Double amount = Double.parseDouble(inputUtils.askInput("Ingrese monto a depositar: ", RegexUtils::checkAmount, "Solo numeros positivos y hasta dos decimales"));
		
		Boolean success =account.deposit(amount);
		
		if(success) {
			System.out.println("Deposito existoso a la cuenta "+ account.getNumberAccount()+"\n\n");
		}else {
			System.out.println("Ocurrio un error");
		}
		
		
		
	}
		
	public static void withDrawWithOutCard() {
		
		DebitCard debitCard = null;
		

		String numberDebitCard = inputUtils.askInput("Numero de tarjeta: ", RegexUtils::checkNumberCardDebit, "Solo numeros y 16 digitos\n\n");
		
		for(Card cardFound: wachoPay.getCards()) {
			if(cardFound.getNumberCard().equals(numberDebitCard) && cardFound instanceof DebitCard) {
				debitCard = (DebitCard)cardFound;
				break;
			}
		}
		
		
		String pinInput = inputUtils.askInput("Ingrese pin: ", RegexUtils::checkPin, "Solo numeros y 4 digitos");
		
		if(!debitCard.getPin().equals(pinInput)) {
			System.out.println("Pin incorrecto\n\n");
		}
		
		System.out.println("Saldo disponible: "+debitCard.getAccount().getBalance()+"\n\n");
		Double amount = Double.parseDouble(inputUtils.askInput("Ingrese monto a retirar: ", RegexUtils::checkAmount, "Solo numeros positivos y hasta dos decimales"));
		
		Boolean success = debitCard.withDrawByCard(amount);
		
		if(success) {
			System.out.println("Retiro exitoso \n Saldo actual: "+debitCard.getBalance());
		}else {
			System.out.println("Ocurrio un error");
		}
		
	}
	
}


