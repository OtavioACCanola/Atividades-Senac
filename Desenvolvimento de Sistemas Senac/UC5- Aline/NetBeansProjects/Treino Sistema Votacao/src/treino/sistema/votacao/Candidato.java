/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package treino.sistema.votacao;

/**
 *
 * @author otavio.accarmo
 */
public class Candidato extends Pessoa{
        private int numero; 

    public Candidato (String nome, int idade, int numero){
        super(nome,idade);
        this.numero = numero;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    @Override
    public void exibirInfo(){
        System.out.println("O candidato, " + getNome() + ", tem " + getIdade() + " anos e possui o número eleitoral " + getNumero() + ".");
    }
}
