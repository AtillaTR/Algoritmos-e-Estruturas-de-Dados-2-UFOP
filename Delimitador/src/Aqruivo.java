
import java.io.File;//Uma inst�ncia de File tem a fun��o de apontar para um arquivo ou diret�rio no sistema de arquivos e disponibiliza v�rios comandos para manipular o recurso referenciado. 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
//A classe FileWriter serve para escrever diretamente no arquivo, enquanto a classe BufferedWriter, al�m de ter um desempenho melhor, possui alguns m�todos que s�o independentes de sistema operacional, como quebra de linhas.
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Aqruivo {
	
	public static void main(String[] args) throws FileNotFoundException{
		String mensagem;
		File frases;
		frases= new File("C:\\Users\\atila\\Desktop\\Arquivo.txt");//cria o arquivo no diretorio desejado
		Scanner ler=new Scanner(System.in);//le o que o usuario ira inserir no teclado
		System.out.println("Digite uma frase:\n");
		
		mensagem = ler.nextLine();
		
		
		try(BufferedWriter bf= new BufferedWriter(new FileWriter(frases,true))){//se caso ja existir o arquivo ira so acrescentar uma nova  frase
			bf.append(mensagem+ "|");
			bf.flush();
			bf.close();
		}catch (IOException e) {
			System.out.println("Errro ao tentar escrever a frase!!!");//caso ocorra algum erro 
		}
		
		
		Scanner scanner = new Scanner(frases)
                .useDelimiter("\\||\\ ");
		while(scanner.hasNext()) {
			String nome=scanner.next();
			System.out.println(nome);
		}
		
	}

}
