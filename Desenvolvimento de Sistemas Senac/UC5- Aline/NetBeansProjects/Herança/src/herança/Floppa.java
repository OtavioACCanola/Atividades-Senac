/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herança;

/**
 *
 * @author otavio.accarmo
 */

//SubClasse pois é herdeira da classe pai, tendo todas as informações da classe pai (Animal)
public class Floppa extends Animal {
    String pelagem;
        
    /* Contrutor: Todo método (Ação) construtor tem o mesmo nome da classe, nesse caso 'Animal', podendo ou não ter 1 ou mais parâmetros (instruções dentro 
    dos parenteses)*/
    public Floppa (String nome, int idade, String pelagem) {
        super(nome, idade); // O super chama o construtor da superclasse
        this.pelagem = pelagem;
    }
    
    @Override // Sobrescrita das informações do método (método da classe pai)
    public void emitirSom(){
        System.out.println(nome + " está hablando: Po po po pow!");
    }
    public void produzirmemes(){
        System.out.println(nome+" está produzindo memes, Let's Go");
    }
}
