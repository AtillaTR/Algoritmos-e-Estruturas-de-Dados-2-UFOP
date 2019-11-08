import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Aqruivo {
	
	public static void main(String[] args){
		String mensagem;
		File frases;
		frases= new File("C:\\Users\\atila\\Desktop\\Arquivo.txt");
		Scanner ler=new Scanner(System.in);
		System.out.println("Digite uma frase:\n");
		mensagem = ler.nextLine();
		
		try(BufferedWriter bf= new BufferedWriter(new FileWriter(frases,true))){
			bf.append(mensagem +"\n");
			bf.flush();
			bf.close();
		}catch (IOException e) {
			System.out.println("Errro ao tentar escrever a frase!!!");
		}
		
		
		
	}

}
