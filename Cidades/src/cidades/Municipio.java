package cidades;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;

public class Municipio {
    
    private float temperatura;
    NumberFormat formatarFloat= new DecimalFormat("0.00");
    private String nome,UF,
        msg1="Insira o nome da cidade:",
        msg2="Insira o estado em que esta localizado a cidade de ",
        msg3="Insira a Temperatura(em graus celsius):",
        msg4="Voce digitou um dado incorreto.Tente novamente.";
    
   public Municipio(String n,String u,float t){
       nome=n;
       UF=u;
       temperatura=t;
   }
   
   Municipio(){
   }
   
   public void InserirDados(int num_municipio){
        try{
        nome=JOptionPane.showInputDialog(null, msg1+" "+num_municipio);
        UF=JOptionPane.showInputDialog(null,msg2+getnome());
        temperatura=Float.parseFloat(JOptionPane.showInputDialog(null, msg3));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,msg4);
        }
    }
    public String getnome(){
        return nome;
    }
    public String UF(){
        return UF;
    }
    public float temperatura(){
        return temperatura;
    }
    
    @Override
    public String toString(){
        return "Nome: "+nome+"      "
            +"UF: "+UF+"        "
            +"Temperatura: "+formatarFloat.format(temperatura)+"ºC"+"        ";
    }    
}
