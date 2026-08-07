/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aulasjava;

import javax.swing.*;
import java.awt.*;

class TelaDesafioNotaAlunos extends JFrame{
    private JTextField TxtNomeAluno, TxtNota1Bimestre, TxtNota2Bimestre, TxtNota3Bimestre, TxtNota4Bimestre;  
    private JLabel lblVerificar;
    
    public TelaDesafioNotaAlunos(){
        setTitle("Calculo Nota Anual");
        setSize(350, 200);
        setLocationRelativeTo (null);
        
        JPanel panelNotasAlunos = new JPanel();
        panelNotasAlunos.setLayout(new GridLayout(6, 3, 10, 10));
         setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JLabel lblNomeAluno = new JLabel ("Nome do Aluno:");
        JLabel lblNotaPrimeiroBimestre = new JLabel("Nota 1º Bimestre:");
        JLabel lblNotaSegundoBimestre = new JLabel ("Nota 2º Bimestre:");
        JLabel lblNotaTerceiroBimestre = new JLabel ("Nota 3º Bimestre:");
        JLabel lblNotaQuartoBimestre = new JLabel ("Nota 4º Bimestre");
        
        TxtNomeAluno = new JTextField();
        TxtNota1Bimestre = new JTextField();
        TxtNota2Bimestre = new JTextField();
        TxtNota3Bimestre = new JTextField();
        TxtNota4Bimestre = new JTextField();
        JButton btnVerificar = new JButton("Verificar Situação");
        lblVerificar = new JLabel ("Situação:                                            ");
        
        btnVerificar.addActionListener(e -> VerificarNotasAlunos());
    
        panelNotasAlunos.add(lblNomeAluno);
        panelNotasAlunos.add(TxtNomeAluno);
        panelNotasAlunos.add(new JLabel()); // espaço vazio
        panelNotasAlunos.add(new JLabel()); // espaço vazio
        panelNotasAlunos.add(lblNotaPrimeiroBimestre);
        panelNotasAlunos.add(TxtNota1Bimestre);
        panelNotasAlunos.add(new JLabel()); // espaço vazio
        panelNotasAlunos.add(new JLabel()); // espaço vazio
        panelNotasAlunos.add(lblNotaSegundoBimestre);
        panelNotasAlunos.add(TxtNota2Bimestre);
        panelNotasAlunos.add(new JLabel()); // espaço vazio
        panelNotasAlunos.add(new JLabel()); // espaço vazio
        panelNotasAlunos.add(lblNotaTerceiroBimestre);
        panelNotasAlunos.add(TxtNota3Bimestre);
        panelNotasAlunos.add(new JLabel()); // espaço vazio
        panelNotasAlunos.add(new JLabel()); // espaço vazio
        panelNotasAlunos.add(lblNotaQuartoBimestre);
        panelNotasAlunos.add(TxtNota4Bimestre);
        panelNotasAlunos.add(new JLabel()); // espaço vazio
        panelNotasAlunos.add(new JLabel()); // espaço vazio
        panelNotasAlunos.add(btnVerificar);
        panelNotasAlunos.add(lblVerificar);

        add(panelNotasAlunos);
    }
        private void VerificarNotasAlunos(){
            try {
                String nomeAluno = TxtNomeAluno.getText();
                double nota1 = Double.parseDouble(TxtNota1Bimestre.getText());
                double nota2 = Double.parseDouble(TxtNota2Bimestre.getText());
                double nota3 = Double.parseDouble(TxtNota3Bimestre.getText());
                double nota4 = Double.parseDouble(TxtNota4Bimestre.getText());
              
               if (nota1 < 0 || nota2 < 0 || nota3 < 0 || nota4 < 0 || nota1 > 10 || nota2 > 10 || nota3 > 10 || nota4 > 10) {
                lblVerificar.setText("Insira valores entre 0 e 10!");
                } else {
                double notafinal = (nota1 + nota2 + nota3 + nota4) / 4;
                    
                String classificacao = null;
            if (notafinal >= 7) {
                classificacao = "Aprovado";
            } else if (notafinal > 5) {
                classificacao = "Recuperação";
            } else if (notafinal > 0 && notafinal < 5) {
                classificacao = "Reprovado";
            }
               
               lblVerificar.setText(String.format("%s %s %.2f", nomeAluno, classificacao, notafinal));
               }
            } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite valores válidos para as notas!");
        }
    }
}
