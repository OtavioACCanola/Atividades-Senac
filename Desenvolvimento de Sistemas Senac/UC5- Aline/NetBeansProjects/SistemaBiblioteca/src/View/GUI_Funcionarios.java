/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import View.GUI_OpcoesBiblioteca;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Controller.FuncionarioConn;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import DAO.FuncionarioDAO;
import Model.Gerente;

public class GUI_Funcionarios extends javax.swing.JFrame {
    FuncionarioDAO dao = new FuncionarioDAO();

    public FuncionarioDAO getDao() {
        return dao;
    }

    public void setDao(FuncionarioDAO dao) {
        this.dao = dao;
    }
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUI_Funcionarios.class.getName());

    /**
     * Creates new form GUI_Funcionarios
     */
    public GUI_Funcionarios() {
        initComponents();
    }

    public void popularTabela(){
        DefaultTableModel modelo = (DefaultTableModel) getTblFuncionarios().getModel();
            modelo.setRowCount(0);
        List<Gerente> lista = getDao().listarFuncionarios();

        try{
            for (Gerente model: lista ) {
                modelo.addRow(new Object[]{
                    model.getId(),
                    model.getNome(),
                    model.getSalario(),
               });
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao popular a Tabela: "+e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
            
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlPainelFuncionario = new javax.swing.JPanel();
        LblNome = new javax.swing.JLabel();
        TxtNome = new javax.swing.JTextField();
        LblSalario = new javax.swing.JLabel();
        TxtSalario = new javax.swing.JTextField();
        BtnCadastrar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        LblTitulo = new javax.swing.JLabel();
        LblCargo = new javax.swing.JLabel();
        TxtCargo = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        TblFuncionarios = new javax.swing.JTable();
        BtnPagamento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LblNome.setText("Nome:");
        LblNome.setAlignmentX(0.5F);

        TxtNome.addActionListener(this::TxtNomeActionPerformed);

        LblSalario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LblSalario.setText("Salario:");
        LblSalario.setAlignmentX(0.5F);

        BtnCadastrar.setText("Cadastrar");
        BtnCadastrar.addActionListener(this::BtnCadastrarActionPerformed);

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(this::BtnCancelarActionPerformed);

        LblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        LblTitulo.setText("Funcionários");
        LblTitulo.setAlignmentX(0.5F);

        LblCargo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LblCargo.setText("Cargo:");
        LblCargo.setAlignmentX(0.5F);

        TxtCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bibliotecário", "Gerente" }));
        TxtCargo.setName("Selecione"); // NOI18N
        TxtCargo.addActionListener(this::TxtCargoActionPerformed);

        TblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Salário", "Cargo"
            }
        ));
        jScrollPane3.setViewportView(TblFuncionarios);

        BtnPagamento.setText("Pagamento");
        BtnPagamento.addActionListener(this::BtnPagamentoActionPerformed);

        javax.swing.GroupLayout PnlPainelFuncionarioLayout = new javax.swing.GroupLayout(PnlPainelFuncionario);
        PnlPainelFuncionario.setLayout(PnlPainelFuncionarioLayout);
        PnlPainelFuncionarioLayout.setHorizontalGroup(
            PnlPainelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlPainelFuncionarioLayout.createSequentialGroup()
                .addGroup(PnlPainelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PnlPainelFuncionarioLayout.createSequentialGroup()
                        .addGap(0, 34, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PnlPainelFuncionarioLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(PnlPainelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PnlPainelFuncionarioLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(PnlPainelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PnlPainelFuncionarioLayout.createSequentialGroup()
                                        .addComponent(LblCargo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(PnlPainelFuncionarioLayout.createSequentialGroup()
                                        .addComponent(BtnPagamento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BtnCadastrar)
                                        .addGap(18, 18, 18)
                                        .addComponent(BtnCancelar))))
                            .addGroup(PnlPainelFuncionarioLayout.createSequentialGroup()
                                .addGroup(PnlPainelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(LblSalario)
                                    .addComponent(LblNome))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PnlPainelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TxtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                                    .addComponent(TxtSalario))))))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlPainelFuncionarioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        PnlPainelFuncionarioLayout.setVerticalGroup(
            PnlPainelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlPainelFuncionarioLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(LblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(PnlPainelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnlPainelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PnlPainelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlPainelFuncionarioLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(PnlPainelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnCancelar)
                            .addComponent(BtnCadastrar)
                            .addComponent(BtnPagamento)))
                    .addGroup(PnlPainelFuncionarioLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(PnlPainelFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlPainelFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlPainelFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNomeActionPerformed
    }//GEN-LAST:event_TxtNomeActionPerformed

    private void BtnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadastrarActionPerformed
    FuncionarioConn conn = new FuncionarioConn();
    Float salario = Float.parseFloat(getTxtSalario().getText());
    String cargo = getTxtCargo().getSelectedItem().toString();
        
        if (getTxtNome().getText().isEmpty()|| getTxtSalario().getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Todos os Campos devem Estar Preenchidos", "Alerta", JOptionPane.ERROR_MESSAGE);
                return;
        }
        
        try {
            
            if (getTxtCargo().getSelectedItem().toString() == "Gerente"){
                conn.cadastrarFuncionario(getTxtNome().getText(), salario, cargo);  
                JOptionPane.showMessageDialog(null, "Usuário Cadastrado com Sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
                
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Quantidade deve ser um Número Válido", "Erro", JOptionPane.ERROR_MESSAGE);    }//GEN-LAST:event_BtnCadastrarActionPerformed
    }
    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
    GUI_OpcoesBiblioteca guiPrinc = new GUI_OpcoesBiblioteca(); 
        
    this.dispose();
        
    guiPrinc.setLocationRelativeTo(null);
    guiPrinc.setVisible(true);    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnPagamentoActionPerformed

    private void TxtCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCargoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new GUI_Funcionarios().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCadastrar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnPagamento;
    private javax.swing.JLabel LblCargo;
    private javax.swing.JLabel LblNome;
    private javax.swing.JLabel LblSalario;
    private javax.swing.JLabel LblTitulo;
    private javax.swing.JPanel PnlPainelFuncionario;
    private javax.swing.JTable TblFuncionarios;
    private javax.swing.JComboBox<String> TxtCargo;
    private javax.swing.JTextField TxtNome;
    private javax.swing.JTextField TxtSalario;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnCadastrar() {
        return BtnCadastrar;
    }

    public void setBtnCadastrar(JButton BtnCadastrar) {
        this.BtnCadastrar = BtnCadastrar;
    }

    public JComboBox<String> getTxtCargo() {
        return TxtCargo;
    }

    public void setTxtCargo(JComboBox<String> TxtCargo) {
        this.TxtCargo = TxtCargo;
    }

    public JTextField getTxtNome() {
        return TxtNome;
    }

    public void setTxtNome(JTextField TxtNome) {
        this.TxtNome = TxtNome;
    }

    public JTextField getTxtSalario() {
        return TxtSalario;
    }

    public void setTxtSalario(JTextField TxtSalario) {
        this.TxtSalario = TxtSalario;
    }

    public JTable getTblFuncionarios() {
        return TblFuncionarios;
    }

    public void setTblFuncionarios(JTable TblFuncionarios) {
        this.TblFuncionarios = TblFuncionarios;
    }


}
