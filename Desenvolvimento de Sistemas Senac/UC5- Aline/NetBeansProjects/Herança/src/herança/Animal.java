/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herança ;

// Classe base (superclasse = Classe pai)
class Animal {
    
    String nome;
    int idade;

/* Contrutor: Todo método (Ação) construtor tem o mesmo nome da classe, nesse caso 'Animal', podendo ou não ter 1 ou mais parâmetros (instruções dentro 
    dos parenteses)*/
    public Animal(String nome, int idade) {
        this.nome = nome;
        this.idade= idade;
    }

// Ação
    public void emitirSom(){
        System.out.println("O animal faz um som.");
    }
}