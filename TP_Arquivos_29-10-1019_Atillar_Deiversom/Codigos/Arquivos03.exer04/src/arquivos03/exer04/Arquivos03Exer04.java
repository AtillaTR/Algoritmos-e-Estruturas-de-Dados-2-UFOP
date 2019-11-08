/*
 * UNIVERSIDADE FEDERAL DE OURO PRETO-UFOP
 * INSTITUTO DE CIENCIAS EXATAS E APLICADAS-ICEA
 * SEMESTRE 2-ANO 2019
 * DISCIPLINA:ALGORITMO E ESTRUTURA DE DADOS II
 * PROFESSOR:FABIANNI ROBERTO
 * ALUNO:Atilla Teixeira Reis
 *       DEIVERSOM RODRIGUES DE MORAIS  
 */

package arquivos03.exer04;

import java.io.IOException;////Essa classe é a classe geral de exceções produzidas por operações de E / S com falha ou interrompidas

public class Arquivos03Exer04 {

    public static void main(String[] args) throws IOException {
      
        Aluno a=new Aluno();//Cria uma instancia do objeto "Aluno"
        Menu.MenuOpcao(a);//Faz a chamada do metodo "MenuOpcao" dentro da classe "Menu"
    }   
}
