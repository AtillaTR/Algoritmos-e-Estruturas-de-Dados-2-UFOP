/*
 Classe responsável pela interação do usuário com o programa através de uma interface
 */
package arquivos03.exer04;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Menu {
    public static void MenuOpcao(Aluno a) throws IOException{ 
     
        int opcao,quantidade;
        opcao=0;
        ArrayList<Aluno> ListaDeAlunos = new ArrayList();
        File arquivo = new File("texto.txt");//Instancia um objeto do tipo File
        opcao = Integer.parseInt(JOptionPane.showInputDialog(null,"BEM VINDO AO SISTEMA DE CADASTRO DE ALUNOS.\nDESEJA INICIAR UMA OPERACAO?\n1-Sim\n0-Não"));
    
        while(opcao!=3){
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite a opção desejada:\n1-Fornecer dados\n2-Imprimir dados salvos\n3-Sair"));
        
            if(opcao==1){
                quantidade = Integer.parseInt(JOptionPane.showInputDialog(null,"NUMERO DE ALUNOS QUE SERÁ CADASTRADO:"));
                for(int i=0;i<quantidade;i++){
                    ListaDeAlunos.add(new Aluno());
                    ListaDeAlunos.get(i).InserirDados();
                }   
                ManipularArquivo.escritor(ListaDeAlunos,arquivo);
            }
            if(opcao==2){
                ManipularArquivo.leitor(arquivo);
            }
        }  
    }
}
