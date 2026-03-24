/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import Controller.EmprestimoDevolucaoConn;
import DAO.UsuarioDAO;
import DAO.EmprestimoDAO;
import DAO.LivroDAO;
import Model.Livro;
import Model.Usuario;

import java.util.*;


public class GUI_Emprestimo_Devolucao extends javax.swing.JFrame {
    
    private UsuarioDAO Usudao = new UsuarioDAO();
    private LivroDAO Livdao = new LivroDAO();
    private EmprestimoDAO empreDAO = new EmprestimoDAO();
    
    private EmprestimoDevolucaoConn emdeConn = new EmprestimoDevolucaoConn();

    private GUI_OpcoesBiblioteca guiOp = new GUI_OpcoesBiblioteca();
    
    public UsuarioDAO getUsudao() {
        return Usudao;
    }

    public void setUsudao(UsuarioDAO Usudao) {
        this.Usudao = Usudao;
    }

    public LivroDAO getLivdao() {
        return Livdao;
    }

    public void setLivdao(LivroDAO Livdao) {
        this.Livdao = Livdao;
    }

    public EmprestimoDAO getEmpreDAO() {
        return empreDAO;
    }

    public void setEmpreDAO(EmprestimoDAO empreDAO) {
        this.empreDAO = empreDAO;
    }

    public EmprestimoDevolucaoConn getEmdeConn() {
        return emdeConn;
    }

    public void setEmdeConn(EmprestimoDevolucaoConn emdeConn) {
        this.emdeConn = emdeConn;
    }

    public GUI_OpcoesBiblioteca getGuiOp() {
        return guiOp;
    }

    public void setGuiOp(GUI_OpcoesBiblioteca guiOp) {
        this.guiOp = guiOp;
    }
    
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUI_Emprestimo_Devolucao.class.getName());

    /**
     * Creates new form GUI_Emprestimo_Devolucao
     */
    public GUI_Emprestimo_Devolucao() {
        initComponents();
        preencherComboUsuario();
        preencherComboLivro();   
    }

    private void preencherComboUsuario() {
    try {    
    getCobNomeEmpre().removeAllItems(); // Limpa os "Item 1", "Item 2"
    getCobNome().removeAllItems();
    
    List<Usuario> lista = getUsudao().listarUsuarios();
    
    for (Usuario u : lista) {
        getCobNomeEmpre().addItem(u);
        getCobNome().addItem(u);
    }
    }catch (Exception e) {
        System.out.println("Erro ao carregar usuários: " + e.getMessage());
        }
    }
    
    private void preencherComboLivro() {
    try {  
    getCobLivroEmpre().removeAllItems(); // Limpa os "Item 1", "Item 2"
    
    List<Livro> lista = getLivdao().listarLivroComboBox();
    
    for (Livro u : lista) {
        getCobLivroEmpre().addItem(u);
        getCobLivro().addItem(u);
    }
    }catch (Exception e) {
        System.out.println("Erro ao carregar usuários: " + e.getMessage());
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Pnl_Emprestimo_Devolucao = new javax.swing.JPanel();
        PnlDevolucao = new javax.swing.JPanel();
        LblTituloDevolucao = new javax.swing.JLabel();
        LblNomeDevolucao = new javax.swing.JLabel();
        CobNome = new javax.swing.JComboBox<>();
        LblLivroDevolucao = new javax.swing.JLabel();
        CobLivro = new javax.swing.JComboBox<>();
        BtnDevolver = new javax.swing.JButton();
        PnlEmprestimo = new javax.swing.JPanel();
        LblTituloEmprestimo = new javax.swing.JLabel();
        LblNomeEmprestimo = new javax.swing.JLabel();
        CobNomeEmpre = new javax.swing.JComboBox<>();
        LblLivroEmprestimo = new javax.swing.JLabel();
        CobLivroEmpre = new javax.swing.JComboBox<>();
        BtnEmprestar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        BtnConsultarEmprestimo = new javax.swing.JButton();

        jButton1.setText("Consultar Empréstimos");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        Pnl_Emprestimo_Devolucao.setName("Empréstimos e Devoluções"); // NOI18N

        PnlDevolucao.setBackground(new java.awt.Color(255, 255, 255));
        PnlDevolucao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        LblTituloDevolucao.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        LblTituloDevolucao.setText("Devolução");
        LblTituloDevolucao.setAlignmentX(0.5F);

        LblNomeDevolucao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LblNomeDevolucao.setText("Nome:");
        LblNomeDevolucao.setAlignmentX(0.5F);

        CobNome.addActionListener(this::CobNomeActionPerformed);

        LblLivroDevolucao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LblLivroDevolucao.setText("Livro:");
        LblLivroDevolucao.setAlignmentX(0.5F);

        CobLivro.addActionListener(this::CobLivroActionPerformed);

        BtnDevolver.setText("Devolver");
        BtnDevolver.addActionListener(this::BtnDevolverActionPerformed);

        javax.swing.GroupLayout PnlDevolucaoLayout = new javax.swing.GroupLayout(PnlDevolucao);
        PnlDevolucao.setLayout(PnlDevolucaoLayout);
        PnlDevolucaoLayout.setHorizontalGroup(
            PnlDevolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlDevolucaoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(PnlDevolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnDevolver)
                    .addGroup(PnlDevolucaoLayout.createSequentialGroup()
                        .addGroup(PnlDevolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LblLivroDevolucao)
                            .addComponent(LblNomeDevolucao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PnlDevolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CobNome, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CobLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlDevolucaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LblTituloDevolucao)
                .addGap(87, 87, 87))
        );
        PnlDevolucaoLayout.setVerticalGroup(
            PnlDevolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlDevolucaoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(LblTituloDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(PnlDevolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblNomeDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CobNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PnlDevolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LblLivroDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CobLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BtnDevolver)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        PnlEmprestimo.setBackground(new java.awt.Color(255, 255, 255));
        PnlEmprestimo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        LblTituloEmprestimo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        LblTituloEmprestimo.setText("Empréstimo");
        LblTituloEmprestimo.setAlignmentX(0.5F);

        LblNomeEmprestimo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LblNomeEmprestimo.setText("Nome:");
        LblNomeEmprestimo.setAlignmentX(0.5F);

        CobNomeEmpre.addActionListener(this::CobNomeEmpreActionPerformed);

        LblLivroEmprestimo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LblLivroEmprestimo.setText("Livro:");
        LblLivroEmprestimo.setAlignmentX(0.5F);

        CobLivroEmpre.addActionListener(this::CobLivroEmpreActionPerformed);

        BtnEmprestar.setText("Emprestar");
        BtnEmprestar.addActionListener(this::BtnEmprestarActionPerformed);

        javax.swing.GroupLayout PnlEmprestimoLayout = new javax.swing.GroupLayout(PnlEmprestimo);
        PnlEmprestimo.setLayout(PnlEmprestimoLayout);
        PnlEmprestimoLayout.setHorizontalGroup(
            PnlEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlEmprestimoLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(PnlEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlEmprestimoLayout.createSequentialGroup()
                        .addGroup(PnlEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnEmprestar)
                            .addGroup(PnlEmprestimoLayout.createSequentialGroup()
                                .addGroup(PnlEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(LblLivroEmprestimo)
                                    .addComponent(LblNomeEmprestimo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PnlEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CobNomeEmpre, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CobLivroEmpre, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlEmprestimoLayout.createSequentialGroup()
                        .addComponent(LblTituloEmprestimo)
                        .addGap(88, 88, 88))))
        );
        PnlEmprestimoLayout.setVerticalGroup(
            PnlEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlEmprestimoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(LblTituloEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(PnlEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblNomeEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CobNomeEmpre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PnlEmprestimoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LblLivroEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CobLivroEmpre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnEmprestar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Pnl_Emprestimo_DevolucaoLayout = new javax.swing.GroupLayout(Pnl_Emprestimo_Devolucao);
        Pnl_Emprestimo_Devolucao.setLayout(Pnl_Emprestimo_DevolucaoLayout);
        Pnl_Emprestimo_DevolucaoLayout.setHorizontalGroup(
            Pnl_Emprestimo_DevolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_Emprestimo_DevolucaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PnlEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnlDevolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Pnl_Emprestimo_DevolucaoLayout.setVerticalGroup(
            Pnl_Emprestimo_DevolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_Emprestimo_DevolucaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_Emprestimo_DevolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PnlEmprestimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PnlDevolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(this::BtnCancelarActionPerformed);

        BtnConsultarEmprestimo.setText("Consultar Empréstimos");
        BtnConsultarEmprestimo.addActionListener(this::BtnConsultarEmprestimoActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnl_Emprestimo_Devolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnConsultarEmprestimo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnCancelar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pnl_Emprestimo_Devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCancelar)
                    .addComponent(BtnConsultarEmprestimo))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CobNomeEmpreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CobNomeEmpreActionPerformed

    }//GEN-LAST:event_CobNomeEmpreActionPerformed

    private void CobLivroEmpreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CobLivroEmpreActionPerformed
    
    }//GEN-LAST:event_CobLivroEmpreActionPerformed

    private void BtnEmprestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEmprestarActionPerformed
         try {       
             
                Usuario selecionadoNome = (Usuario) getCobNomeEmpre().getSelectedItem();
                Livro selecionadoLivro = (Livro) getCobLivroEmpre().getSelectedItem();
                
                if (selecionadoNome != null || selecionadoLivro != null){
                    int idUsu = selecionadoNome.getId();
                    int idLiv = selecionadoLivro.getId();
                
                    getEmdeConn().cadastrarEmprestimo(idUsu, idLiv);
                    
                    JOptionPane.showMessageDialog(null, "Empréstimo Cadastrado com Sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro ao Criar Empréstimo", "Erro", JOptionPane.ERROR_MESSAGE);
         }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Quantidade deve ser um Número Válido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_BtnEmprestarActionPerformed

    private void CobLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CobLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CobLivroActionPerformed

    private void BtnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDevolverActionPerformed
try {       
                
                Usuario selecionadoNome = (Usuario) getCobNomeEmpre().getSelectedItem();
                Livro selecionadoLivro = (Livro) getCobLivroEmpre().getSelectedItem();
                
                if (selecionadoNome != null || selecionadoLivro != null){
                    int idUsu = selecionadoNome.getId();
                    int idLiv = selecionadoLivro.getId();
                
                    getEmdeConn().devolverLivro(idUsu, idLiv);
                    
                    JOptionPane.showMessageDialog(null, "Empréstimo Cadastrado com Sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro ao Criar Empréstimo", "Erro", JOptionPane.ERROR_MESSAGE);
         }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Quantidade deve ser um Número Válido", "Erro", JOptionPane.ERROR_MESSAGE);
        }    }//GEN-LAST:event_BtnDevolverActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
    GUI_OpcoesBiblioteca guiPrinc = getGuiOp();
    this.dispose();
        
    getGuiOp().setLocationRelativeTo(null);
    
    guiPrinc.setVisible(true);      }//GEN-LAST:event_BtnCancelarActionPerformed

    private void CobNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CobNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CobNomeActionPerformed

    private void BtnConsultarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConsultarEmprestimoActionPerformed
    GUI_Consulta guiCon = new GUI_Consulta(); 
        
    this.dispose();
        
    guiCon.setLocationRelativeTo(null);
    guiCon.setVisible(true);      
              }//GEN-LAST:event_BtnConsultarEmprestimoActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new GUI_Emprestimo_Devolucao().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnConsultarEmprestimo;
    private javax.swing.JButton BtnDevolver;
    private javax.swing.JButton BtnEmprestar;
    private javax.swing.JComboBox<Model.Livro> CobLivro;
    private javax.swing.JComboBox<Model.Livro> CobLivroEmpre;
    private javax.swing.JComboBox<Model.Usuario> CobNome;
    private javax.swing.JComboBox<Model.Usuario> CobNomeEmpre;
    private javax.swing.JLabel LblLivroDevolucao;
    private javax.swing.JLabel LblLivroEmprestimo;
    private javax.swing.JLabel LblNomeDevolucao;
    private javax.swing.JLabel LblNomeEmprestimo;
    private javax.swing.JLabel LblTituloDevolucao;
    private javax.swing.JLabel LblTituloEmprestimo;
    private javax.swing.JPanel PnlDevolucao;
    private javax.swing.JPanel PnlEmprestimo;
    private javax.swing.JPanel Pnl_Emprestimo_Devolucao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables

 
    public JComboBox<Livro> getCobLivroEmpre() {
        return CobLivroEmpre;
    }

    public void setCobLivroEmpre(JComboBox<Livro> CobLivroEmpre) {
        this.CobLivroEmpre = CobLivroEmpre;
    }

    public JComboBox<Usuario> getCobNomeEmpre() {
        return CobNomeEmpre;
    }

    public void setCobNomeEmpre(JComboBox<Usuario> CobNomeEmpre) {
        this.CobNomeEmpre = CobNomeEmpre;
    }

    public JComboBox<Livro> getCobLivro() {
        return CobLivro;
    }

    public void setCobLivro(JComboBox<Livro> CobLivro) {
        this.CobLivro = CobLivro;
    }

    public JComboBox<Usuario> getCobNome() {
        return CobNome;
    }

    public void setCobNome(JComboBox<Usuario> CobNome) {
        this.CobNome = CobNome;
    }

  }
