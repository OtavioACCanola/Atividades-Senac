package view_Transportadora;

import br.com.fretesmvc.config.AppContext;
import br.com.fretesmvc.controller.TransportadoraController;
import br.com.fretesmvc.model.Transportadora;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TransportadoraPanel extends JPanel implements Refreshable {

    private final TransportadoraController ctrl;
    private final JTextField razao = new JTextField(25), cnpj = new JTextField(18), endereco = new JTextField(30);
    private final DefaultTableModel model = new DefaultTableModel(new Object[]{"Razão Social", "CNPJ", "Endereço"}, 0);

    public TransportadoraPanel(AppContext ctx) {
        super(new BorderLayout());
        this.ctrl = ctx.getTransportadoraController();
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(4, 4, 4, 4);
        g.fill = GridBagConstraints.HORIZONTAL;
        JLabel l1 = new JLabel("Razão Social:"), l2 = new JLabel("CNPJ:"), l3 = new JLabel("Endereço:");
        l1.setLabelFor(razao);
        l2.setLabelFor(cnpj);
        l3.setLabelFor(endereco);
        l1.setDisplayedMnemonic('R');
        l2.setDisplayedMnemonic('J');
        l3.setDisplayedMnemonic('E');
        g.gridx = 0;
        g.gridy = 0;
        form.add(l1, g);
        g.gridx = 1;
        form.add(razao, g);
        g.gridx = 0;
        g.gridy = 1;
        form.add(l2, g);
        g.gridx = 1;
        form.add(cnpj, g);
        g.gridx = 0;
        g.gridy = 2;
        form.add(l3, g);
        g.gridx = 1;
        form.add(endereco, g);
        JButton add = new JButton("Cadastrar (Alt+C)");
        add.setMnemonic('C');
        add.addActionListener(e -> cadastrar());
        JPanel top = new JPanel(new BorderLayout());
        top.add(form, BorderLayout.CENTER);
        top.add(add, BorderLayout.EAST);
        JTable table = new JTable(model);
        add(top, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        refresh();
    }

    private void cadastrar() {
        try {
            ctrl.cadastrar(razao.getText(), cnpj.getText(), endereco.getText());
            razao.setText("");
            cnpj.setText("");
            endereco.setText("");
            refresh();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void refresh() {
        model.setRowCount(0);
        for (Transportadora t : ctrl.listar()) {
            model.addRow(new Object[]{t.getRazaoSocial(), t.getCnpj(), t.getEndereco()});
        }
    }
}
