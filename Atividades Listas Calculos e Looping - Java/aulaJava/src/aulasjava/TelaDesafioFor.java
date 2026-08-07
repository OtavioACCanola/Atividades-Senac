/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aulasjava;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class TelaDesafioFor extends JFrame {

    private JTextField TxtGastoDiario;

    public TelaDesafioFor() {
        setTitle("Tabuada de Gastos Semanais");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel painelDesafioFor = new JPanel();
        painelDesafioFor.setLayout(new GridLayout(6, 2, 4, 4));

        JLabel LblGastoDiario = new JLabel("Gasto Diario: R$ ");
        TxtGastoDiario = new JTextField();
        JLabel LblResultado = new JLabel("O valor para cada dia da semana é de: ");

        JPanel PainelButt = new JPanel();
        JButton BtnCalcular = new JButton("Calcular");
        PainelButt.add(BtnCalcular);

        BtnCalcular.addActionListener(e -> Calcular());

        painelDesafioFor.add(LblGastoDiario);
        painelDesafioFor.add(TxtGastoDiario);
        painelDesafioFor.add(BtnCalcular);
        painelDesafioFor.add(LblResultado);

        add(painelDesafioFor);
    }

    private void Calcular() {

        try {
            String Segunda = TxtGastoDiario.getText();
            String Terca = TxtGastoDiario.getText();
            String Quarta = TxtGastoDiario.getText();
            String Quinta = TxtGastoDiario.getText();
            String Sexta = TxtGastoDiario.getText();
            String Sabado = TxtGastoDiario.getText();
            String Domingo = TxtGastoDiario.getText();

            int GastoDiarioInt = Integer.parseInt(TxtGastoDiario.getText());
            int gastoDiarioInt = Integer.parseInt(TxtGastoDiario.getText());
            ArrayList<String> DiasSemanas = new ArrayList<String>();
            DiasSemanas.add("Segunda");
            DiasSemanas.add("Terca");
            DiasSemanas.add("Quarta");
            DiasSemanas.add("Quinta");
            DiasSemanas.add("Sexta");
            DiasSemanas.add("Sabado");
            DiasSemanas.add("Domingo");
            StringBuilder Texto = new StringBuilder();
            int valorAcumulado = GastoDiarioInt * 7;

            for (int i = 0; i < DiasSemanas.size(); i++) {
                JOptionPane.showMessageDialog(null, Texto.append("O valor gasto de " + DiasSemanas.get(i) + " é de R$ " + GastoDiarioInt + "\n"));
            }
            JOptionPane.showMessageDialog(null, "O total de dinheiro gasto é de: R$ " + valorAcumulado);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Digite um valor válido!");
        }
    }
}
