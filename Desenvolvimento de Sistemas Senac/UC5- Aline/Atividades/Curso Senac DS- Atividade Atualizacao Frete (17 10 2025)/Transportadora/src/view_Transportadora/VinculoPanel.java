package view_Transportadora;

import br.com.fretesmvc.config.AppContext;
import br.com.fretesmvc.controller.*;
import br.com.fretesmvc.model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VinculoPanel extends JPanel implements Refreshable {

    private final VinculoController vincCtrl;
    private final TransportadoraController traCtrl;
    private final MotoristaController motCtrl;
    private final VeiculoController veiCtrl;
    private final JComboBox<Transportadora> transportadoras = new JComboBox<>();
    private final JComboBox<Motorista> motoristas = new JComboBox<>();
    private final JComboBox<Veiculo> veiculos = new JComboBox<>();
    private final DefaultTableModel model = new DefaultTableModel(new Object[]{"Transportadora", "Motorista", "Veículo"}, 0);

    public VinculoPanel(AppContext ctx) {
        super(new BorderLayout());
        this.vincCtrl = ctx.getVinculoController();
        this.traCtrl = ctx.getTransportadoraController();
        this.motCtrl = ctx.getMotoristaController();
        this.veiCtrl = ctx.getVeiculoController();
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(4, 4, 4, 4);
        g.fill = GridBagConstraints.HORIZONTAL;
        JLabel lt = new JLabel("Transportadora:"), lm = new JLabel("Motorista:"), lv = new JLabel("Veículo:");
        lt.setLabelFor(transportadoras);
        lm.setLabelFor(motoristas);
        lv.setLabelFor(veiculos);
        g.gridx = 0;
        g.gridy = 0;
        form.add(lt, g);
        g.gridx = 1;
        form.add(transportadoras, g);
        g.gridx = 0;
        g.gridy = 1;
        form.add(lm, g);
        g.gridx = 1;
        form.add(motoristas, g);
        g.gridx = 0;
        g.gridy = 2;
        form.add(lv, g);
        g.gridx = 1;
        form.add(veiculos, g);
        JButton vinc = new JButton("Vincular (Alt+V)");
        vinc.setMnemonic('V');
        vinc.addActionListener(e -> vincular());
        JPanel top = new JPanel(new BorderLayout());
        top.add(form, BorderLayout.CENTER);
        top.add(vinc, BorderLayout.EAST);
        JTable table = new JTable(model);
        add(top, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        transportadoras.addActionListener(e -> filtrar());
        refresh();
    }

    private void filtrar() {
        Transportadora t = (Transportadora) transportadoras.getSelectedItem();
        motoristas.removeAllItems();
        veiculos.removeAllItems();
        if (t != null) {
            for (Motorista m : motCtrl.listarPorTransportadora(t.getId())) {
                motoristas.addItem(m);
            }
            for (Veiculo v : veiCtrl.listarPorTransportadora(t.getId())) {
                veiculos.addItem(v);
            }
        }
    }

    private void vincular() {
        try {
            var t = (Transportadora) transportadoras.getSelectedItem();
            var m = (Motorista) motoristas.getSelectedItem();
            var v = (Veiculo) veiculos.getSelectedItem();
            if (t == null || m == null || v == null) {
                throw new IllegalStateException("Selecione transportadora, motorista e veículo");
            }
            vincCtrl.vincular(m.getId(), v.getId());
            model.addRow(new Object[]{t.getRazaoSocial(), m.getNome(), v.getTipo() + "/" + v.getPlaca()});
            JOptionPane.showMessageDialog(this, "Vínculo criado com sucesso!", "OK", JOptionPane.INFORMATION_MESSAGE);
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
        motoristas.removeAllItems();
        veiculos.removeAllItems();
    }
}
