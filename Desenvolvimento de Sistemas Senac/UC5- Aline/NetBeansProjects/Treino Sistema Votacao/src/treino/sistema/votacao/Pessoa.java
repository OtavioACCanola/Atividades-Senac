/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package treino.sistema.votacao;

/**
 *
 * @author otavio.accarmo
 */
public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa (String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public void exibirInfo(){
        System.out.println("A pessoa, " + nome + ", tem " + idade + " anos.");
    }
    
}
