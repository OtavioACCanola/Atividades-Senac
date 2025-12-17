/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aulasjava;

import java.util.Scanner; // Passo 1: Importar a classe Scanner

public class Teste {
    Scanner scanner = new Scanner(System.in);
    
    public class teste{
        private int valorPagar;
        private int valorPagamento;

    public int getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(int valorPagar) {
        this.valorPagar = valorPagar;
    }

    public int getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(int valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public void pagar(){
        int valorTotal = 0;
        valorTotal += valorPagar;
        
        if(valorPagamento == valorPagar){
            System.out.println("Produto pago com sucesso");
        }
        else{
            while (valorPagamento < valorPagar){
                int falta = valorPagar - valorPagamento;
                System.out.println("Falta pagar: " + falta + "\nDigite os valores faltantes: ");
                Scanner scanner = new Scanner(System.in);
                int valorFaltante = scanner.nextInt();
                valorTotal += valorFaltante;
            }
                if (valorPagamento > valorPagar){
                    float troco= valorPagar - valorPagamento;
                   System.out.println("Você tem um troco de: "+troco);
               }
                else{
                    System.out.println("Produto pago com sucesso");
               }
        }
    
    

