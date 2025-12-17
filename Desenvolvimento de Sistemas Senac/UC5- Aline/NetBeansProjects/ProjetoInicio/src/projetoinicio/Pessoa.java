/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoinicio;

/** 
 *
 * @author otavio.accarmo
 */
public class Pessoa {
    public String nome;
    
    public void definirNome(String novoNome){
        nome= novoNome;
    }
    
    public String pegarNome(){
        return nome;
    }
}
