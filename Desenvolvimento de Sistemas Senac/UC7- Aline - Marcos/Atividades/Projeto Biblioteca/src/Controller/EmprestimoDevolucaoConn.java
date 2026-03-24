/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.EmprestimoDAO;
import Model.Emprestimo;
import java.util.List;

public class EmprestimoDevolucaoConn {
    
    private EmprestimoDAO dao = new EmprestimoDAO();

    public EmprestimoDAO getDao() {
        return dao;
    }

    public void setDao(EmprestimoDAO dao) {
        this.dao = dao;
    }
    
    public void cadastrarEmprestimo(int IdUsuario, int IdLivro){
                   
           getDao().emprestar(IdUsuario, IdLivro);
    }
    
    public void devolverLivro(int IdUsuario, int IdLivro) {
        
        getDao().devolver(IdUsuario, IdLivro);
    }
    
    public void ListarEmprestimos(int id){
        
        getDao().listarEmprestimos(id); 
    }
}
