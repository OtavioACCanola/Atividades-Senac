/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aulasjava;

/**
 *
 * @author aline.fsantos55
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class TelaExemploLacos extends JFrame {

    private JTextField campoNumero;
    private JRadioButton radioZero, radioUm;
    private JTextArea areaResultado;

    public TelaExemploLacos() {
        setTitle("Calculadora de Tabuada");
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout(10, 10));

        // Parte superior (entrada do número + escolha início)
        JPanel painelEntrada = new JPanel(new GridLayout(3, 1, 5, 5));

        campoNumero = new JTextField();
        painelEntrada.add(new JLabel("Digite um número:"));
        painelEntrada.add(campoNumero);

        // Radio buttons
        JPanel painelRadios = new JPanel();
        radioZero = new JRadioButton("Iniciar em 0", true);
        radioUm = new JRadioButton("Iniciar em 1");
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radioZero);
        grupo.add(radioUm);
        painelRadios.add(radioZero);
        painelRadios.add(radioUm);
        painelEntrada.add(painelRadios);

        // Botões
        JPanel painelBotoes = new JPanel();
        JButton btnWhile = new JButton("Gerar com While");
        JButton btnFor = new JButton("Gerar com For");

        painelBotoes.add(btnWhile);
        painelBotoes.add(btnFor);

        // Ações dos botões
        btnWhile.addActionListener(e -> gerarTabuadaWhile());
        btnFor.addActionListener(e -> gerarTabuadaFor());

        // Adiciona ao frame
        painel.add(painelEntrada, BorderLayout.NORTH);
        painel.add(painelBotoes, BorderLayout.CENTER);

        add(painel);
    }

    private void gerarTabuadaWhile() {
        try {
            int numero = Integer.parseInt(campoNumero.getText());
            int inicio = radioZero.isSelected() ? 0 : 1;
            int i = inicio;

            StringBuilder resultado = new StringBuilder("Tabuada de " + numero + " (while):\n");
            while (i <= 10) {
                resultado.append(numero).append(" x ").append(i).append(" = ").append(numero * i).append("\n");
                i++;
            }

            JOptionPane.showMessageDialog(this, resultado.toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite um número válido!");
        }
    }

    private void gerarTabuadaFor() {
        try {
            int numero = Integer.parseInt(campoNumero.getText());
            int inicio = radioZero.isSelected() ? 0 : 1;

            StringBuilder resultado = new StringBuilder("Tabuada de " + numero + " (for):\n");

            for (int i = inicio; i <= 10; i++) {
                resultado.append(numero).append(" x ").append(i).append(" = ").append(numero * i).append("\n");
            }

            JOptionPane.showMessageDialog(this, resultado.toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite um número válido!");
        }
    }

}
