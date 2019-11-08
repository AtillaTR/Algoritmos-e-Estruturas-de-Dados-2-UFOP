package cidades;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Menu {
     public static void MenuOpcao(Municipio m) throws IOException{ 
     
        int opcao,quantidade;
        float media=0;
        opcao=0;
        ArrayList<Municipio> ListaDeMunicipios = new ArrayList();
        ArrayList<String> AcimaDaMedia = new ArrayList();
        File arquivo = new File("texto.txt");//Instancia um objeto do tipo File
        String
                msg1="BEM VINDO AO SISTEMA DE CADASTRO DE MUNICIPIO.\nDESEJA INICIAR UMA OPERACAO?\n1-Sim\n2-Não",
                msg2="Digite a opção desejada:\n1-Fornecer dados\n2-Imprimir dados salvos\n3-Sair",
                msg3="NUMERO DE MUNICIPIOS QUE SERÃO CADASTRADO:",
                msg4="Opcão Invalida.Tente novamente.";
        
        while(opcao!=2){
            try{
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,msg1));
            
            if(opcao==1){
                while(opcao!=3){
                    opcao = Integer.parseInt(JOptionPane.showInputDialog(null,msg2));
        
                    if(opcao==1){
                        quantidade = Integer.parseInt(JOptionPane.showInputDialog(null,msg3));
                        for(int i=0;i<quantidade;i++){
                            ListaDeMunicipios.add(new Municipio());
                            ListaDeMunicipios.get(i).InserirDados(i+1);
                            media+=ListaDeMunicipios.get(i).temperatura();
                        } 
                    
                        media=(media/ListaDeMunicipios.size());
                 
                        for(int i=0;i<ListaDeMunicipios.size();i++){
                            if (media<ListaDeMunicipios.get(i).temperatura()){
                            AcimaDaMedia.add(ListaDeMunicipios.get(i).getnome());
                            }
                        }
                        ManipularArquivo.escritor(ListaDeMunicipios,AcimaDaMedia,arquivo,media);
                    }
                    if(opcao==2){
                        ManipularArquivo.leitor(arquivo);
                    }
           
                }
            }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,msg4);
            }
        }
    }  
}
