/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicioherancacadastroescolar;

/**
 *
 * @author otavio.accarmo
 */
public class Pessoa {
    String nome;
    int idade;
    
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;      
    }
    
    public void exibirinformacoes() {
        System.out.println("A pessoa se chama " + nome + " e ela tem " + idade + " anos");
    }
    
}
