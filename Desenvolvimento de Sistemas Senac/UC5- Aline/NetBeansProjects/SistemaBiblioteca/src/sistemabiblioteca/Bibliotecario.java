/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabiblioteca;

/**
 *
 * @author otavio.accarmo
 */
public class Bibliotecario extends Funcionario {
    
    public Bibliotecario (String nome, float salario){
        super (nome, salario);
    }
    
    @Override
    public double calcularBonus(){
         double bonus = salario * 0.1;
         System.out.println(nome + " recebeu bônus de R$ " + bonus);
         return bonus;
    }
    
    @Override
    public void ProcessarPagamento(double valor){
        double bonus = calcularBonus();
        double pagamento = valor + bonus;
        System.out.println(nome + " recebeu o bônus é de R$ " + bonus);
        System.out.println("Pagamento processado para o bibliotecário " + nome + ": R$ " + pagamento);
    }
}
