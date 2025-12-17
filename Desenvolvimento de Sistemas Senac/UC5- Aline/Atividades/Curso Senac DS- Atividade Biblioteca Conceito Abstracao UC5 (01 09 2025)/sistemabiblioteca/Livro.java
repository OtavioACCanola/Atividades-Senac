/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemabiblioteca;

/**
 *
 * @author otavio.accarmo
 */
public class Livro extends Biblioteca{
    private String titulo;
    private String autor;
    private boolean disponível;
    static int totalLivrosEmprestados;
    
    public Livro(String Titulo, String Autor){
        setTitulo(Titulo);
        setAutor(Autor);
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getTitulo(){
            return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponível() {
        return disponível;
    }

    public void setDisponível(boolean disponível) {
        this.disponível = disponível;
    }
    
    public void getEmprestimos(){
        System.out.println("O total de livros emprestados é de: " + totalLivrosEmprestados);
    }
    
    public void emprestar(){
        if (isDisponível()){
            System.out.println(titulo + " foi emprestado com sucesso!");
            disponível = false;
            totalLivrosEmprestados ++;
        }
        else {
            System.out.println(titulo + " não está disponível");
        }
    }
    
    public void devolver(){
        if (!isDisponível()) {
            System.out.println(titulo + " foi devolvido com sucesso, muito obrigado por devolver!");
            disponível = true;
    }   
    else {
        System.out.println(titulo + " já está disponível.");
    }
}
    
}
