/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exerciciosvetores;

import java.util.Scanner;

public class AtividadePrateleiras {

   public static void main(String[] args) {
        Scanner infNum = new Scanner(System.in);
        int[][][] produto = new int[3][4][3]; // Primeiro Valor Prateleira e Segundo Valor Produto
        int sessao = 1;
        int somaT = 0;
        int somaSes1 = 0 ;
        int somaSes2 = 0;
        int somaSes3 = 0;
        
        // Texto que Aparece no Começo
        System.out.println("-- Informe a Quantidade de Produtos em Cada Prateleira --\n");
        System.out.println("-----------------------------------");
        System.out.println("**OBS:** \nNúmeros de Sessões: 3 \nNumeros de Prateleiras: 4");
        System.out.println("-----------------------------------\n");

        // Loop da Sessão, Prateleira e Produto
        for (int k = 0; k < 3; k++){ // Loop Sessão
            System.out.println("=-=-=-= Sessão "+(k+1)+" =-=-=-=\n");
            for (int i= 0; i < 4; i++){  // Loop Prateleira
                System.out.println("==== Prateleira "+(i+1)+" ====\n");
                for(int j=0; j < 3; j++){ // Loop Produto
                    System.out.println("---- produto "+(j+1)+"----");
                    produto[k][i][j] = infNum.nextInt();
                }
                System.out.println("\n-x-x-x-x- Prateleira "+(i+1)+" Preenchida! -x-x-x-x-\n");
            }
            System.out.println("\n----Sessão "+(k+1)+" Preenchida!----\n");
        }
        System.out.println("Sua prateleira está assim: ");
       
        for(int k = 0; k < 3; k++){
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 3; j++){
                    System.out.println(produto[k][i][j] + "");
                }
            }
        }
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
//      Quantidade Sessões Armazem:
        System.out.println("\n*_*_*_*_*Quantidade de Produtos em cada Sessão*_*_*_*_*");
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 3; j++){ 
        somaSes1 += produto[0][i][j];
        somaSes2 += produto[1][i][j];
        somaSes3 += produto[2][i][j];
                }
            }  
        System.out.println("Soma Sessão 1: " + somaSes1);
        System.out.println("Soma Sessão 2: " + somaSes2);
        System.out.println("Soma Sessao 3: "+ somaSes3);
        
//      Quantidade Total Armazem
        System.out.println("\n*_*_*_*_*Soma Total de Produtos Armazem*_*_*_*_*");
        for (int k = 0; k < 3; k++){
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 3; j++){
                somaT += produto[k][i][j];
               
                }
            }
        }
        System.out.println("Soma Total: "+ somaT);  
        
        // Maior e Menor Prateleira
        System.out.println("\n*_*_*_*_* Menor e Maior Valor Prateleiras *_*_*_*_*\"");
        for (int k = 0; k < 3; k++){
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 3; j++){
                }
            }
        }
        
        int menor = produto[2][3][2];
        int maior = produto[0][0][0];
        for (int k = 0; k < 3; k++){ // Loop Sessão
            for (int i= 0; i < 4; i++){  // Loop Prateleira
                for(int j=0; j < 3; j++){ // Loop Produto
                if(produto[k][i][j] < menor){
                       menor = produto[k][i][j];
                    }
                    else if(produto[k][i][j] > maior){
                        maior = produto[k][i][j];
                }
            }
        }
        }
        System.out.println("Menor Valor: "+ menor);
        System.out.println("Maior Valor: "+ maior);
    }
}
