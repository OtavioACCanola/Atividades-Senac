/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exerciciosfixacaopoo;

import java.util.Scanner;
/**
 *
 * @author otavio.accarmo
 */
public class ExercicioSoma {
    
    public void pedirNumero(){
        Scanner Entrada = new Scanner(System.in);
        
        int Numero1 = Entrada.nextInt();
        int Numero2 = Entrada.nextInt();
        
        int Soma = Numero1 + Numero2;
        StringBuilder Texto = new StringBuilder("A soma dos números ");
        Texto.append(Numero1);
        Texto.append("+");
        Texto.append(Numero2);
        Texto.append("=");
        Texto.append(Soma);
    }
}
