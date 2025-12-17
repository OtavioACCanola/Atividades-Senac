/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade_nivel_desafio_banco;

/**
 *
 * @author otavio.accarmo
 */
public class ContaCorrente extends Conta{
    static int totalSaques;
    static final int MAX_SAQUES = 3;
    static final double TAXA_SAQUE = 2.5;
        
    public ContaCorrente (String titular, float salario){
        super (titular, salario);
    }
    
    @Override
    public void sacar(double valor){
        if (totalSaques < 3){
           System.out.println("Saque efetuado com sucesso! Retire seu dinheiro abaixo!");
           totalSaques++;
        }
        else {
            System.out.println("Não é possível fazer mais do que 3 saques");
        }
    }
    
    @Override
    public void depositar(double valor){
        System.out.println("Deposito efeituado com sucesso!");
    }
}


