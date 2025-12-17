package view_Transportadora;

import br.com.fretesmvc.config.AppContext;
import br.com.fretesmvc.controller.*;
import br.com.fretesmvc.model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FretePanel extends JPanel implements Refreshable {

    private final TransportadoraController traCtrl;
    private final MotoristaController motCtrl;
    private final VeiculoController veiCtrl;
    private final RotaController rotaCtrl;
    private final FreteController freteCtrl;
    private final VinculoController vincCtrl;
    private final JComboBox<Transportadora> transportadoras = new JComboBox<>();
    private final JComboBox<Motorista> motoristas = new JComboBox<>();
    private final JComboBox<Veiculo> veiculos = new JComboBox<>();
    private final JComboBox<Rota> rotas = new JComboBox<>();
    private final JLabel valorLabel = new JLabel("R$ 0,00");
    private final DefaultTableModel model = new DefaultTableModel(new Object[]{"Data/Hora", "Transportadora", "Motorista", "Veículo", "Rota", "Valor"}, 0);

    public FretePanel(AppContext ctx) {
        super(new BorderLayout());
        this.traCtrl = ctx.getTransportadoraController();
        this.motCtrl = ctx.getMotoristaController();
        this.veiCtrl = ctx.getVeiculoController();
        this.rotaCtrl = ctx.getRotaController();
        this.freteCtrl = ctx.getFreteController();
        this.vincCtrl = ctx.getVinculoController();
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(4, 4, 4, 4);
        g.fill = GridBagConstraints.HORIZONTAL;
        JLabel lt = new JLabel("Transportadora:"), lm = new JLabel("Motorista:"), lv = new JLabel("Veículo:"), lr = new JLabel("Rota:"), lval = new JLabel("Valor do Frete:");
        lt.setLabelFor(transportadoras);
        lm.setLabelFor(motoristas);
        lv.setLabelFor(veiculos);
        lr.setLabelFor(rotas);
        lval.setLabelFor(valorLabel);
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
        g.gridx = 0;
        g.gridy = 3;
        form.add(lr, g);
        g.gridx = 1;
        form.add(rotas, g);
        g.gridx = 0;
        g.gridy = 4;
        form.add(lval, g);
        g.gridx = 1;
        form.add(valorLabel, g);
        JButton calc = new JButton("Calcular (Alt+A)");
        calc.setMnemonic('A');
        calc.addActionListener(e -> calcular());
        JButton reg = new JButton("Registrar Frete (Alt+R)");
        reg.setMnemonic('R');
        reg.addActionListener(e -> registrar());
        JPanel top = new JPanel(new BorderLayout());
        JPanel buttons = new JPanel();
        buttons.add(calc);
        buttons.add(reg);
        top.add(form, BorderLayout.CENTER);
        top.add(buttons, BorderLayout.EAST);
        JTable table = new JTable(model);
        add(top, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        transportadoras.addActionListener(e -> filtrarPorTransportadora());
        motoristas.addActionListener(e -> filtrarVeiculosPorMotorista());
        refresh();
    }

    private void filtrarPorTransportadora() {
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
        valorLabel.setText("R$ 0,00");
    }

    private void filtrarVeiculosPorMotorista() {
        Motorista m = (Motorista) motoristas.getSelectedItem();
        veiculos.removeAllItems();
        if (m != null) {
            for (Veiculo v : vincCtrl.listarVeiculosDoMotorista(m.getId())) {
                veiculos.addItem(v);
            }
        } else {
            filtrarPorTransportadora();
        }
        valorLabel.setText("R$ 0,00");
    }

    private void calcular() {
        try {
            Veiculo v = (Veiculo) veiculos.getSelectedItem();
            Rota r = (Rota) rotas.getSelectedItem();
            if (v == null || r == null) {
                throw new IllegalStateException("Selecione veículo e rota");
            }
            double valor = freteCtrl.calcularValor(v.getId(), r.getId());
            valorLabel.setText(UIUtil.BRL.format(valor));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registrar() {
        try {
            Transportadora t = (Transportadora) transportadoras.getSelectedItem();
            Motorista m = (Motorista) motoristas.getSelectedItem();
            Veiculo v = (Veiculo) veiculos.getSelectedItem();
            Rota r = (Rota) rotas.getSelectedItem();
            if (t == null || m == null || v == null || r == null) {
                throw new IllegalStateException("Selecione transportadora, motorista, veículo e rota");
            }
            if (!m.getTransportadoraId().equals(t.getId()) || !v.getTransportadoraId().equals(t.getId())) {
                throw new IllegalStateException("Motorista e veículo devem pertencer à transportadora selecionada");
            }
            freteCtrl.registrarFrete(t.getId(), m.getId(), v.getId(), r.getId());
            model.addRow(new Object[]{java.time.LocalDateTime.now().toString(), t.getRazaoSocial(), m.getNome(), v.getTipo() + "/" + v.getPlaca(), r.getOrigem() + "→" + r.getDestino(), valorLabel.getText()});
            JOptionPane.showMessageDialog(this, "Frete registrado com sucesso!", "OK", JOptionPane.INFORMATION_MESSAGE);
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
        rotas.removeAllItems();
        for (Rota r : rotaCtrl.listar()) {
            rotas.addItem(r);
        }
        valorLabel.setText("R$ 0,00");
    }
}
