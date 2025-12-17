package view_Transportadora;

import br.com.fretesmvc.config.AppContext;
import br.com.fretesmvc.controller.*;
import br.com.fretesmvc.model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VeiculoPanel extends JPanel implements Refreshable {

    private final VeiculoController veiCtrl;
    private final TransportadoraController traCtrl;
    private final JComboBox<Transportadora> transportadoras = new JComboBox<>();
    private final JTextField placa = new JTextField(10), modelo = new JTextField(15);
    private final JRadioButton moto = new JRadioButton("Moto", true), carro = new JRadioButton("Carro"), caminhao = new JRadioButton("Caminhão");
    private final DefaultTableModel model = new DefaultTableModel(new Object[]{"Placa", "Modelo", "Tipo", "Transportadora", "R$/km"}, 0);

    public VeiculoPanel(AppContext ctx) {
        super(new BorderLayout());
        this.veiCtrl = ctx.getVeiculoController();
        this.traCtrl = ctx.getTransportadoraController();
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(4, 4, 4, 4);
        g.fill = GridBagConstraints.HORIZONTAL;
        ButtonGroup bg = new ButtonGroup();
        bg.add(moto);
        bg.add(carro);
        bg.add(caminhao);
        JLabel lt = new JLabel("Transportadora:"), lp = new JLabel("Placa:"), lm = new JLabel("Modelo:");
        lt.setLabelFor(transportadoras);
        lp.setLabelFor(placa);
        lm.setLabelFor(modelo);
        lt.setDisplayedMnemonic('T');
        lp.setDisplayedMnemonic('P');
        lm.setDisplayedMnemonic('M');
        g.gridx = 0;
        g.gridy = 0;
        form.add(lt, g);
        g.gridx = 1;
        form.add(transportadoras, g);
        g.gridx = 0;
        g.gridy = 1;
        form.add(lp, g);
        g.gridx = 1;
        form.add(placa, g);
        g.gridx = 0;
        g.gridy = 2;
        form.add(lm, g);
        g.gridx = 1;
        form.add(modelo, g);
        g.gridx = 0;
        g.gridy = 3;
        form.add(new JLabel("Tipo:"), g);
        JPanel tipos = new JPanel();
        tipos.add(moto);
        tipos.add(carro);
        tipos.add(caminhao);
        g.gridx = 1;
        form.add(tipos, g);
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
            TipoVeiculo tipo = moto.isSelected() ? TipoVeiculo.MOTO : carro.isSelected() ? TipoVeiculo.CARRO : TipoVeiculo.CAMINHAO;
            veiCtrl.cadastrar(t.getId(), tipo, placa.getText(), modelo.getText());
            placa.setText("");
            modelo.setText("");
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
        for (Veiculo v : veiCtrl.listar()) {
            Transportadora tx = java.util.Arrays.stream(traCtrl.listar().toArray(new Transportadora[0])).filter(tr -> tr.getId().equals(v.getTransportadoraId())).findFirst().orElse(null);
            model.addRow(new Object[]{v.getPlaca(), v.getModelo(), v.getTipo(), tx != null ? tx.getRazaoSocial() : "", v.getTipo().getCustoPorKm()});
        }
    }
}
