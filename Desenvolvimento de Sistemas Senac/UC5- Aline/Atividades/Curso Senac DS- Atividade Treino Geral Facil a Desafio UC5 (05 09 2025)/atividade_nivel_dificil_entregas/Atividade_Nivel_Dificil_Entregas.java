/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atividade_nivel_dificil_entregas;

/**
 *
 * @author Dell
 */
public class Atividade_Nivel_Dificil_Entregas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Caminhoneiro Silvio = new Caminhoneiro("Silvio", 7.99f);
       Silvio.calcularTaxas();
       Silvio.processarPagamento(3000);
       Motoboy Renan = new Motoboy ("Renan", 6.99f);
       Renan.calcularTaxas();
       Renan.processarPagamento(1500);
    }
    
}
