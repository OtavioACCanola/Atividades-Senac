/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package herança;

/**
 *
 * @author otavio.accarmo
 */
public class Herança {
    public static void main(String[] args) {
        Raposa raposa = new Raposa ("Raposo", 17, "Onivoro");
        Floppa floppa= new Floppa ("Floppa mágica", 5, "Marrom");
    
        raposa.emitirSom();
        raposa.rouba();
        
        floppa.emitirSom();
        floppa.produzirmemes();
    }
    
}
