package Tabajara.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class returnData {
	private List<Paciente> pacientes;

	public returnData(String arquivo) {
		pacientes = new ArrayList<Paciente>();
		try {
			File f = new File("Pacientes.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linha;
			while ((linha = br.readLine()) != null) {
				String[] campos = linha.split(";");
				if (campos.length == 6) {
					pacientes.add(new Paciente(Integer.parseInt(campos[0]), campos[1], campos[2],
							Integer.parseInt(campos[3]), Double.parseDouble(campos[4]), Double.parseDouble(campos[5])));
				}
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Erro ao ler arquivo: " + e.getMessage());
		}
	}

	public Paciente buscarPacientePorCodigo(int codigo) {
		for (Paciente p : pacientes) {
			if (p.getCodigo() == (codigo)) {
				return p;
			}
		}
		return null;
	}

	public boolean ValidaCodigoEmail(int cod, String email) {

		String nomeArquivo = "Pacientes.txt";

		ArrayList<String[]> listaValores = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				String[] valores = linha.split(";");
				listaValores.add(valores);
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo.");
		}
		for (String[] valores : listaValores) {
			if (Integer.parseInt(valores[0])==(cod) || valores[2].equals(email)) {
				if (Integer.parseInt(valores[0])==(cod) && valores[2].equals(email)) {
					JOptionPane.showMessageDialog(null, "Código de Paciente e Email já em uso");
					return false;
				}
				if (Integer.parseInt(valores[0])==(cod)) {
					JOptionPane.showMessageDialog(null, "Código de Paciente já em uso");
					return false;
				}
				if (valores[2].equals(email)) {
					JOptionPane.showMessageDialog(null, "Email já em uso");
					return false;
				}
			}
		}
		return true;
	}

}