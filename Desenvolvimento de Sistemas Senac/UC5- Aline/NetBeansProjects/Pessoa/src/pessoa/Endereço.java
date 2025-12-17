/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pessoa;

/**
 *
 * @author otavio.accarmo
 */
public class Endereço {

    public static void main(String[] args) {
        
        CEP objP01 = new CEP();
        objP01.setPais("Brasil");
         System.out.println(objP01.getPais());
         
         objP01.setEstado("São Paulo");
         System.out.println(objP01.getEstado());
         
         objP01.setCidade("São Paulo");
         System.out.println(objP01.getCidade());
         
         objP01.setBairro("Jardim Catanduva");
         System.out.println(objP01.getBairro());
         
         objP01.setnome_rua("Rua Doutor Renato Bueno Neto");
         System.out.println(objP01.getnome_rua());
         
         objP01.setComplemento("Rua da feira");
         System.out.println(objP01.getComplemento());
         
         objP01.setTipo("Casa");
         System.out.println(objP01.getTipo());
         
         objP01.setCodigo("05767-350");
         System.out.println(objP01.getCodigo());
    }
}
    
