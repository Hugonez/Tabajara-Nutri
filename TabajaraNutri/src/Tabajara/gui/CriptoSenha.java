package Tabajara.gui;

public class CriptoSenha {
String Senha = "J]e_X=f[X-0-0";

public String getSenha(String senhasys) {
	int chave, tamanho, letranum;
	chave = (int) senhasys.charAt(0);
	tamanho = senhasys.length();
	StringBuilder cripto = new StringBuilder();
	for (int i = 0; i <= (tamanho - 1); i++) {
		letranum = (int) senhasys.charAt(i);
		letranum = letranum + chave;
		// limitando os caracteres para menor que 125(}),maior que 33(!) e diferente de
		// 92(\)
		while (letranum > 125) {
			letranum = letranum - 92;
		}
		if (letranum < 33) {
			letranum = letranum + 33;
		} else if (letranum == 92) {
			letranum++;
		}
		cripto.append((char) letranum);
	}
	if (cripto.toString().equals(Senha)) {
		return "true";
	} else {
		return "false";
	}
}
}