/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicioherancacadastroescolar;

/**
 *
 * @author otavio.accarmo
 */
public class Professor extends Pessoa{
    String disciplina;

    public Professor(String nome, int idade, String disciplina) {
        super(nome, idade);    
        this.disciplina = disciplina;
    }
    
    @Override
    public void exibirinformacoes(){
        System.out.println("O professor(a) "+nome+", da disciplina de "+disciplina+", tem "+idade+" anos.");
    }
}

