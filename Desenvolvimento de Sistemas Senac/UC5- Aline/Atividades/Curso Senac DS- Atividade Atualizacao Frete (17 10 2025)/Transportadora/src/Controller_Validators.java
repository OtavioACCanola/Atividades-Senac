/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Dell
 */
public class Controller_Validators {
    
    public static boolean isBlack(String s) {
        return s == null || s.trim().isEmpty();
    }
    
     public static boolean cpfValido(String cpf) {
        if (cpf == null) {
            return false;
        }
        String d = cpf.replaceAll("[^0-9]", "");
        return d.length() == 11;
    }

    public static boolean cnpjValido(String cnpj) {
        if (cnpj == null) {
            return false;
        }
        String d = cnpj.replaceAll("[^0-9]", "");
        return d.length() == 14;
    }
}

