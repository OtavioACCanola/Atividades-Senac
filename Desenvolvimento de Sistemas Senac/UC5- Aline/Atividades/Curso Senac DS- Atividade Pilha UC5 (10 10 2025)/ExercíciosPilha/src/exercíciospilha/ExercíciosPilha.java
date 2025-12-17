/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercíciospilha;

import java.util.Stack;

public class ExercíciosPilha {
    
    public static void main(String[] args) {
        Stack <String> pilha = new Stack<>();
        
        pilha.add("10");
        pilha.add("20");
        pilha.add("30");
        pilha.add("40");
        pilha.add("50");
        
        System.out.println("Sua Pilha: "+pilha);
        pilha.pop();
        pilha.pop();
        System.out.println("Sua Pilha com dois Topos Removidos: "+pilha);
        System.out.println("Novo Topo da Pilha: "+pilha.lastElement());

    }
}

