/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atividade_nivel_desafio_banco;

/**
 *
 * @author otavio.accarmo
 */
public class Atividade_Nivel_Desafio_Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Conta c1 = new ContaCorrente("Otávio", 999.0f);
      
    c1.sacar(8000);
    c1.sacar(8);
    c1.sacar(8);
    c1.sacar(4);
    
    c1.depositar(79);
}
}