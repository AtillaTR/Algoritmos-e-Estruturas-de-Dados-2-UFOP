/*
 * UNIVERSIDADE FEDERAL DE OURO PRETO-UFOP
 * INSTITUTO DE CIENCIAS EXATAS E APLICADAS-ICEA
 * SEMESTRE 2-ANO 2019
 * DISCIPLINA:ALGORITMO E ESTRUTURA DE DADOS II
 * PROFESSOR:FABIANNI ROBERTO
 * ALUNO:Atilla Teixeira Reis
 *       DEIVERSOM RODRIGUES DE MORAIS   
 */
package arquivos3.exer2;

import java.io.BufferedReader;//Biblioteca que contem metodo da classe java io para leitura de arquivos txt
import java.io.BufferedWriter;//Biblioteca que contem métodos para escrita em arquivos txt
import java.io.File;//Biblioteca classe entrada e saídas de dados
import java.io.FileReader;//Biblioteca que contem metodo da classe java io para leitura de arquivos txt
import java.io.FileWriter;//Biblioteca que contem métodos para escrita em arquivos txt
import java.io.IOException;//Essa classe é a classe geral de exceções produzidas por operações de E / S com falha ou interrompidas
import javax.swing.JOptionPane;//Biblioteca de janelas de dialogo

public class ARQUIVOS3Exer2 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
       File arquivo = new File("texto.txt");//Instancia um objeto do tipo File
       int opcao,contador;
       contador=1;
       
       try {//Trata excessões da clase Exception.Protege o bloco para que,caso ocorra algum problema com os comando inseridos dentro deste,a execução será desviada para o bloco catch onde será tratado o erro
            
        File[] arquivos = arquivo.listFiles();//Lista arquivos de um diretorio caso o ponteiro "arquivo" seja um diretorio
        FileWriter fw = new FileWriter(arquivo);//Construtor.Recebe como argumento o obejeto arquivo e a variavel boleana True que indica que o conteúdo será acrescentado e não sobrescrito.Abre arquivo em modo append,sem que os dados seja sobrescritos
        BufferedWriter bw = new BufferedWriter(fw);//Abre um buffer para receber  os dados que serão gravados posteriomente em disco,e mais eficiente pois não faz acesso direto ao disco o que tornaria mais lento a escrita.
        bw.write("O ARQUIVO CONTEM A CONTAGEM DE 1 ATÉ 100:");//Metodo write recebe como parametro a string que sera armazenada no buffer para posterior escrita em memoria
        bw.newLine();//Função executa quebra de linha no arquivo
        
        while(contador<=100){//Laço de repetição responsavél por escrever de 1 até 100 no arquivo
            bw.write(Integer.toString( contador+"|" ));//Metodo write recebe como parametro a string(neste caso um inteiro) que sera armazenada no buffer para posterior escrita em memoria
            bw.newLine();//Função executa quebra de linha no arquivo
            contador=contador+1;
        }
        
        bw.close();//Fecha o buffer informando que o aquivo não está sendo mais ultilizado e grava em disco os dados que estavam armazenados nele
        fw.close();//Fecha recurso do construtor fw da classe FileWriter
        
        opcao = Integer.parseInt(JOptionPane.showInputDialog(null,"USUARIO DESEJA VERIFICAR O CONTEUDO DO ARQUIVO:\nPARA VERIFICAR O CONTEUDO DO ARQUIVO DIGITE 1+ENTER"));//Opção para menu usuário
        
        if(opcao==1){
            FileReader fr = new FileReader(arquivo);//Construtor que recebe como parametro um objeto do tipo arquivo.A classe FileReader recebe como argumento o objeto File do arquivo a ser lido
            BufferedReader br = new BufferedReader(fr);//Construtor que recebe como parametro objeto do tipo FileReader.A classe BufferedReader, fornece o método readLine() para leitura do arquivo
           
            while (br.ready()) {//Laço de repetição que verifica através do retorno do método ready um boolean True/False.O método ready()verifica e retorna se o arquivo tem mais linhas a ser lida
                String linha = br.readLine();//Declara uma variavél do tipo string que reebe o retorno do método readLIne.O método readLine(), retorna a linha atual e passa o buffer para a próxima linha
                System.out.println(linha);//Imprime o conteúdo da string "linha"
            }
        
            br.close();//Fecha o buffer informando que o arquivo não está sendo mais ultilizado
            fr.close();//Fecha recurso do construtor fr da classe FileReader
        }else{
            JOptionPane.showMessageDialog(null, "OPERAÇAO FINALIZADA");//Mensagem exibida ao usuário caso o usuário não queira fazer leitura do arquivo 
        }
        
        } catch (IOException ex) {//Trata o erro capturado pelo bloco try
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO INESPERADO:\nERRO DESCONHECIDO");//Mensagem exibida caso ocorra uma exceção
        }
    }
}
