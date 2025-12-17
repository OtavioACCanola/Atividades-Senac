/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pessoa;

import javax.swing.JOptionPane; // Implementação, da biblioteca do Java, que cria pop-ups na tela
        
/**
 *
 * @author otavio.accarmo
 */
 /*
public class ProjetoInicio2 {

    public static void main(String[] args) {
        System.out.println("Hello World!"); // Esse comando é usado para escrever algo na tela. Podemos usar o comando 
        System.out.println("Olá Mundo!"); //''ln'' faz pular uma linha para se tiver mais algo embaixo para escrever ele pula uma linha
    }   
*/   

public class ProjetoInicio2 {
    
     public static void main(String[] args) {
         
         Pessoa objP01 = new Pessoa();
         objP01.setNome(JOptionPane.showInputDialog(null, "Informe seu nome: "));
         objP01.setIdade(Integer.parseInt(JOptionPane.showInputDialog(null, "Informe sua idade: ")));
         JOptionPane.showMessageDialog(null, "Olá "+ objP01.getNome() + ", a idade informada foi " +objP01.getIdade() + " anos." );
         objP01.setCpf("509.163.718.40");
         System.out.println(objP01.getCpf());
         objP01.setGenero("Feminino");
         System.out.println(objP01.getGenero());
         objP01.setPeso(70.00f);
         System.out.println(objP01.getPeso());
         
         Pessoa objP02 = new Pessoa();
         objP02.setNome("Otávio");
         System.out.println(objP02.getNome());
         objP01.setIdade(18);
         System.out.println(objP01.getIdade());
         objP01.setCpf("509.163.718.40");
         System.out.println(objP01.getCpf());
         objP01.setGenero("Masculino");
         System.out.println(objP01.getGenero());
         objP01.setPeso(83.70f);
         System.out.println(objP01.getPeso());
         
         CEP objP03 = new CEP();
         objP03.setPais("Brasil");
         System.out.println(objP03.getPais());
         
         objP03.setEstado("São Paulo");
         System.out.println(objP03.getEstado());
         
         objP03.setCidade("São Paulo");
         System.out.println(objP03.getCidade());
         
         objP03.setBairro("Jardim Catanduva");
         System.out.println(objP03.getBairro());
         
         objP03.setnome_rua("Rua Doutor Renato Bueno Neto");
         System.out.println(objP03.getnome_rua());
         
         objP03.setComplemento("Rua da feira");
         System.out.println(objP03.getComplemento());
         
         objP03.setTipo("Casa");
         System.out.println(objP03.getTipo());
         
         objP03.setCodigo("05767-350");
         System.out.println(objP03.getCodigo());
    }
 
}

