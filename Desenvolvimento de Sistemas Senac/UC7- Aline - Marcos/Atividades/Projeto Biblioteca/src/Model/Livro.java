/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author otavio.accarmo
 */
public class Livro extends Biblioteca{
    private int id;
    private String titulo;
    private String autor;
    private int quantidade;
    private boolean disponível;
    static int totalLivrosEmprestados;
    
    public Livro(int Id, String Titulo, String Autor, int Quantidade){
        setId(Id);
        setTitulo(Titulo);
        setAutor(Autor);
        setQuantidade(Quantidade);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void emprestar(){
        if (isDisponível()){
            System.out.println(titulo + " foi emprestado com sucesso!");
            disponível = false;
            totalLivrosEmprestados ++;
            quantidade -=  1;
        }
        else {
            System.out.println(titulo + " não está disponível");
        }
    }
    
    public void devolver(){
        if (!isDisponível()) {
            System.out.println(titulo + " foi devolvido com sucesso, muito obrigado por devolver!");
            disponível = true;
            
            quantidade += 1;
    }   
    else {
        System.out.println(titulo + " já está disponível.");
    }
        
    }
    
   @Override
   public String toString(){
        return this.titulo;
}
    
}