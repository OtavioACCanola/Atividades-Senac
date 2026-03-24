/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testefinanceiropi;

public class TesteFinanceiroPI {

    public static void main(String[] args) {
        Compra dipirona = new Compra(9.0f, "Dipirona", 4);
        Financeiro dinheiro = new Financeiro();
        
        dipirona.comprar(9.0f);
        System.out.println("O financeiro tem: "+dinheiro.getSaldo());
    }
    
}
