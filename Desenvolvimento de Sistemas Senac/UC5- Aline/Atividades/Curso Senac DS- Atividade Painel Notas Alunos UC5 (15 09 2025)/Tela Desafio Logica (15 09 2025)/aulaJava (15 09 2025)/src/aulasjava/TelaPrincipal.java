    package aulasjava;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        setTitle("Menu Inicial");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Paleta de cores do Senac SP
        Color azulSenac = new Color(0, 51, 102);     // azul escuro
        Color laranjaSenac = new Color(255, 102, 0); // laranja
        Color branco = Color.WHITE;

        // Painel principal com BoxLayout (vertical)
        JPanel panel = new JPanel();
        panel.setBackground(azulSenac);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));        
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Criar botões arredondados
        JButton btnCondicionais = criarBotao("Condicionais", laranjaSenac, branco);
        JButton btnLacos = criarBotao("Laços", laranjaSenac, branco);
        JButton btnListas = criarBotao("Listas", laranjaSenac, branco);
        JButton btnOrdenacao = criarBotao("Ordenação", laranjaSenac, branco);
        JButton btnLogica = criarBotao("Lógica", laranjaSenac, branco);

        // Definir tamanho fixo para todos os botões
        Dimension tamanho = new Dimension(250, 45);
        btnCondicionais.setMaximumSize(tamanho);
        btnLacos.setMaximumSize(tamanho);
        btnListas.setMaximumSize(tamanho);
        btnOrdenacao.setMaximumSize(tamanho);
        btnLogica.setMaximumSize(tamanho);

        // Ações dos botões
        btnCondicionais.addActionListener(e -> {
            new TelaCondicionais().setVisible(true);
        });
        
        btnLacos.addActionListener(e -> {
            new TelaLacos().setVisible(true);
        });

        // Adicionar botões com espaçamento
        panel.add(btnCondicionais);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnLacos);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnListas);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnOrdenacao);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnLogica);

        add(panel);
    }

    private JButton criarBotao(String texto, Color corFundo, Color corTexto) {
        //Deixar botões com as bordas arredondadas --> pesquisei
        
        JButton botao = new JButton(texto) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Fundo arredondado
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

                super.paintComponent(g);
                g2.dispose();
            }
        };
        
        botao.setContentAreaFilled(false);
        botao.setFocusPainted(false);
        botao.setBackground(corFundo);
        botao.setForeground(corTexto);
        botao.setFont(new Font("Arial", Font.BOLD, 14));
        botao.setAlignmentX(Component.CENTER_ALIGNMENT);
        return botao;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }
}
