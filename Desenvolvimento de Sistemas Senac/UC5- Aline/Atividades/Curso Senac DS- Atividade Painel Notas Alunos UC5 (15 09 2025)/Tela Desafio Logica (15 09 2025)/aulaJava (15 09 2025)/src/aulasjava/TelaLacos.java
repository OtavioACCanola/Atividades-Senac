/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aulasjava;

/**
 *
 * @author aline.fsantos55
 */
import javax.swing.*;
import java.awt.*;

class TelaLacos extends JFrame {

    public TelaLacos() {
        setTitle("Tela Laços de Repetição");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton btnExemplo = new JButton("Exemplo For/While - Tabuada");
        JButton btnDesafioWhile = new JButton("Desafio While - Máquina de Vendas");
        JButton btnDesafioFor = new JButton("Desafio For - Gastos Semanais");

        // Ações
        btnExemplo.addActionListener(e -> new TelaExemploLacos().setVisible(true));
        
        btnDesafioWhile.addActionListener(e -> new TelaDesafioWhileLacos().setVisible(true));
        
        
        panel.add(btnExemplo);
        panel.add(btnDesafioWhile);
        panel.add(btnDesafioFor);

        add(panel);
    }
}
