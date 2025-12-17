package view_Transportadora;

import br.com.fretesmvc.config.AppContext;
import br.com.fretesmvc.controller.*;
import br.com.fretesmvc.model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MotoristaPanel extends JPanel implements Refreshable {

    private final MotoristaController motCtrl;
    private final TransportadoraController traCtrl;
    private final JComboBox<Transportadora> transportadoras = new JComboBox<>();
    private final JTextField nome = new JTextField(20), cpf = new JTextField(14), cnh = new JTextField(12), tel = new JTextField(12);
    private final DefaultTableModel model = new DefaultTableModel(new Object[]{"Nome", "CPF", "CNH", "Telefone", "Transportadora"}, 0);

    public MotoristaPanel(AppContext ctx) {
        super(new BorderLayout());
        this.motCtrl = ctx.getMotoristaController();
        this.traCtrl = ctx.getTransportadoraController();
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(4, 4, 4, 4);
        g.fill = GridBagConstraints.HORIZONTAL;
        JLabel lt = new JLabel("Transportadora:"), ln = new JLabel("Nome:"), lc = new JLabel("CPF:"), lh = new JLabel("CNH:"), ltel = new JLabel("Telefone:");
        lt.setLabelFor(transportadoras);
        ln.setLabelFor(nome);
        lc.setLabelFor(cpf);
        lh.setLabelFor(cnh);
        ltel.setLabelFor(tel);
        lt.setDisplayedMnemonic('T');
        ln.setDisplayedMnemonic('N');
        lc.setDisplayedMnemonic('F');
        lh.setDisplayedMnemonic('H');
        g.gridx = 0;
        g.gridy = 0;
        form.add(lt, g);
        g.gridx = 1;
        form.add(transportadoras, g);
        g.gridx = 0;
        g.gridy = 1;
        form.add(ln, g);
        g.gridx = 1;
        form.add(nome, g);
        g.gridx = 0;
        g.gridy = 2;
        form.add(lc, g);
        g.gridx = 1;
        form.add(cpf, g);
        g.gridx = 0;
        g.gridy = 3;
        form.add(lh, g);
        g.gridx = 1;
        form.add(cnh, g);
        g.gridx = 0;
        g.gridy = 4;
        form.add(ltel, g);
        g.gridx = 1;
        form.add(tel, g);
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
            Transportadora t = (Transportadora) transportadoras.getSelectedItem();
            if (t == null) {
                throw new IllegalStateException("Cadastre uma transportadora primeiro");
            }
            motCtrl.cadastrar(t.getId(), nome.getText(), cpf.getText(), cnh.getText(), tel.getText());
            nome.setText("");
            cpf.setText("");
            cnh.setText("");
            tel.setText("");
            refresh();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void refresh() {
        transportadoras.removeAllItems();
        for (Transportadora t : traCtrl.listar()) {
            transportadoras.addItem(t);
        }
        model.setRowCount(0);
        for (Motorista m : motCtrl.listar()) {
            Transportadora tx = traCtrl.listar().stream().filter(tr -> tr.getId().equals(m.getTransportadoraId())).findFirst().orElse(null);
            model.addRow(new Object[]{m.getNome(), m.getCpf(), m.getCnh(), m.getTelefone(), tx != null ? tx.getRazaoSocial() : ""});
        }
    }
}
