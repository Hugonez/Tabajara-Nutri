package Tabajara.gui;

import java.util.*;

public class Paciente {

	static ArrayList<Paciente> rep = new ArrayList<Paciente>();
	private int codPac;
	private String nomePac;
	private String emailPac;
	private int idadePac;
	private Double pesoPac;
	private Double alturaPac;

	public Paciente() {
		super();
	}

	public Paciente(int cod, String nome, String email, int idade, Double peso, Double altura) {

		codPac = cod;
		nomePac = nome;
		emailPac = email;
		idadePac = idade;
		pesoPac = peso;
		alturaPac = altura;
	}

	public void ArrayList(Paciente p) {
		rep.add(p);
	}

	public void teste() {
		for (Paciente p : rep) {
			System.out.println(+p.getCodigo() + p.getEmail() + p.getNome() + p.getAltura());
		}
	}

	public String getNome() {
		return nomePac;
	}

	public void setNome(String nome) {
		nomePac = nome;
	}

	public int getCodigo() {
		return codPac;
	}

	public void setCodigo(int codigo) {
		codPac = codigo;
	}

	public String getEmail() {
		return emailPac;
	}

	public void setEmail(String email) {
		emailPac = email;
	}

	public int getIdade() {
		return idadePac;
	}

	public void setIdade(int idade) {
		idadePac = idade;
	}

	public Double getPeso() {
		return pesoPac;
	}

	public void setPeso(Double peso) {
		pesoPac = peso;
	}

	public Double getAltura() {
		return alturaPac;
	}

	public void setAltura(Double altura) {
		alturaPac = altura;
	}
}
