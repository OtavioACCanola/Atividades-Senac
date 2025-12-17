/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicioherancacadastroescolar;

/**
 *
 * @author otavio.accarmo
 */
public class ExercicioHerancaCadastroEscolar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Professor professor01 = new Professor ("Olavo", 56, "Culinaria");
        Aluno aluno01 = new Aluno ("Lucas", 19, "868543-76");
        Pessoa pessoa01 = new Pessoa ("Arlindo", 45);
    
        professor01.exibirinformacoes();
        aluno01.exibirinformacoes();
        pessoa01.exibirinformacoes();
        
    }
    
    
}
