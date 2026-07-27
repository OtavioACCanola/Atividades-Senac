/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author otavio.accarmo
 */
public class Usuario {
    private int id;
    private String nome;
    private int idade;
    private int livrosEmprestados = 0;
    
    public Usuario (int Id, String nome, int idade){
        setId(Id);
        setNome(nome);
        setIdade(idade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public void apresentar(){
        System.out.println("Olá " + getNome() + " , vimos que você tem "+ getIdade() + " anos!");
    }
     
    public void pegarLivro(Livro livro){
        if (livrosEmprestados < Biblioteca.MAX_LIVROS_POR_USUARIO){
            livro.emprestar();
            livrosEmprestados++;
        }
        else {
            System.out.println(nome + " atingiu o limite de livros emprestados!");
        }
    }
    
    public void devolverLivro (Livro livro) {
        livro.devolver();
        if (livrosEmprestados > 0) {
            livrosEmprestados--;
        }
    }
    
    public String toString() {
        return this.nome;
    }
}