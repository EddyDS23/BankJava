package interfaz;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import models.Bank;
import models.Client;

import javax.swing.JButton;

public class Principal extends JFrame implements ActionListener{
	BorderLayout layoutPrincipal = new BorderLayout();
	JPanel panelPrincipal = new JPanel();
	JButton btnAceptar = new JButton("Enviar");
	JTextField fieldRelleno = new JTextField();
	JTextArea txtArea = new JTextArea();
	
	Bank wachoPay = new Bank();
	
	public Principal(int hidth, int width, String title) {
		
		btnAceptar.addActionListener(this);;
		
		panelPrincipal.setLayout(new BorderLayout());
		
		panelPrincipal.add(btnAceptar, BorderLayout.SOUTH);
		panelPrincipal.add(fieldRelleno, BorderLayout.NORTH);
		panelPrincipal.add(txtArea, BorderLayout.CENTER);
		
		txtArea.setEditable(false);
		txtArea.setText("Bienvenido ingrese su email");
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(panelPrincipal);
		this.setTitle(title);
		this.setSize(width, hidth);
		this.setVisible(true);
		
	}
	
	public void clearField() {
		fieldRelleno.setText("");
	}
	
	public void clearTextArea() {
		txtArea.setText("");
	}
	
	public void textIN(String text) {
		String txtInputArea = "";
		txtInputArea += "=================================\n";
		txtInputArea += text;
		txtInputArea += "\n=================================\n\n";
		
		txtArea.setText(txtInputArea);
	}
	
	public void buttonEvent(ActionEvent e) {
		if(e.equals(btnAceptar)) {
			System.out.print("Funcionando");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAceptar) {
			String textField = fieldRelleno.getText();
			
			Client currentClient = login(textField);
			
			String text = "Bienvenido " + currentClient.getName() + " " + currentClient.getLastname()+"\n\n";
			
			textIN(text);
			
			clearField();
			
		}
	}
	
	
	public  Client login(String email) {
		return wachoPay.getCurrentUser(email);
	}
	
	public Bank getBank() {
		return this.wachoPay;
	}
	
}

