package Tabajara.gui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CadastroPacientePanel extends JPanel {
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
	private ListarPacientesPanel listaPacPanel;
	
	public CadastroPacientePanel(ListarPacientesPanel listaPacPanel) {
		this.listaPacPanel = listaPacPanel;
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome do Paciente");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(35, 11, 101, 14);
		add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setToolTipText("Nome do Paciente");
		textFieldNome.setBounds(35, 28, 368, 20);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(35, 59, 46, 14);
		add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setEditable(true);
		textFieldEmail.setToolTipText("email");
		textFieldEmail.setBounds(35, 75, 202, 20);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdade.setBounds(35, 131, 46, 14);
		add(lblIdade);
		
		textFieldIdade = new JTextField();
		textFieldIdade.setToolTipText("idade");
		textFieldIdade.setBounds(72, 131, 76, 20);
		add(textFieldIdade);
		textFieldIdade.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPeso.setBounds(35, 106, 46, 14);
		add(lblPeso);
		
		textFieldPeso = new JTextField();
		textFieldPeso.setToolTipText("peso");
		textFieldPeso.setBounds(72, 106, 76, 20);
		add(textFieldPeso);
		textFieldPeso.setColumns(10);
		
		JLabel lblCodigoPaciente = new JLabel("Código do Paciente");
		lblCodigoPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigoPaciente.setBounds(262, 59, 107, 14);
		add(lblCodigoPaciente);
		
		textFieldCodPac = new JTextField();
		textFieldCodPac.setToolTipText("Código do Paciente");
		textFieldCodPac.setBounds(262, 75, 86, 20);
		add(textFieldCodPac);
		textFieldCodPac.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				returnData data = new returnData("Pacientes.txt");
				if(data.ValidaCodigoEmail(Integer.parseInt(textFieldCodPac.getText()), textFieldEmail.getText())) {
						chamaCadastroPaciente();
			}
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvar.setBounds(102, 168, 89, 23);
		add(btnSalvar);
		
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {	
				 limparCampos();

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
		textFieldAltura.setToolTipText("altura");
		textFieldAltura.setBounds(262, 103, 86, 20);
		add(textFieldAltura);
		textFieldAltura.setColumns(10);
		
		
	}
	private void limparCampos(){
		textFieldAltura.setText(" ");
		textFieldEmail.setText(" ");
		textFieldNome.setText(" ");
		textFieldPeso.setText(" ");
		textFieldCodPac.setText(" ");
		textFieldIdade.setText(" ");
		}

private void chamaCadastroPaciente(){
	  Registro io = new Registro();
	  Paciente pac = new Paciente();

	  Object[] novaLinha = new Object[6];
	  
	  pac.setCodigo(Integer.parseInt(textFieldCodPac.getText()));
	  pac.setNome(textFieldNome.getText());
	  pac.setEmail(textFieldEmail.getText());
	  pac.setIdade(Integer.parseInt(textFieldIdade.getText()));
	  pac.setAltura(Double.parseDouble(textFieldAltura.getText()));
	  pac.setPeso(Double.parseDouble(textFieldPeso.getText()));
	  
	  novaLinha[0] = Integer.parseInt(textFieldCodPac.getText());
	  novaLinha[1] = textFieldNome.getText();
	  novaLinha[2] = textFieldEmail.getText() ;
	  novaLinha[3] = Integer.parseInt(textFieldIdade.getText());
	  novaLinha[4] = Double.parseDouble(textFieldAltura.getText());
	  novaLinha[5] = Double.parseDouble(textFieldPeso.getText());

	 
	  try {
	   io.gravarPac(pac);
	  }catch(Exception ex){
	   JOptionPane.showMessageDialog(null, "ERRO", ex.getMessage(),
	   JOptionPane.ERROR_MESSAGE);
	  }
	  listaPacPanel.addNewRow(novaLinha);
	  limparCampos();

	  
	}
}