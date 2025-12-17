package view_Transportadora;

import Config_Transportadora.AppContext;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(Config_Transportadora.AppContext ctx) {
        super("Sistema de Pagamento de Fretes - MVC EDU");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        JTabbedPane tabs = new JTabbedPane();
        var t = new TransportadoraPanel(ctx);
        var v = new VeiculoPanel(ctx);
        var m = new MotoristaPanel(ctx);
        var vinc = new VinculoPanel(ctx);
        var r = new RotaPanel(ctx);
        var f = new FretePanel(ctx);
        var rel = new RelatorioPanel(ctx);
        var lab = new LaboratorioPanel();
        tabs.addTab("Transportadoras", t);
        tabs.addTab("Veículos", v);
        tabs.addTab("Motoristas", m);
        tabs.addTab("Vínculos", vinc);
        tabs.addTab("Rotas", r);
        tabs.addTab("Fretes", f);
        tabs.addTab("Relatórios", rel);
        tabs.addTab("Laboratório", lab);
        tabs.addChangeListener(e -> {
            var c = tabs.getSelectedComponent();
            if (c instanceof Refreshable) {
                ((Refreshable) c).refresh();
            }
        });
        setContentPane(tabs);
    }
}
