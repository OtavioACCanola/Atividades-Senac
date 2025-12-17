/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// Atividade 1 - Iniciante 

package Atividade_Nível_Fácil_animalpetshop;

/**
 *
 * @author otavio.accarmo
 */
 
public class AnimalPetshop {
    private String nome;
    private String especie;
    private boolean atendido;

    public AnimalPetshop(String nome, String especie){
            this.nome = nome;
            this.especie = especie;
        }
            
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }
    
    public void Atender(){
        System.out.println("Muito obrigado por confiar seu animalzinho a nós! Seu bichinho já foi atendido! ;)");
        atendido = true;
    }   
    
    public void mostrarDados(){
        System.out.println("Os dados desse amimal são estes:\nNome do Animal: " + getNome()+ "\nEspecie: " + getEspecie());
    }
    
}
