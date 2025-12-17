/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aulasjava;

import javax.swing.*;
import java.awt.*;

class TelaIMC extends JFrame {

    private JTextField txtPeso, txtAltura;
    private JLabel lblResultado;

    public TelaIMC() {
        setTitle("Cálculo IMC");
        setSize(350, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel lblPeso = new JLabel("Peso (kg):");
        JLabel lblAltura = new JLabel("Altura (m):");
        txtPeso = new JTextField();
        txtAltura = new JTextField();
        JButton btnCalcular = new JButton("Calcular");
        lblResultado = new JLabel("Resultado: ");

        btnCalcular.addActionListener(e -> calcularIMC());

        panel.add(lblPeso);
        panel.add(txtPeso);
        panel.add(lblAltura);
        panel.add(txtAltura);
        panel.add(new JLabel()); // espaço vazio
        panel.add(btnCalcular);
        panel.add(new JLabel()); // espaço vazio
        panel.add(lblResultado);

        add(panel);
    }

    private void calcularIMC() {
        try {
            double peso = Double.parseDouble(txtPeso.getText());
            double altura = Double.parseDouble(txtAltura.getText());
            double imc = peso / (altura * altura);

            String classificacao;
            if (imc < 18.5) {
                classificacao = "Abaixo do peso";
            } else if (imc < 24.9) {
                classificacao = "Peso normal";
            } else if (imc < 29.9) {
                classificacao = "Sobrepeso";
            } else {
                classificacao = "Obesidade";
            }

            lblResultado.setText(String.format("IMC: %.2f - %s", imc, classificacao));
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite valores válidos!");
        }
    }
}
