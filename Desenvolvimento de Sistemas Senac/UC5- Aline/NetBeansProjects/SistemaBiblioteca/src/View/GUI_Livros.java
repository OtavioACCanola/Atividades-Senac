/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import javax.swing.JTable;
import javax.swing.JTextField;
import DAO.LivroDAO;
import Controller.LivroConn;
import Model.Livro;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.*;

/**
 *
 * @author otavio.accarmo
 */
public class GUI_Livros extends javax.swing.JFrame {

    private LivroDAO contr = new LivroDAO();

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUI_Livros.class.getName());

    public LivroDAO getController() {
        return this.contr;
    }

    public void setDao(LivroDAO dao) {
        this.contr = dao;
    }

    public GUI_Livros() {
        initComponents();
        preencherTabela();
    }

    public void preencherTabela() {

        DefaultTableModel modelo = (DefaultTableModel) getTblLivro().getModel();
        modelo.setRowCount(0);

        try {

            List<Livro> lista = getController().popularTabela();

            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum Empréstimo para esse Usuário Encontrado", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }
            for (Livro model : lista) {
                modelo.addRow(new Object[]{
                    model.getId(),
                    model.getTitulo(),
                    model.getAutor(),
                    model.getQuantidade(),});
            }

        } catch (Exception e) {
            System.out.println("Erro ao carregar Tabela: " + e.getMessage());

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LblAutor = new javax.swing.JLabel();
        TxtAutor = new javax.swing.JTextField();
        BtnCadastrar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TblLivro = new javax.swing.JTable();
        BtnCancelar = new javax.swing.JButton();
        LblTituloLivros = new javax.swing.JLabel();
        LblTitulo = new javax.swing.JLabel();
        TxtTitulo = new javax.swing.JTextField();
        LblQuantidade = new javax.swing.JLabel();
        TxtQuantidade = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LblAutor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LblAutor.setText("Autor:");
        LblAutor.setAlignmentX(0.5F);

        BtnCadastrar.setText("Cadastrar");
        BtnCadastrar.addActionListener(this::BtnCadastrarActionPerformed);

        TblLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Título", "Autor", "Quantidade", "Disponível"
            }
        ));
        jScrollPane4.setViewportView(TblLivro);

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(this::BtnCancelarActionPerformed);

        LblTituloLivros.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        LblTituloLivros.setText("Livros");
        LblTituloLivros.setAlignmentX(0.5F);

        LblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LblTitulo.setText("Titulo:");
        LblTitulo.setAlignmentX(0.5F);

        TxtTitulo.addActionListener(this::TxtTituloActionPerformed);

        LblQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LblQuantidade.setText("Quantidade:");
        LblQuantidade.setAlignmentX(0.5F);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(25, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(LblAutor)
                                    .addComponent(LblTitulo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtAutor)
                                    .addComponent(TxtTitulo)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(LblTituloLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(BtnCadastrar)
                                        .addGap(18, 18, 18)
                                        .addComponent(BtnCancelar))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(LblQuantidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblTituloLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCadastrar)
                    .addComponent(BtnCancelar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadastrarActionPerformed
        String titulo = getTxtTitulo().getText().trim();
        String autor = getTxtAutor().getText().trim();
        String quantidadeTxtQuantidade = getTxtQuantidade().getText().trim();

        if (titulo.isEmpty() || autor.isEmpty() || quantidadeTxtQuantidade.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os Campos devem Estar Preenchidos", "Alerta", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {

            int quantidade = Integer.parseInt(quantidadeTxtQuantidade);

            if (quantidade < 0) {
                JOptionPane.showMessageDialog(null, "A Quantidade precisa ser Maior ou Igual a 0", "Alerta", JOptionPane.ERROR_MESSAGE);
            } else {

                LivroConn conn = new LivroConn();

                conn.cadastrarLivro(getTxtTitulo().getText(), getTxtAutor().getText(), quantidade);

                JOptionPane.showMessageDialog(null, "Livro Cadastrado com Sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                this.preencherTabela();

            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Quantidade deve ser um Número Válido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnCadastrarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        GUI_OpcoesBiblioteca guiPrinc = new GUI_OpcoesBiblioteca();

        this.dispose();

        guiPrinc.setLocationRelativeTo(null);
        guiPrinc.setVisible(true);       }//GEN-LAST:event_BtnCancelarActionPerformed

    private void TxtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtTituloActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new GUI_Livros().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCadastrar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JLabel LblAutor;
    private javax.swing.JLabel LblQuantidade;
    private javax.swing.JLabel LblTitulo;
    private javax.swing.JLabel LblTituloLivros;
    private javax.swing.JTable TblLivro;
    private javax.swing.JTextField TxtAutor;
    private javax.swing.JTextField TxtQuantidade;
    private javax.swing.JTextField TxtTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables

    public JTextField getTxtAutor() {
        return TxtAutor;
    }

    public void setTxtAutor(JTextField TxtAutor) {
        this.TxtAutor = TxtAutor;
    }

    public JTextField getTxtTitulo() {
        return TxtTitulo;
    }

    public void setTxtTitulo(JTextField TxtTitulo) {
        this.TxtTitulo = TxtTitulo;
    }

    public JTable getTblLivro() {
        return TblLivro;
    }

    public void setTblLivro(JTable TblLivro) {
        this.TblLivro = TblLivro;
    }

    public JTextField getTxtQuantidade() {
        return TxtQuantidade;
    }

    public void setTxtQuantidade(JTextField TxtQuantidade) {
        this.TxtQuantidade = TxtQuantidade;
    }

}
