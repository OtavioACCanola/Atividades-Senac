/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

// Atividade 1 - Iniciante 

package Atividade_Nível_Fácil_animalpetshop;

/**
 *
 * @author otavio.accarmo
 */
public class PetShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     AnimalPetshop aml1 = new AnimalPetshop ("Pablo", "Pinguim");
     AnimalPetshop aml2 = new AnimalPetshop ("Olívia", "Cachorro");
     
     aml1.mostrarDados();
     aml2.Atender();
    }
}
