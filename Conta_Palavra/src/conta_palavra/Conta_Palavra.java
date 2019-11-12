package conta_palavra;

import java.io.File;//Uma instância de File tem a função de apontar para um arquivo ou diretório no sistema de arquivos e disponibiliza vários comandos para manipular o recurso referenciado. 
import java.io.FileNotFoundException;
//A classe FileWriter serve para escrever diretamente no arquivo, enquanto a classe BufferedWriter, além de ter um desempenho melhor, possui alguns métodos que são independentes de sistema operacional, como quebra de linhas.
import java.io.IOException;
import javax.swing.JOptionPane;

public class Conta_Palavra {
 
    public static void main(String[] args)throws FileNotFoundException, IOException {
       
        File frases = new File("frase.txt");//Instancia um objeto do tipo File
        int opcao=0;
        String
            msg1="BEM VINDO AO SISTEMA DE ARQUIVOS"+
                 "\nESCOLHA UMA OPCAO\n"+
                 "\n[1] Escrever no Arquivo\n"+
                 "[2] Contar Palavras\n"+
                 "[3] Abrir arquivo com frases\n"+
                 "[4] Sair\n",
            msg2="Saindo do programa",
            msg3="Erro:Escolha uma opcao valida";
        
        while(opcao!=4){
  
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,msg1));
            
            switch (opcao) {
                case 1:
                    ManipularArquivo.Escritor(frases);
                    break;
                case 2:
                    ManipularArquivo.NovaInf();
                    File contador = new File("contador.txt");//Instancia um objeto do tipo File
                    ManipularArquivo.Contador(frases, contador);
                    ManipularArquivo.leitor(contador,false);
                    break;
                case 3:
                    ManipularArquivo.NovaInf();
                    ManipularArquivo.leitor(frases,true);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,msg2);
                    break;
                default:     
                    JOptionPane.showMessageDialog(null,msg3);
                 
            }
        }
    }
 }	
	


    

