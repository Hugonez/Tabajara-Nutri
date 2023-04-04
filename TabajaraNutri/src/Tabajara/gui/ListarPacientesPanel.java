package Tabajara.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListarPacientesPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	private Vector<String> getNameColumns() {
		Vector<String> nameColumns = new Vector<String>();
		nameColumns.add("Cod.");
		nameColumns.add("Nome");
		nameColumns.add("E-mail");
		nameColumns.add("Idade");
		nameColumns.add("Altura");
		nameColumns.add("Peso");
		return nameColumns;
	}

	/**
	 * Create the panel.
	 */

	public ListarPacientesPanel() {
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 38, 349, 182);
		add(scrollPane);

		table = new JTable(getDataColumns(), getNameColumns());
		table.setAutoCreateRowSorter(getFocusTraversalKeysEnabled());
		scrollPane.setViewportView(table);

	}

	public void addNewRow(Object[] valores) {
		((DefaultTableModel) table.getModel()).addRow(valores);
	}

	private Vector<Vector<Object>> getDataColumns() {
		Registro io = new Registro();
		Vector<Vector<Object>> dataColumns = null;

		try {
			dataColumns = io.getPaciente();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "ERRO", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
		}

		return dataColumns;
	}

}
