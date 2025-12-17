/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aulasjava;

import java.awt.*; 
import javax.swing.*;
/**
 *
 * @author Dell
 */
class TelaDesafioFor extends JFrame{
    
    private JTextField TxtGastoDiario;
    
    public TelaDesafioFor(){
    setTitle("Tabuada de Gastos Semanais");
    setSize(350,200);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
    JPanel painelDesafioFor = new JPanel();
    painelDesafioFor.setLayout(new GridLayout (6,2,4,4));
    
    JLabel LblGastoDiario = new JLabel("Gasto Diario: R$ ");
    TxtGastoDiario = new JTextField();
    JLabel LblResultado = new JLabel("O valor para cada dia da semana é de: ");
    
    JPanel PainelButt= new JPanel();
    JButton BtnCalcular = new JButton("Calcular");
    PainelButt.add(BtnCalcular);
    
    BtnCalcular.addActionListener(e -> Calcular());
    
    painelDesafioFor.add(LblGastoDiario);
    painelDesafioFor.add(TxtGastoDiario);
    painelDesafioFor.add(BtnCalcular);
    painelDesafioFor.add(LblResultado);
    
    add(painelDesafioFor);
    }

    private void Calcular(){
        String dia;
        StringBuilder Texto = new StringBuilder("Dia "+ dia +": Valor Gasto é R$ " + gastoDiarioInt);

        try{
            int gastoDiarioInt = Integer.parseInt(TxtGastoDiario.getText());
            for (int i = 1 ; i <= 7; i ++) {
                Texto.append(dia.("Segunda"));
      }}catch(NumberFormatException ex){
             JOptionPane.showMessageDialog(null, "Digite um valor válido!");
           }
    }
}
