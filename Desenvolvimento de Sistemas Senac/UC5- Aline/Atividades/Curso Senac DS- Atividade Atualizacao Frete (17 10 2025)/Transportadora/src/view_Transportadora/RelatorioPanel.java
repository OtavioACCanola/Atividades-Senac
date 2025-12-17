package view_Transportadora;

import br.com.fretesmvc.config.AppContext;
import br.com.fretesmvc.controller.*;
import br.com.fretesmvc.model.Frete;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.*;
import java.util.*;

public class RelatorioPanel extends JPanel implements Refreshable {

    private final RelatorioController relCtrl;
    private final TransportadoraController traCtrl;
    private final VeiculoController veiCtrl;
    private final MotoristaController motCtrl;
    private final RotaController rotaCtrl;
    private final JRadioButton diario = new JRadioButton("Diário", true), mensal = new JRadioButton("Mensal"), periodo = new JRadioButton("Período");
    private final JTextField dataDia = new JTextField(10), mes = new JTextField(7), ini = new JTextField(10), fim = new JTextField(10);
    private final JComboBox<String> consCombo = new JComboBox<>(new String[]{"Nenhum", "Motorista", "Veículo", "Transportadora"});
    private final DefaultTableModel model = new DefaultTableModel(new Object[]{"Data", "Motorista", "Veículo", "Transportadora", "Rota", "Valor"}, 0);
    private final DefaultTableModel consModel = new DefaultTableModel(new Object[]{"Grupo", "Total"}, 0);

    public RelatorioPanel(AppContext ctx) {
        super(new BorderLayout());
        this.relCtrl = ctx.getRelatorioController();
        this.traCtrl = ctx.getTransportadoraController();
        this.veiCtrl = ctx.getVeiculoController();
        this.motCtrl = ctx.getMotoristaController();
        this.rotaCtrl = ctx.getRotaController();
        ButtonGroup bg = new ButtonGroup();
        bg.add(diario);
        bg.add(mensal);
        bg.add(periodo);
        JPanel filtros = new JPanel(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(4, 4, 4, 4);
        g.fill = GridBagConstraints.HORIZONTAL;
        JLabel l1 = new JLabel("Dia (yyyy-MM-dd):"), l2 = new JLabel("Mês (yyyy-MM):"), l3 = new JLabel("Início (yyyy-MM-dd):"), l4 = new JLabel("Fim (yyyy-MM-dd):"), l5 = new JLabel("Consolidar por:");
        l1.setLabelFor(dataDia);
        l2.setLabelFor(mes);
        l3.setLabelFor(ini);
        l4.setLabelFor(fim);
        l5.setLabelFor(consCombo);
        dataDia.setText(LocalDate.now().toString());
        mes.setText(YearMonth.now().toString());
        g.gridx = 0;
        g.gridy = 0;
        filtros.add(diario, g);
        g.gridx = 1;
        filtros.add(l1, g);
        g.gridx = 2;
        filtros.add(dataDia, g);
        g.gridx = 0;
        g.gridy = 1;
        filtros.add(mensal, g);
        g.gridx = 1;
        filtros.add(l2, g);
        g.gridx = 2;
        filtros.add(mes, g);
        g.gridx = 0;
        g.gridy = 2;
        filtros.add(periodo, g);
        g.gridx = 1;
        filtros.add(l3, g);
        g.gridx = 2;
        filtros.add(ini, g);
        g.gridx = 3;
        filtros.add(l4, g);
        g.gridx = 4;
        filtros.add(fim, g);
        g.gridx = 0;
        g.gridy = 3;
        filtros.add(l5, g);
        g.gridx = 1;
        filtros.add(consCombo, g);
        JButton gerar = new JButton("Gerar (Alt+G)");
        gerar.setMnemonic('G');
        gerar.addActionListener(e -> gerar());
        g.gridx = 4;
        g.gridy = 3;
        filtros.add(gerar, g);
        JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JTable tFretes = new JTable(model);
        JTable tCons = new JTable(consModel);
        split.setTopComponent(new JScrollPane(tFretes));
        split.setBottomComponent(new JScrollPane(tCons));
        split.setResizeWeight(0.7);
        add(filtros, BorderLayout.NORTH);
        add(split, BorderLayout.CENTER);
    }

    private void gerar() {
        try {
            java.util.List<Frete> fretes;
            if (diario.isSelected()) {
                fretes = relCtrl.fretesDia(java.time.LocalDate.parse(dataDia.getText().trim()));
            } else if (mensal.isSelected()) {
                fretes = relCtrl.fretesMes(java.time.YearMonth.parse(mes.getText().trim()));
            } else {
                fretes = relCtrl.fretesPeriodo(java.time.LocalDate.parse(ini.getText().trim()), java.time.LocalDate.parse(fim.getText().trim()));
            }
            preencherTabela(fretes);
            preencherConsolidado(fretes);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void preencherTabela(java.util.List<Frete> fretes) {
        model.setRowCount(0);
        for (Frete f : fretes) {
            var mot = motCtrl.listar().stream().filter(m -> m.getId().equals(f.getMotoristaId())).findFirst().orElse(null);
            var vei = veiCtrl.listar().stream().filter(v -> v.getId().equals(f.getVeiculoId())).findFirst().orElse(null);
            var tra = traCtrl.listar().stream().filter(t -> t.getId().equals(f.getTransportadoraId())).findFirst().orElse(null);
            var rot = rotaCtrl.listar().stream().filter(r -> r.getId().equals(f.getRotaId())).findFirst().orElse(null);
            model.addRow(new Object[]{f.getDataHora().toString(), mot != null ? mot.getNome() : "", vei != null ? (vei.getTipo() + "/" + vei.getPlaca()) : "", tra != null ? tra.getRazaoSocial() : "", rot != null ? (rot.getOrigem() + "→" + rot.getDestino()) : "", UIUtil.BRL.format(f.getValor())});
        }
    }

    private void preencherConsolidado(java.util.List<Frete> fretes) {
        consModel.setRowCount(0);
        java.util.Map<String, Double> mapa = java.util.Collections.emptyMap();
        String tipo = (String) consCombo.getSelectedItem();
        if ("Motorista".equals(tipo)) {
            mapa = relCtrl.consolidarPorMotorista(fretes);
        } else if ("Veículo".equals(tipo)) {
            mapa = relCtrl.consolidarPorVeiculo(fretes);
        } else if ("Transportadora".equals(tipo)) {
            mapa = relCtrl.consolidarPorTransportadora(fretes);
        }
        for (var e : mapa.entrySet()) {
            consModel.addRow(new Object[]{e.getKey(), UIUtil.BRL.format(e.getValue())});
        }
    }

    @Override
    public void refresh() {
    }
}
