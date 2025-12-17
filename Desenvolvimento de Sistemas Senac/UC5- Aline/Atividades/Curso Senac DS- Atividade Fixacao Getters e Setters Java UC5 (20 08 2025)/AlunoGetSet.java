/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExercicioGetSetSchooltech;

/**
 *
 * @author otavio.accarmo
 */
public class AlunoGetSet {
    private String nome;
    private String matricula;
    private String curso;
    private String telefone;
    private String email;

    public String getnome(){
        return nome;
    }
    
    public void setnome(String nome){
        this.nome = nome;
    }
    
    public String getmatricula(){
        return matricula;
    }
    
    public void setmatricula (String matricula){
        this.matricula = matricula;
    }
    
    public String getcurso(){
        return curso;
    }
    
    public void setcurso (String curso) {
        this.curso = curso;
    }
    
    public String gettelefone () {
        return telefone;
    }
    
    public void settelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getemail (){
        return email;
    }
    
    public void setemail (String email){
        this.email = email;
    }
}

