package Tabajara.gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Registro {
	private final String DIRETORIO = ".";
	private final String ARQUIVO = "Pacientes.txt";

	public void gravarPac(Paciente pac) throws Exception {
	
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(DIRETORIO, ARQUIVO), true));
			StringBuilder paciente = new StringBuilder();
			paciente.append(pac.getCodigo() + ";" + pac.getNome() + ";" + pac.getEmail() + ";" + pac.getIdade() + ";"
					+ pac.getPeso() + ";" + pac.getAltura());
			writer.write(paciente.toString());
			writer.newLine();
			writer.close();
		} catch (FileNotFoundException fnfe) {
			throw new Exception("Arquivo não encontrado");

		} catch (Exception ex) {
			throw new Exception("Problemas na gravação do arquivo");

		}

	}

	public Vector<Vector<Object>> getPaciente() throws Exception {
		Vector<Vector<Object>> lista = new Vector<Vector<Object>>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(DIRETORIO, ARQUIVO)));
			String linha = reader.readLine();
			while (linha != null) {
				Vector<Object> pacienteVector = new Vector<Object>();
				String[] tokens = linha.split(";");

				pacienteVector.add(tokens[0]);
				pacienteVector.add(tokens[1]);
				pacienteVector.add(tokens[2]);
				pacienteVector.add(tokens[3]);
				pacienteVector.add(tokens[4]);
				pacienteVector.add(tokens[5]);

				lista.add(pacienteVector);
				linha = reader.readLine();
			}

			reader.close();

		} catch (FileNotFoundException fnfe) {
			throw new Exception("Arquivo não encontrado");

		} catch (Exception ex) {
			throw new Exception("Problemas de leitura no arquivo de eventos");

		}
		return lista;
	}

	

}
