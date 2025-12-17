/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exerciciosvetores;

import java.util.ArrayList;
import java.util.Scanner;

public class ExerciciosVetores {
    
public static void main(String[] args) {
        
        //Vetor 10 Números Inteiros
        int[] numeros = new int[10];
        Scanner pedir_numero = new Scanner(System.in);
        System.out.println("Informe os Valores que Deseja colocar no vetor:");
        System.out.print("Digite o 1º Número para colocar na lista: ");
        int numero1 = pedir_numero.nextInt();
        numeros[0] = numero1;
        System.out.print("Digite o 2º Número para colocar na lista: ");
        int numero2 = pedir_numero.nextInt();
        numeros[1] = numero2;
        System.out.print("Digite o 3º Número para colocar na lista: ");
        int numero3 = pedir_numero.nextInt();
        numeros[2] = numero3;
        System.out.print("Digite o 4º Número para colocar na lista: ");
        int numero4 = pedir_numero.nextInt();
        numeros[3] = numero4;
        System.out.print("Digite o 5º Número para colocar na lista: ");
        int numero5 = pedir_numero.nextInt();
        numeros[4] = numero5;
        System.out.print("Digite o 6º Número para colocar na lista: ");
        int numero6 = pedir_numero.nextInt();
        numeros[5] = numero6;
        System.out.print("Digite o 7º Número para colocar na lista: ");
        int numero7 = pedir_numero.nextInt();
        numeros[6] = numero7;
        System.out.print("Digite o 8º Número para colocar na lista: ");
        int numero8 = pedir_numero.nextInt();
        numeros[7] = numero8;
        System.out.print("Digite o 9º Número para colocar na lista: ");
        int numero9 = pedir_numero.nextInt();
        numeros[8] = numero9;
        System.out.print("Digite o 10º Número para colocar na lista: ");
        int numero10 = pedir_numero.nextInt();
        numeros[9] = numero10;
        
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
      
        //Soma
        System.out.println("--Sistema de Soma--\n");
        int soma = 0;
        for (int num : numeros){
            soma += num;
        }
        System.out.println("A soma de todos os números da lista é de: "+soma);
    
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println("--Sistema de Maior ou Menor--\n");
        int menor = numeros[0];
        int maior = numeros[0];
        
        for (int num : numeros){
            if (num < menor){
                menor = num;
            }
            else if (maior < num){
                maior = num;
            }
        }
        System.out.println("O menor número é "+ menor + " e o maior é o " + maior);
            
        }
        
}


