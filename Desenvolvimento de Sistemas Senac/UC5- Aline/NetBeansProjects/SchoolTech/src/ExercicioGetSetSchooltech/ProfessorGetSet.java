/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExercicioGetSetSchooltech;

/**
 *
 * @author otavio.accarmo
 */
public class ProfessorGetSet {
    private String nome;
    private String matricula;
    private String disciplina;
    private String telefone;
    private String email;
    
    public void setnome (String nome){
        this.nome = nome;
    }
    
    public String getnome(){
        return nome;
    }
    
    public void setmatricula (String matricula){
        this.matricula = matricula;
    }
    
    public String getmatricula(){
        return matricula;
    }
    
    public void setdisciplina(String disciplina){
        this.disciplina = disciplina;
    }
    
    public String getdisciplina(){
        return disciplina;
    }
    
    public void settelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String gettelefone(){
        return telefone;
    }
    
    public void setemail(String email){
        this.email = email;
    }
    
    public String getemail (){
        return email;
    }
}
