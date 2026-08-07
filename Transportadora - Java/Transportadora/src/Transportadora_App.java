/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import br.com.fretesmvc.config.AppContext;
import view.MainFrame;
import javax.swing.*;

public class Transportadora_App {


public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ignored) {}
            AppContext ctx = new AppContext();
            MainFrame frame = new MainFrame(ctx);
            frame.setVisible(true);
        });
    }
}
 
}
