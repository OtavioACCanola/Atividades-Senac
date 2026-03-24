// Fazer a controller Livro: Juntar a Model e a View
// Fazer a controller Usuario: Juntar a Model e a View
// Fazer a controller Funcionario: Juntar a Model e a View

package Controller;

import Model.Livro;
import View.GUI_Livros;
import DAO.LivroDAO;

public class LivroConn extends GUI_Livros{
    private LivroDAO dao = new LivroDAO();

    public LivroDAO getDao() {
        return dao;
    }

    public void setDao(LivroDAO dao) {
        this.dao = dao;
    }
    
    public void cadastrarLivro(String Titulo, String Autor, int Quantidade){
                   
           getDao().Inserir(Titulo, Autor, Quantidade);
    }
    
    public void listarLivro(){
        
        getDao().listarLivroComboBox();
    }
}

    
    
    

