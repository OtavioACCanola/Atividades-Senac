/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Usuario;
import View.GUI_Livros;
import DAO.UsuarioDAO;

public class UsuarioConn {
    UsuarioDAO dao = new UsuarioDAO();

    public UsuarioDAO getDao() {
        return dao;
    }

    public void setDao(UsuarioDAO dao) {
        this.dao = dao;
    }
    
    public void cadastrarUsuario(String Nome, int Idade){
        
           
           getDao().CriarUsuario(Nome, Idade);
           
    }
    
    public void listarUsuario(){
        
        
        getDao().listarUsuarios();
    }
}
