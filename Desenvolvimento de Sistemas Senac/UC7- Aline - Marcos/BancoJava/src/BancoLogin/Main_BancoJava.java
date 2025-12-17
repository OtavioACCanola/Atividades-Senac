package BancoLogin;

import javax.swing.JOptionPane;

public class Main_BancoJava {

    public static void main(String[] args) {
        
        DAO_Usuario dao = new DAO_Usuario();
        
        String usuario = JOptionPane.showInputDialog(null, "Informe o Usuário: ");
        String senha = JOptionPane.showInputDialog(null, "Informe a Senha: ");
        
        if (dao.Autenticar(usuario, senha)){
            JOptionPane.showMessageDialog(null, "Login Realizado com Sucesso, bem-vindo "+usuario);
        }    
        else{
         JOptionPane.showMessageDialog(null, "Usuário ou Senha Incorretos. Tente Novamente!");
        }
            
    }
}
    
