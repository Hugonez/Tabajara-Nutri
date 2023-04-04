package Tabajara.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class editarCadastro extends JPanel {
	private JTextField codField;

	/**
	 * Create the panel.
	 */

	
	public editarCadastro() {
		setLayout(null);
		
		JLabel lblCodPac = new JLabel("Digite o código do paciente que deseja editar");
		lblCodPac.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodPac.setBounds(-24, 72, 430, 31);
		add(lblCodPac);
		
		codField = new JTextField();
		codField.setBounds(138, 114, 86, 20);
		add(codField);
		codField.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				returnData pr = new returnData("Pacientes.txt");
				Paciente p = pr.buscarPacientePorCodigo(Integer.parseInt(codField.getText()));
				if (p != null) {
					editDelete frame = new editDelete(p);
					frame.setVisible(true);
					
				} else {
					JOptionPane.showMessageDialog(null, "Paciente não encontrado");
				}
			}
		});
		btnPesquisar.setBounds(128, 156, 115, 23);
		add(btnPesquisar);

	}
}
