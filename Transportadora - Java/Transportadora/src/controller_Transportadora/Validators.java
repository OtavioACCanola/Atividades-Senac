package controller_Transportadora;

public class Validators {

    public static boolean isBlank(String s) {
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
