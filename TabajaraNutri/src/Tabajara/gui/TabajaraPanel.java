package Tabajara.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.Font;

//código para a tela de Login, gerado majoritariamente ná tela de Design
public class TabajaraPanel {

	private JFrame frame;
	private JTextField txtUsurio;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					TabajaraPanel window = new TabajaraPanel();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TabajaraPanel() {
		initialize();
	}

	public void MinimizaPanel() {
		this.frame.setVisible(false);
		return;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(173, 115, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		txtUsurio = new JTextField();
		txtUsurio.setForeground(new Color(128, 128, 128));
		txtUsurio.setToolTipText("Login");
		txtUsurio.setBounds(173, 132, 86, 20);
		frame.getContentPane().add(txtUsurio);
		txtUsurio.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setToolTipText("Senha");
		passwordField.setBounds(173, 177, 86, 20);
		frame.getContentPane().add(passwordField);

		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(173, 160, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JTextPane txtpnSejaBemVindo = new JTextPane();
		txtpnSejaBemVindo.setEditable(false);
		txtpnSejaBemVindo.setText(
				"                                            Seja Bem Vindo! \r\n                Clinicas Tabajara proporcionando aos nossos pacientes\r\n                                uma melhor qualidade de vida.");
		txtpnSejaBemVindo.setBounds(10, 45, 414, 59);
		frame.getContentPane().add(txtpnSejaBemVindo);

		JButton btnLogar = new JButton("Logar");
		btnLogar.setBounds(170, 218, 95, 23);
		frame.getContentPane().add(btnLogar);
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CriptoSenha objSenha = new CriptoSenha();
				String Username = txtUsurio.getText();
				String Password1 = passwordField.getText();
				if (Username.equals("Tabajara") && objSenha.getSenha(Password1).equals("true")) {
					JOptionPane.showMessageDialog(null, "Logado com sucesso");
					TabajaraMenu frameTabaj = new TabajaraMenu();
					frameTabaj.setVisible(true);
					MinimizaPanel();
				} else
					JOptionPane.showMessageDialog(null, "Usuário ou Senha Incorretos ");

			}

		});
		btnLogar.setToolTipText("Confirmar");
		btnLogar.setBounds(170, 216, 89, 23);

	}

	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

}
