/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aulasjava;

/**
 *
 * @author otavio.accarmo
 */
public class Contatos {
    private String Nome;
    private String Telefone;

    public Contatos(String Nome, String Telefone){
        this.Nome = Nome;
        this.Telefone = Telefone;
    }
    
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }
    
    public String toString(){
        return "Nome: "+ this.Nome +", Telefone: "+ this.Telefone;

    }
    
}
