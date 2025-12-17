/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
// DICA: Escrever os códigos a mão para treinar e entender o funcionamento da orientação a objeto

package escola;

import javax.swing.JOptionPane; //Importação de um programa do java para criar paineis para seu sistema

public class Escola {

    public static void main(String[] args) {
        
        System.out.println("Alunos");
     
        System.out.println("------------------------Aluno1--------------------------------------");
        
        Aluno objA01 = new Aluno();
        objA01.setNome("Otávio");
        System.out.println(objA01.getNome());
        objA01.setMatricula("0001234567890-1");
        System.out.println(objA01.getMatricula());
        objA01.setCurso("Desenvolvimento de Sistemas");
        System.out.println(objA01.getCurso());
        objA01.setTelefone("4002-8922");
        System.out.println(objA01.getTelefone());
        objA01.setEmail("otavio.augusto@gmail.com");
        System.out.println(objA01.getEmail());
        
        System.out.println("------------------------Aluno2--------------------------------------");
      
        Aluno objA02 = new Aluno();
        objA02.setNome("Pedro");
        System.out.println(objA02.getNome());
        objA02.setMatricula("0001234567897-1");
        System.out.println(objA02.getMatricula());
        objA02.setCurso("Culinária");
        System.out.println(objA02.getCurso());
        objA02.setTelefone("4090-8340");
        System.out.println(objA02.getTelefone());
        objA02.setEmail("pedro.araujo@gmail.com");
        System.out.println(objA02.getEmail());
        
        System.out.println("------------------------Aluno3--------------------------------------");
      
        Aluno objA03 = new Aluno();
        objA03.setNome("João");
        System.out.println(objA03.getNome());
        objA03.setMatricula("0001234567895-1");
        System.out.println(objA03.getMatricula());
        objA03.setCurso("ADM");
        System.out.println(objA03.getCurso());
        objA03.setTelefone("5842-8690");
        System.out.println(objA03.getTelefone());
        objA03.setEmail("joao.soares@gmail.com");
        System.out.println(objA03.getEmail());
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Professores");
        
        System.out.println("------------------------Professor1--------------------------------------");
        
        Professor objP01 = new Professor();
        objP01.setNome("Aline");
        System.out.println(objP01.getNome());
        objP01.setMatricula("0001234567892-1");
        System.out.println(objP01.getMatricula());
        objP01.setDisciplina("Desenvolvimento de Sistemas");
        System.out.println(objP01.getDisciplina());
        objA01.setTelefone("99995-4899");
        System.out.println(objP01.getTelefone());
        objP01.setEmail("aline.santos@gmail.com");
        System.out.println(objP01.getEmail());
        
        System.out.println("------------------------Professor2--------------------------------------");
        
        Professor objP02 = new Professor();
        objP02.setNome("Marcos");
        System.out.println(objP02.getNome());
        objP02.setMatricula("0001234567884-1");
        System.out.println(objP02.getMatricula());
        objP02.setDisciplina("Culinária");
        System.out.println(objP02.getDisciplina());
        objP02.setTelefone("94895-4834");
        System.out.println(objP02.getTelefone());
        objP02.setEmail("marcos.ferreira@gmail.com");
        System.out.println(objP02.getEmail());
        
        System.out.println("------------------------Professor3--------------------------------------");
        
        Professor objP03 = new Professor();
        objP03.setNome("Isabella");
        System.out.println(objP03.getNome());
        objP03.setMatricula("0001234567789-1");
        System.out.println(objP03.getMatricula());
        objP03.setDisciplina("ADM");
        System.out.println(objP03.getDisciplina());
        objP03.setTelefone("40995-7095");
        System.out.println(objP03.getTelefone());
        objP03.setEmail("isabella.oliveira@gmail.com");
        System.out.println(objP03.getEmail());
    }
}
