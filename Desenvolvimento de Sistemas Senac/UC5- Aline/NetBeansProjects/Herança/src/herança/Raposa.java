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
public class Raposa extends Animal{
    String dieta;
    
    /* Contrutor: Todo método (Ação) construtor tem o mesmo nome da classe, nesse caso 'Animal', podendo ou não ter 1 ou mais parâmetros (instruções dentro 
    dos parenteses)*/
    public Raposa(String nome, int idade, String raca){
            super (nome, idade); // O super chama o construtor da superclasse
            this.dieta = dieta;
    }
    
    @Override // Sobrescrita das informações do método (método da classe pai)
    public void emitirSom(){
        System.out.println(nome + " está chiando: Ack Ack!");
    }
    public void rouba(){
        System.out.println(nome + " está roubando.");
    }
}
