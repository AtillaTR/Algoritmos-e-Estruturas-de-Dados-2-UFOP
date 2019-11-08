/*
 Classe da instancia Aluno.Contém os dados e metodos referentes a criação do objeto
 */
package arquivos03.exer04;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;

public class Aluno {
    
    private String nome,matricula;
    private float nota_01,nota_02,media;
    NumberFormat formatarFloat= new DecimalFormat("0.00");

    private String
        msg1="Insira o nome do aluno:",
        msg2="Insira a matricula de ",
        msg3="Insira a nota 01:",
        msg4="Insira a nota 02:";
    
    public Aluno(String n,String m,float n1,float n2,float md){
        
        nome=n;
        matricula=m;
        nota_01=n1;
        nota_02=n2;  
        media=md;
    }

    Aluno() {
    }
    
    public void InserirDados(){
        
        nome=JOptionPane.showInputDialog(null, msg1);
        matricula=JOptionPane.showInputDialog(null,msg2+getnome());
        nota_01=Float.parseFloat(JOptionPane.showInputDialog(null, msg3));
        nota_02=Float.parseFloat(JOptionPane.showInputDialog(null, msg4));
        
        CalculaMedia(nota_01,nota_02);
    }
    
    public void CalculaMedia(float nota_01,float nota_02){
        this.media=(nota_01+nota_02)/2;
    }
    
    public String getnome(){
        return nome;
    }
    public String getmatricula(){
        return matricula;
    }
    public float getnota_01(){
        return nota_01;
    }
    public float getnota_02(){
        return nota_02;
    }
    public float getmedia(){
        return media;
    }
    
    @Override
    public String toString(){
        return "Nome: "+nome+"\n"
            +"Matricula: "+matricula+"\n"
            +"Nota 01: "+formatarFloat.format(nota_01)+"\n"
            +"Nota 02: "+formatarFloat.format(nota_02)+"\n"
            +"Media: "+formatarFloat.format(media)+"\n";
    }    
}
