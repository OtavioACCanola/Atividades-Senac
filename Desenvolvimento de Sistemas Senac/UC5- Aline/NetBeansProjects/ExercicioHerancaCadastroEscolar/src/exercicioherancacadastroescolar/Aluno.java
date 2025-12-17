/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicioherancacadastroescolar;

/**
 *
 * @author otavio.accarmo
 */
public class Aluno extends Pessoa {
    String matricula;

    public Aluno(String nome, int idade, String matricula) {
          super(nome, idade);
          this.matricula = matricula;
    }
    @Override
    public void exibirinformacoes(){
        System.out.println("O aluno(a) " + nome + " foi matriculado(a) na escola, ele(a) tem " + idade + " anos e seu número de matricula é: "+ "1090789-A");
    }
}

