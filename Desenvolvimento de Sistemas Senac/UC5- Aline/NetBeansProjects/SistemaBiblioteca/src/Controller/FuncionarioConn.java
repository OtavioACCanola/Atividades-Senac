/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Bibliotecario;
import Model.Gerente;
import DAO.FuncionarioDAO;
import View.GUI_Funcionarios;

public class FuncionarioConn extends GUI_Funcionarios{
    
    private FuncionarioDAO funcdao = new FuncionarioDAO();

    public FuncionarioDAO getFuncDao() {
        return funcdao;
    }

    public void setDao(FuncionarioDAO dao) {
        this.funcdao = dao;
    }
    
    public void cadastrarFuncionario(String Nome, double Salario, String Cargo){
                   
           getFuncDao().InserirFuncionario(Nome, Salario, Cargo);
    }
}
