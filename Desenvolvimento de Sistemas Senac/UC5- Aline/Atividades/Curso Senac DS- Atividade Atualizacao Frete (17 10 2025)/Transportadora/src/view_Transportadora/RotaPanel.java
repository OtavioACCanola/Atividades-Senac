package view_Transportadora;

import br.com.fretesmvc.config.AppContext;
import br.com.fretesmvc.controller.RotaController;
import br.com.fretesmvc.model.Rota;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RotaPanel extends JPanel implements Refreshable {

    private final RotaController ctrl;
    private final JTextField origem = new JTextField(15), destino = new JTextField(15);
    private final JSpinner distancia = new JSpinner(new SpinnerNumberModel(1.0, 0.1, 100000.0, 0.1));
    private final DefaultTableModel model = new DefaultTableModel(new Object[]{"Origem", "Destino", "Distância (km)"}, 0);

    public RotaPanel(AppContext ctx) {
        super(new BorderLayout());
        this.ctrl = ctx.getRotaController();
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(4, 4, 4, 4);
        g.fill = GridBagConstraints.HORIZONTAL;
        JLabel lo = new JLabel("Origem:"), ld = new JLabel("Destino:"), lk = new JLabel("Distância (km):");
        lo.setLabelFor(origem);
        ld.setLabelFor(destino);
        lk.setLabelFor(distancia);
        lo.setDisplayedMnemonic('O');
        ld.setDisplayedMnemonic('D');
        g.gridx = 0;
        g.gridy = 0;
        form.add(lo, g);
        g.gridx = 1;
        form.add(origem, g);
        g.gridx = 0;
        g.gridy = 1;
        form.add(ld, g);
        g.gridx = 1;
        form.add(destino, g);
        g.gridx = 0;
        g.gridy = 2;
        form.add(lk, g);
        g.gridx = 1;
        form.add(distancia, g);
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
            double km = ((Number) distancia.getValue()).doubleValue();
            ctrl.cadastrar(origem.getText(), destino.getText(), km);
            origem.setText("");
            destino.setText("");
            distancia.setValue(1.0);
            refresh();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void refresh() {
        model.setRowCount(0);
        for (Rota r : ctrl.listar()) {
            model.addRow(new Object[]{r.getOrigem(), r.getDestino(), r.getDistanciaKm()});
        }
    }
}
