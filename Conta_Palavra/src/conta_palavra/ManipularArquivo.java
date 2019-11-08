package conta_palavra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ManipularArquivo {
    
    public static void Escritor(File arquivo) throws IOException {
        
        int opcao = 0,contador=1;//Variavel que armazena um numero inteiro que e para verificar se usuario desejar finalizar o programa ou se deseja escrever uma nova frase.
        boolean verifica=false;
        Scanner ler=new Scanner(System.in);//le o que o usuario ira inserir no teclado
        String frase="entrar",
             msg1="ARQUIVO PRONTO PARA SER ESCRITO"
                   + "\nCONFIRME EM OK PARA ESCREVER", 
             msg2="ARQUIVO ESTA SENDO CRIADO",                                          
             msg3="DIGITE A FRASE QUE DESEJA GRAVAR NO ARQUIVO",                    
             msg4="ERRO AO TENTAR ESCREVER NOVA FRASE EM ARQUIVO",                             
             msg6="OCORREU UMA FALHA NA MAMIPULAÇÃO DO ARQUIVO",                    
             msg7="ESCRITA CONCLUIDA",
             msg8="ESCREVA SUAS FRASE AQUI:"
                   + "\nPARA SAIR ESCREVA(#sair#)):\n",
             msg9="NAO HOUVE ESCRITA NO ARQUIVO NESTA OPERACAO",
             str="#sair#";                                              
        
        if (arquivo.exists()) //Condição.verifica se objeto do tipo File existe
            JOptionPane.showMessageDialog(null,msg1);//Mensagem exibida ao usuário caso exista o arquivo
        else //Condição.Caso a primeira condição não seja satisfeita
            JOptionPane.showMessageDialog(null,msg2);//Mensagem exibida ao usuário caso o arquivo não existe
        
        System.out.println(msg8);
        while(!frase.equalsIgnoreCase(str)){//Laço de repetição que permite o usuario escrever varias linhas em um arquivo sem que precise compilar novamente o codigo
                
                try {//Inicio bloco tratamento de excessão.Construtor que recebe que receb como argumento objeto do tipo FileWrite
                    FileWriter fw = new FileWriter(arquivo);
                    BufferedWriter bf = new BufferedWriter(fw);
                    System.out.print(contador+"-  ");
                    frase = ler.nextLine();
                    if(!frase.equalsIgnoreCase(str)){
                    bf.append(frase+"|");//Coloca no buffer os dados que estão no buffer os dados que estão na string e  adiciiona uma quebra de linha após a string
                    bf.newLine();
                    bf.flush();//Envia todo o conteudo do buffer para o arquivo txt
                    bf.close();//Fecha buffer de escrita
                    verifica=true;
                   }
                    if(verifica==false)
                        JOptionPane.showMessageDialog(null,msg9);
                        
                }catch (IOException e){//Tratamento de excessão.Caso ocorra uma excessão da classe IOExcepition será realizada uma ação dentro do bloco
                    JOptionPane.showMessageDialog(null,msg4);//Mensagem exibida ao usuário caso exista uma Excessão durante a escrita em um arquivo
                }
                contador++;
        }
        JOptionPane.showMessageDialog(null,msg7);//Caixa de dialogo
    }
    
    public static void Contador(File frases,File contador) throws FileNotFoundException, IOException{
        
        String linha,
               msg1="Numero de palavras por linha:\n",
               msg2="\n\nDados numeros totais\n",
               msg3="Contagem concluida",
               msg4="Arquivo vazio";
        int cont_frase=0,cont_total=0,cont_palavra=0,num_linha=0;
        char caracter_atual,caracter_anterior;
        FileReader fr = new FileReader(frases);//Construtor que recebe como parametro um objeto do tipo arquivo.A classe FileReader recebe como argumento o objeto File do arquivo a ser lido
        BufferedReader br = new BufferedReader(fr);//Construtor que recebe como parametro objeto do tipo FileReader.A classe BufferedReader, fornece o método readLine() para leitura do arquivo
        FileWriter fw = new FileWriter(contador);
        fw.write(msg1);
        
        while(br.ready()) {
                         
            linha = br.readLine();
            caracter_anterior=linha.charAt(0);
            for(int i=0;i<linha.length();i++)
            { 
                caracter_atual=linha.charAt(i);
                            
                if(i>0)
                    caracter_anterior=linha.charAt(i-1);
                
                if(((caracter_atual==' '&& caracter_anterior!=' ')||(caracter_atual=='|'&& caracter_anterior!=' ')))
                    cont_palavra++;
            }
            if(cont_palavra!=0){
                cont_frase++;
                cont_total+=cont_palavra;
            }
            num_linha++;
            fw.write("[Linha"+num_linha+": "+cont_palavra+"]   ");
            cont_palavra=0;
        }
        if(cont_total==0)
            fw.write(msg4);
            
        fw.write(msg2);
        fw.write("[Palavras: "+cont_total+"]");
        fw.write("[Frases: "+cont_frase+"]");
        fw.write("[Linha: "+num_linha+"]");
        fr.close();
        fw.close();
        br.close();
        JOptionPane.showMessageDialog(null,msg3);
    }
    
    public static void leitor(File arquivo,boolean controle) throws IOException{
        
        int contador=1;
        String
        msg1="OCORREU UM ERRO NA ,MANIPULAÇÃO DO ARQUIVO",
        msg2="ARQUIVO VAZIO";
        if(arquivo.length() == 0)
            JOptionPane.showMessageDialog(null,msg2);
            
        try{
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {//Laço de repetição que verifica através do retorno do método ready um boolean True/False.O método ready()verifica e retorna se o arquivo tem mais linhas a ser lida
                
                if(controle==true)
                    System.out.print(contador+"-  ");
                
                String linha = br.readLine();//Declara uma variavél do tipo string que reebe o retorno do método readLIne.O método readLine(), retorna a linha atual e passa o buffer para a próxima linha
                System.out.println(linha);//Imprime o conteúdo da string "linha"
                contador++;
            }
            br.close();
            fr.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,msg1);
        }
    }
    
    public final static void NovaInf(){

        System.out.println("=================================================================================================================");
        System.out.println("\nO CONTEUDO DO ARQUIVO ESTA IMPRESSO ABAIXO:\n\n");
    }
}
        
