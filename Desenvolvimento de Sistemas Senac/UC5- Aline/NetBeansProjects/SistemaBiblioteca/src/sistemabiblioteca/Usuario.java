/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabiblioteca;

/**
 *
 * @author otavio.accarmo
 */
public class Usuario {
    private String nome;
    private int idade;
    private int livrosEmprestados = 0;
    
    public Usuario (String nome, int idade){
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

    public int getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(int livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }
    
    public void apresentar(){
        if (idade >= 18) {
            System.out.println("Olá " +nome+ " tudo bem! Já como você é maior de 18 anos, você poderá ter acesso a livros maiores de idade!");
        }
        else {
            System.out.println("Olá" +nome+ "tudo bem! Você ainda é menor de idade, pois tem " + idade + " anos, então seu acesso será limitado");
        }
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
}