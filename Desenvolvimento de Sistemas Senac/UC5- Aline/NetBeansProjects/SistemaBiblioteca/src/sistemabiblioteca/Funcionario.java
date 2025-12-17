/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabiblioteca;

/**
 *
 * @author otavio.accarmo
 */
abstract class Funcionario implements Pagamento{
    String nome;
    double salario;

    public Funcionario(String nome, double salario){
    this.salario = salario;
    this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    abstract double calcularBonus();

    public void mostrardados(){
        System.out.println("O funcionário " + getNome() + " tem um salário de R$ " +salario);
    }
    
    public void ProcessarPagamento(double valor){
        System.out.println("Processando o pagamento do bibliotecario no valor de R$ " + valor);
    }
}
    



