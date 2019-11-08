/*
 * UNIVERSIDADE FEDERAL DE OURO PRETO-UFOP
 * INSTITUTO DE CIENCIAS EXATAS E APLICADAS-ICEA
 * SEMESTRE 2-ANO 2019
 * DISCIPLINA:ALGORITMO E ESTRUTURA DE DADOS II
 * PROFESSOR:FABIANNI ROBERTO
 * ALUNO:ATILLA TEIXEIRA REIS
 *       DEIVERSOM RODRIGUES DE MORAIS  
 */
package arquivos3.exer3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ARQUIVOS3Exer3 {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        int opcao,contador=0;
        String entrada,msg;
        msg="O ARQUIVO CONTEM A CONTAGEM DE 0 A 100:\n";
        ArrayList <Object> ListaStr=new ArrayList();
        ObjectOutputStream obs=new ObjectOutputStream(new FileOutputStream("binario.bin"));
        ListaStr.add(msg+"\n");
      
        while(contador<=100){
            ListaStr.add(contador+"\n");
            contador+=1;
        }
        obs.writeObject(ListaStr);
        obs.close();
  
        opcao = Integer.parseInt(JOptionPane.showInputDialog(null,"USUARIO DESEJA VERIFICAR O CONTEUDO DO ARQUIVO:\nPARA VERIFICAR O CONTEUDO DO ARQUIVO DIGITE 1+ENTER"));//Opção para menu usuário
        if(opcao==1){
            ObjectInputStream iobs=new ObjectInputStream(new FileInputStream("binario.bin"));
            iobs.readObject();
            iobs.close();
      
            for(int i=0;i<ListaStr.size();i++){
                System.out.println(ListaStr.get(i));
            }
        }
    }
}
