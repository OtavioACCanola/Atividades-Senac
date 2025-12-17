
package aulasjava;

import javax.swing.*;
import java.awt.*;

class TelaCondicionais extends JFrame {

    public TelaCondicionais() {
        setTitle("Tela Condicionais");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 10, 10));

        JButton btnIMC = new JButton("IMC");
        JButton btnDesafio = new JButton("Desafio");

        btnIMC.addActionListener(e -> {
            new TelaIMC().setVisible(true);
        });

        // Por enquanto o "Desafio" só mostra mensagem
        btnDesafio.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Tela de Desafio em construção!");
        });

        panel.add(btnIMC);
        panel.add(btnDesafio);

        add(panel);
    }
}
