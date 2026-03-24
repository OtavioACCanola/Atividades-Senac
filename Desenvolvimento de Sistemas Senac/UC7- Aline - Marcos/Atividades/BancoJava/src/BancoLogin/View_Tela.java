/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BancoLogin;

import javax.swing.*;
import java.awt.*;

public class View_Tela extends JPanel{
    private JTextField TxtSenha, TxtUsuario;
    private JLabel LblSenha, LblUsuário;
    
    public View_Tela(){
        setTitle("Login de Usuário");
        setSize(350, 200);
        setLocationRelativeTo(null);
        
        JPanel janelaLogin = new JPanel();
        janelaLogin.setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
                
        JLabel LblSenha = new JLabel("Senha: ");
        JLabel LblUsuario = new JLabel("Usuário: ");
        TxtSenha = new JTextField();
        TxtUsuario = new JTextField();
        
        JButton BtnLogar = new JButton();
        DAO_Usuario dao = new DAO_Usuario();
        BtnLogar.addActionListener(e -> dao.Autenticar(TxtSenha.toString(), TxtUsuario.toString()));
        
        janelaLogin.add(LblUsuario);
        janelaLogin.add(TxtUsuario);
        janelaLogin.add(LblSenha);
        janelaLogin.add(TxtSenha);
        janelaLogin.add(BtnLogar);
        
        add(janelaLogin);
    }
}
