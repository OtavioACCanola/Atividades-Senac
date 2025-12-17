/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exerciciosfila;

import java.util.Queue;
import java.util.LinkedList;


public class ExerciciosFila {
    
    public static void main(String[] args) {
    Queue <String> fila = new LinkedList();
    
//  Adicionar Elementos:
    fila.add("Ana"); 
    fila.add("Bruno");
    fila.add("Carla");
    fila.add("Diego");
    
//  Verificar Fila
    System.out.println("Sua fila: "+ fila);
    
//  Remover Elementos    
    String atendido = fila.poll(); // Remove e mostra o Primeiro Elemento
    System.out.println("Foi atendido(a): "+ atendido);
    System.out.println("Sua Fila sem o Primeiro Elemento: "+ fila);
    String atendido2 = fila.poll(); // Remove e mostra o Primeiro Elemento
    System.out.println("Foi atendido(a): "+ atendido2);
    System.out.println("Sua fila Agora: "+ fila);
    System.out.println("Próximo da Fila: "+ fila.peek());
    }
    
}
