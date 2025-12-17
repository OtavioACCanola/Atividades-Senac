package aulasjava;

import javax.swing.*;
import java.awt.*;

public class TelaNotasBimestral extends JFrame {

    private JTextField txtNome, txtNota01, txtNota02, txtNota03, txtNota04;
    private JLabel lblResultado;

    public TelaNotasBimestral() {
        setTitle("Notas Finais");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Painel principal com margem
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Painel de inputs com GridBagLayout
        JPanel panelInputs = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // espaçamento interno
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        txtNome = new JTextField(20);
        txtNota01 = new JTextField(10);
        txtNota02 = new JTextField(10);
        txtNota03 = new JTextField(10);
        txtNota04 = new JTextField(10);

        // Adiciona campos
        panelInputs.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1;
        panelInputs.add(txtNome, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panelInputs.add(new JLabel("Nota 1º Bimestre:"), gbc);
        gbc.gridx = 1;
        panelInputs.add(txtNota01, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panelInputs.add(new JLabel("Nota 2º Bimestre:"), gbc);
        gbc.gridx = 1;
        panelInputs.add(txtNota02, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panelInputs.add(new JLabel("Nota 3º Bimestre:"), gbc);
        gbc.gridx = 1;
        panelInputs.add(txtNota03, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panelInputs.add(new JLabel("Nota 4º Bimestre:"), gbc);
        gbc.gridx = 1;
        panelInputs.add(txtNota04, gbc);

        // Botão Calcular
        JButton btnCalcular = new JButton("Calcular");
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panelInputs.add(btnCalcular, gbc);

        // Label de resultado ocupando toda a largura
        lblResultado = new JLabel("Resultado: ", SwingConstants.CENTER);
        lblResultado.setFont(new Font("Arial", Font.BOLD, 14));
        lblResultado.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        // Adiciona ao painel principal
        panel.add(panelInputs, BorderLayout.CENTER);
        panel.add(lblResultado, BorderLayout.SOUTH);

        add(panel);

        // Ação do botão
        btnCalcular.addActionListener(e -> calcularMedia());
    }

    private void calcularMedia() {
        try {
            String nome = txtNome.getText();
            double nota01 = Double.parseDouble(txtNota01.getText());
            double nota02 = Double.parseDouble(txtNota02.getText());
            double nota03 = Double.parseDouble(txtNota03.getText());
            double nota04 = Double.parseDouble(txtNota04.getText());

            if (nota01 < 0 || nota02 < 0 || nota03 < 0 || nota04 < 0 || nota01 > 10 || nota02 > 10 || nota03 > 10 || nota04 > 10) {
                lblResultado.setText("Insira valores entre 0 e 10!");
            } else {
                double media = (nota01 + nota02 + nota03 + nota04) / 4;

                String status;
                if (media >= 7) {
                    status = "Aprovado(a)";
                } else if (media >= 5) {
                    status = "Recuperação";
                } else {
                    status = "Reprovado(a)";
                }

                lblResultado.setText(String.format("%s - Média: %.2f (%s)", nome, media, status));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite valores válidos para as notas!");
        }
    }

}
