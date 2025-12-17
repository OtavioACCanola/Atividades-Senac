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
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JPanel panelNotasAlunos = new JPanel();
        panelNotasAlunos.setLayout(new GridLayout(6, 2, 10, 10));
        
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
        lblVerificar = new JLabel ("Situação: ");
        
        btnVerificar.addActionListener(e -> VerificarNotasAlunos());
    
        panelNotasAlunos.add(lblNomeAluno);
        panelNotasAlunos.add(TxtNomeAluno);
        panelNotasAlunos.add(new JLabel()); // espaço vazio
        panelNotasAlunos.add(lblNotaPrimeiroBimestre);
        panelNotasAlunos.add(TxtNota1Bimestre);
        panelNotasAlunos.add(new JLabel()); // espaço vazio
        panelNotasAlunos.add(lblNotaSegundoBimestre);
        panelNotasAlunos.add(TxtNota2Bimestre);
        panelNotasAlunos.add(new JLabel()); // espaço vazio
        panelNotasAlunos.add(lblNotaTerceiroBimestre);
        panelNotasAlunos.add(TxtNota3Bimestre);
        panelNotasAlunos.add(new JLabel()); // espaço vazio
        panelNotasAlunos.add(lblNotaQuartoBimestre);
        panelNotasAlunos.add(TxtNota4Bimestre);
        panelNotasAlunos.add(new JLabel()); // espaço vazio
        panelNotasAlunos.add(lblVerificar);
        panelNotasAlunos.add(new JLabel()); // espaço vazio
        panelNotasAlunos.add(btnVerificar);
        

        add(panelNotasAlunos);
    }
        private void VerificarNotasAlunos(){
            try {
                String nomeAluno = TxtNomeAluno.getText();
                double nota1 = Double.parseDouble(TxtNota1Bimestre.getText());
                double nota2 = Double.parseDouble(TxtNota2Bimestre.getText());
                double nota3 = Double.parseDouble(TxtNota3Bimestre.getText());
                double nota4 = Double.parseDouble(TxtNota4Bimestre.getText());
                double notafinal= (nota1 + nota2 + nota3 + nota4) / 4;
                    
                String situacao = null;
            if (notafinal >= 7 && notafinal <= 11) {
                situacao = "Aprovado";
            } else if (notafinal > 5 && notafinal < 7) {
                situacao = "Recuperação";
            } else if (notafinal > 0 && notafinal < 5) {
                situacao = "Reprovado";
            }
            
            lblVerificar.setText(String.format("%s - %s - %.2f", nomeAluno, situacao, notafinal));
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite valores válidos!");
        }
    }
}
