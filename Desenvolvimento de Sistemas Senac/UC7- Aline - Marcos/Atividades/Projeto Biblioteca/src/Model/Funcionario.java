/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author otavio.accarmo
 */
public class Funcionario implements Pagamento{
    int id;
    String nome;
    double salario;
    String cargo;

    public Funcionario(String nome, double salario, String cargo){
        this.salario = salario;
        this.nome = nome;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void mostrardados(){
        System.out.println("O funcionário " + getNome() + " tem um salário de R$ " + getSalario());
    }
    
    
    
}
    



