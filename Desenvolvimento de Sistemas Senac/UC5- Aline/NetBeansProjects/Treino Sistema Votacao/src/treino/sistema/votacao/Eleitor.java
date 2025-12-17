/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package treino.sistema.votacao;

/**
 *
 * @author otavio.accarmo
 */
public class Eleitor {
    private boolean jaVotou; 

    public boolean isJaVotou() {
        return jaVotou;
    }

    public void setJaVotou(boolean jaVotou) {
        this.jaVotou = jaVotou;
    }
    
    private void votar(){
        jaVotou = true;
    }
}
