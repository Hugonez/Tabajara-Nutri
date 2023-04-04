package Tabajara.gui;
import java.io.*;
public class EditarPaciente {
	    private String arquivoTemp;

	    public void ArquivoTexto(String arquivoTemp) {
	        this.arquivoTemp = arquivoTemp;
	    }

	    public void editarLinha(String codigo, String novoConteudo) {
	        try {
	            // Abrir o arquivo para leitura
	            File arquivo = new File("Pacientes.txt");
	            FileReader leitor = new FileReader(arquivo);
	            BufferedReader buffer = new BufferedReader(leitor);

	            // Abrir um novo arquivo para escrita
	            File novoArquivo = new File("Novo" + arquivoTemp);
	            FileWriter escritor = new FileWriter(novoArquivo);
	            BufferedWriter bufferEscrita = new BufferedWriter(escritor);

	            // Ler o arquivo linha por linha
	            String linha = buffer.readLine();
	            while (linha != null) {
	                // Verificar se a linha começa com o código inserido pelo usuário
	                if (linha.startsWith(codigo)) {
	                    // Se sim, escrever a nova linha no arquivo de escrita
	                    linha = novoConteudo; // substituir a linha toda
	                }

	                // Escrever a linha no arquivo de saída
	                bufferEscrita.write(linha);
	                bufferEscrita.newLine();

	                // Pular para a próxima linha
	                linha = buffer.readLine();
	            }

	            // Fechar os arquivos
	            buffer.close();
	            leitor.close();
	            bufferEscrita.close();
	            escritor.close();

	            // Deletar o arquivo original
	            arquivo.delete();

	            // Renomear o novo arquivo com o nome do arquivo original
	            novoArquivo.renameTo(arquivo);

	            System.out.println("Edição realizada com sucesso!");
	        } catch (IOException e) {
	            System.out.println("Erro ao editar o arquivo: " + e.getMessage());
	        }
	    }
	
	 public void apagarLinha(String codigo) {
	        File arquivoOriginal = new File("Pacientes.txt");
	        File arquivoTemporario = new File("temp.txt");
	        try {
	            FileReader fr = new FileReader(arquivoOriginal);
	            BufferedReader br = new BufferedReader(fr);
	            FileWriter fw = new FileWriter(arquivoTemporario);
	            BufferedWriter bw = new BufferedWriter(fw);
	            String linha;
	            while ((linha = br.readLine()) != null) {
	                String[] campos = linha.split(";");
	                if (campos.length == 6 && !campos[0].equals(codigo)) {
	                    bw.write(linha);
	                    bw.newLine();
	                }
	            }
	            br.close();
	            bw.close();
	            arquivoOriginal.delete();
	            arquivoTemporario.renameTo(arquivoOriginal);
	        } catch (IOException e) {
	            System.out.println("Erro ao apagar linha: " + e.getMessage());
	        }
	    }
}