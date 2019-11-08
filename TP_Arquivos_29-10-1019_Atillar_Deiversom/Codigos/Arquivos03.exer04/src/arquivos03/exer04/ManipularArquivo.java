/*
Classe responsavel por manipular arquivo criado no metodo "Menu"
 */
package arquivos03.exer04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ManipularArquivo extends Aluno{
    
    
    public static void escritor(ArrayList Aluno,File arquivo) throws IOException {
    
        File[] arquivos = arquivo.listFiles();//Lista arquivos de um diretorio caso o ponteiro "arquivo" seja um diretorio
        FileWriter fw = new FileWriter(arquivo);//Construtor.Recebe como argumento o obejeto arquivo e a variavel boleana True que indica que o conteúdo será acrescentado e não sobrescrito.Abre arquivo em modo append,sem que os dados seja sobrescritos
        BufferedWriter bw = new BufferedWriter(fw);//Abre um buffer para receber  os dados que serão gravados posteriomente em disco,e mais eficiente pois não faz acesso direto ao disco o que tornaria mais lento a escrita.
        bw.write("O ARQUIVO CONTEM AS INFORMAÇÕES DOS ALUNOS:");//Metodo write recebe como parametro a string que sera armazenada no buffer para posterior escrita em memoria
        bw.newLine();//Função executa quebra de linha no arquivo
    
        for(int i=0;i<Aluno.size();i++){
        
            bw.newLine();//Função executa quebra de linha no arquivo
            bw.write("------------------------------------------------------------------------------------------------------------------");
            bw.newLine();
            bw.write("ALUNO "+Integer.toString(i+1));
            bw.newLine();//Função executa quebra de linha no arquivo
            bw.write(Aluno.get(i).toString());//Metodo write recebe como parametro a string(neste caso um inteiro) que sera armazenada no buffer para posterior escrita em memoria
            bw.newLine();//Função executa quebra de linha no arquivo
        }
        bw.close();
  }
    
    public static void leitor(File arquivo) throws IOException{
        
            FileReader fr = new FileReader(arquivo);//Construtor que recebe como parametro um objeto do tipo arquivo.A classe FileReader recebe como argumento o objeto File do arquivo a ser lido
            BufferedReader br = new BufferedReader(fr);//Construtor que recebe como parametro objeto do tipo FileReader.A classe BufferedReader, fornece o método readLine() para leitura do arquivo
           
            while (br.ready()) {//Laço de repetição que verifica através do retorno do método ready um boolean True/False.O método ready()verifica e retorna se o arquivo tem mais linhas a ser lida
                String linha = br.readLine();//Declara uma variavél do tipo string que reebe o retorno do método readLIne.O método readLine(), retorna a linha atual e passa o buffer para a próxima linha
                System.out.println(linha);//Imprime o conteúdo da string "linha"
            }
        
            br.close();//Fecha o buffer informando que o arquivo não está sendo mais ultilizado
            fr.close();//Fecha recurso do construtor fr da classe FileReader
    }
}

