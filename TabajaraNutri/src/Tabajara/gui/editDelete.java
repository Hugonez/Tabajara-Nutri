package Tabajara.gui;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class editDelete extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JTextField textFieldIdade;
	private JTextField textFieldPeso;
	private JTextField textFieldCodPac;
	private JTextField textFieldAltura;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public editDelete(Paciente p) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLayout(null);

		JLabel lblNome = new JLabel("Nome do Paciente");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(35, 11, 101, 14);
		add(lblNome);

		textFieldNome = new JTextField();
		textFieldNome.setText(p.getNome());
		textFieldNome.setToolTipText("Nome do Paciente");
		textFieldNome.setBounds(35, 28, 368, 20);
		add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(35, 59, 46, 14);
		add(lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setText(p.getEmail());
		textFieldEmail.setToolTipText("email");
		textFieldEmail.setBounds(35, 75, 202, 20);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);

		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdade.setBounds(35, 131, 46, 14);
		add(lblIdade);

		textFieldIdade = new JTextField();
		textFieldIdade.setText(Integer.toString(p.getIdade()));
		textFieldIdade.setToolTipText("idade");
		textFieldIdade.setBounds(72, 131, 76, 20);
		add(textFieldIdade);
		textFieldIdade.setColumns(10);

		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPeso.setBounds(35, 106, 46, 14);
		add(lblPeso);

		textFieldPeso = new JTextField();
		textFieldPeso.setText(Double.toString(p.getPeso()));
		textFieldPeso.setToolTipText("peso");
		textFieldPeso.setBounds(72, 106, 76, 20);
		add(textFieldPeso);
		textFieldPeso.setColumns(10);

		JLabel lblCodigoPaciente = new JLabel("Código do Paciente");
		lblCodigoPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigoPaciente.setBounds(262, 59, 107, 14);
		add(lblCodigoPaciente);

		textFieldCodPac = new JTextField();
		textFieldCodPac.setEditable(false);
		textFieldCodPac.setText(Integer.toString(p.getCodigo()));
		textFieldCodPac.setToolTipText("Código do Paciente");
		textFieldCodPac.setBounds(262, 75, 86, 20);
		add(textFieldCodPac);
		textFieldCodPac.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				EditarPaciente edit = new EditarPaciente();
				Paciente pac = new Paciente();
				StringBuilder paciente = new StringBuilder();
				pac.setCodigo(Integer.parseInt(textFieldCodPac.getText()));
				pac.setNome(textFieldNome.getText());
				pac.setEmail(textFieldEmail.getText());
				pac.setIdade(Integer.parseInt(textFieldIdade.getText()));
				pac.setAltura(Double.parseDouble(textFieldAltura.getText()));
				pac.setPeso(Double.parseDouble(textFieldPeso.getText()));

				paciente.append(pac.getCodigo() + ";" + pac.getNome() + ";" + pac.getEmail() + ";" + pac.getIdade()
						+ ";" + pac.getPeso() + ";" + pac.getAltura());
				edit.editarLinha(textFieldCodPac.getText(), paciente.toString());
				JOptionPane.showMessageDialog(null, "Paciente atualizado no registro");
				dispose();
				Frame[] frames = JFrame.getFrames();
				for (Frame frame : frames) {
				    frame.dispose();
				}
				TabajaraMenu frameTabaj = new TabajaraMenu();
				frameTabaj.setVisible(true);
				
			}

		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvar.setBounds(102, 168, 89, 23);
		add(btnSalvar);

		JButton btnLimpar = new JButton("Deletar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				
				EditarPaciente edit = new EditarPaciente();
				Paciente pac = new Paciente();
				
				edit.apagarLinha(textFieldCodPac.getText());
				JOptionPane.showMessageDialog(null, "Paciente removido do registro");
				dispose();
				Frame[] frames = JFrame.getFrames();
				for (Frame frame : frames) {
				    frame.dispose();
				}

				TabajaraMenu frameTabaj = new TabajaraMenu();
				frameTabaj.setVisible(true);
				

			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpar.setBounds(230, 168, 89, 23);
		add(btnLimpar);

		JLabel lblNewLabel = new JLabel("Altura\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(206, 106, 46, 14);
		add(lblNewLabel);

		textFieldAltura = new JTextField();
		textFieldAltura.setText(Double.toString(p.getAltura()));
		textFieldAltura.setToolTipText("altura");
		textFieldAltura.setBounds(262, 103, 86, 20);
		add(textFieldAltura);
		textFieldAltura.setColumns(10);

	}

}
