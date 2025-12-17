/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabiblioteca;

/**
 *
 * @author otavio.accarmo
 */
class Gerente extends Funcionario {  
   
    public Gerente (String nome, double salario) {
        super (nome, salario);
                
    }
    
    @Override
    public double calcularBonus(){
    double bonus = getSalario() * 0.2;
    return bonus;
    }
    
   @Override
    public void ProcessarPagamento(double valor){
        double bonus = calcularBonus();
        double pagamento = valor + bonus;
        System.out.println(nome + " recebeu o bônus é de R$ " + bonus);
        System.out.println("Pagamento processado para o gerente " + nome + ": R$ " + pagamento);
    }    
}
