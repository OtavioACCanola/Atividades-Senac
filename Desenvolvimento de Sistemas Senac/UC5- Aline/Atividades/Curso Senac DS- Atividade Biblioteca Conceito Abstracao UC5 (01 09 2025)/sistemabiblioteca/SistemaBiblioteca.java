/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemabiblioteca;

/**
 *
 * @author otavio.accarmo
 */
public class SistemaBiblioteca {
    
    public static void main(String[] args) {
    
        Livro livro1= new Livro ("Java Básico", "Autor A");
        Usuario usuario1 = new Usuario("Aline", 20);
        livro1.emprestar();
        System.out.println(Livro.totalLivrosEmprestados);
        
        usuario1.apresentar();
        usuario1.pegarLivro(livro1);
        livro1.emprestar();
        livro1.devolver();
        livro1.emprestar();
        
        Funcionario f1= new Bibliotecario ("Carlos", 2000);
        f1.mostrardados();
        f1.calcularBonus();
        f1.ProcessarPagamento(f1.getSalario());
        
        Funcionario f2 = new Gerente ("Bernardo", 4000);
        f2.mostrardados();
        f2.calcularBonus();
        f2.ProcessarPagamento(f2.getSalario());
        
        // Teste Emprestar
//        livro1.emprestar();
//        livro1.emprestar();
//        livro1.emprestar();
//        livro1.emprestar();
//        livro1.emprestar();
//        livro1.emprestar();
//        
        
        /* Teste Devolver
        livro1.devolver();
        */

        /* Teste Apresentar Usuário
        usuario1.apresentar();
        */

        /* Teste ProcessarPagamento
        Funcionario f1 = new Gerente("Aline", 2000.0);
        f1.ProcessarPagamento(f1.getSalario());
        */
        
        /* Teste Mostrar Dados Funcionário
        Funcionario f2 = new Bibliotecario ("Augusto", 1500.0);
        f2.mostrardados();
        */
    }
}
 


