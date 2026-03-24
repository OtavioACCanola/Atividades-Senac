/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import javax.swing.JComboBox;

import DAO.UsuarioDAO;
import Model.Usuario;
import DAO.EmprestimoDAO;
import Model.Emprestimo;
import Controller.EmprestimoDevolucaoConn;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GUI_Consulta extends javax.swing.JFrame {
    
    private EmprestimoDAO dao = new EmprestimoDAO();
    private EmprestimoDevolucaoConn emdeconn = new EmprestimoDevolucaoConn();

    public EmprestimoDAO getDao() {
        return dao;
    }

    public void setDao(EmprestimoDAO dao) {
        this.dao = dao;
    }

    public EmprestimoDevolucaoConn getEmdeconn() {
        return emdeconn;
    }

    public void setEmdeconn(EmprestimoDevolucaoConn emdeconn) {
        this.emdeconn = emdeconn;
    }


    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUI_Consulta.class.getName());

    /**
     * Creates new form GUI_Consulta
     */
    public GUI_Consulta() {
        initComponents();
        preencherComboUsuario();
    }

    private void preencherComboUsuario() {
    try {    
    getCobSelecionarUsuario().removeAllItems(); // Limpa os "Item 1", "Item 2"
    getCobSelecionarUsuario().removeAllItems();
    
    UsuarioDAO dao = new UsuarioDAO();
    List<Usuario> lista = dao.listarUsuarios();
    
    for (Usuario u : lista) {
        getCobSelecionarUsuario().addItem(u);
    }
    }catch (Exception e) {
        System.out.println("Erro ao carregar usuários: " + e.getMessage());
        }
    }
    
    public void preencherTabela(){
        
        
            DefaultTableModel modelo = (DefaultTableModel) getTblConsulta().getModel();
            modelo.setRowCount(0);

        try{
            Usuario selecionado = (Usuario) getCobSelecionarUsuario().getSelectedItem();

            if (selecionado != null){
                int idSelecionado = selecionado.getId();
                
                List<Emprestimo> lista = getDao().listarEmprestimos(1);
                
                if (lista.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Nenhum Empréstimo para esse Usuário Encontrado", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
                for (Emprestimo model: lista ) {
                    modelo.addRow(new Object[]{
                        model.getId(),
                        model.getLivro(),
                        model.getUsuario(),
                        model.getDataEmprestimo(),
                        model.getSituacao()
                });   
            }
                        }
            }
        catch (Exception e) {
            System.out.println("Erro ao carregar Tabela: " + e.getMessage());
            
            
                    
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LblTitulo = new javax.swing.JLabel();
        LblSelecionarUsuario = new javax.swing.JLabel();
        CobSelecionarUsuario = new javax.swing.JComboBox<>();
        BtnConsultar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TblConsulta = new javax.swing.JTable();
        BtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        LblTitulo.setText("Consulta");
        LblTitulo.setAlignmentX(0.5F);

        LblSelecionarUsuario.setText("Selecione o Usuário");

        CobSelecionarUsuario.setName("Selecione"); // NOI18N
        CobSelecionarUsuario.addActionListener(this::CobSelecionarUsuarioActionPerformed);

        BtnConsultar.setText("Consultar");
        BtnConsultar.addActionListener(this::BtnConsultarActionPerformed);

        TblConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Livro", "Usuário", "DataEmprestimo", "Situacao"
            }
        ));
        jScrollPane3.setViewportView(TblConsulta);

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(this::BtnCancelarActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnConsultar)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CobSelecionarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LblSelecionarUsuario))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(LblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(LblSelecionarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CobSelecionarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnConsultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnCancelar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConsultarActionPerformed
    preencherTabela();
    }//GEN-LAST:event_BtnConsultarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
    GUI_Emprestimo_Devolucao guiEmDev = new GUI_Emprestimo_Devolucao(); 
        
    this.dispose();
        
    guiEmDev.setLocationRelativeTo(null);
    guiEmDev.setVisible(true);
    
          }//GEN-LAST:event_BtnCancelarActionPerformed

    private void CobSelecionarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CobSelecionarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CobSelecionarUsuarioActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new GUI_Consulta().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnConsultar;
    private javax.swing.JComboBox<Model.Usuario> CobSelecionarUsuario;
    private javax.swing.JLabel LblSelecionarUsuario;
    private javax.swing.JLabel LblTitulo;
    private javax.swing.JTable TblConsulta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

    public JComboBox<Usuario> getCobSelecionarUsuario() {
        return CobSelecionarUsuario;
    }

    public void setCobSelecionarUsuario(JComboBox<Usuario> CobSelecionarUsuario) {
        this.CobSelecionarUsuario = CobSelecionarUsuario;
    }

    public JTable getTblConsulta() {
        return TblConsulta;
    }

    public void setTblConsulta(JTable TblConsulta) {
        this.TblConsulta = TblConsulta;
    }
    
    

}
