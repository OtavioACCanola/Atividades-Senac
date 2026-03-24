/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author otavio.accarmo
 */
public class Bibliotecario extends Funcionario {
    
    public Bibliotecario (String Nome, double Salario, String Cargo){
        super (Nome, Salario, Cargo);
    }
    
    public double calcularBonus(){
         double bonus = salario * 0.1;
         System.out.println(nome + " recebeu bônus de R$ " + bonus);
         return bonus;
    }
    
    @Override
    public void ProcessarPagamento(double salario){
        double bonus = calcularBonus();
        double pagamento = salario + bonus;
        System.out.println(getNome() + " recebeu bônus do R$ " + bonus);
        System.out.println("Pagamento processado para Bibliotecário: \n"+ getNome() + ": R$ "+ pagamento);
    }
    
}
