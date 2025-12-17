/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aulasjava;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;

class TelaDesafioWhileLacos extends JFrame{
    
    private JTextField TxtvalorPagar, TxtPagamento;
    private JLabel LblvalorPagar, LblPagar, LblSituacao;
    private JButton BtnPagar;
    
    public TelaDesafioWhileLacos(){
        setTitle("Tela Desafio While Máquina de Vendas");
        setSize(450,200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Painel Principal
        JPanel paneDesafio = new JPanel();
        paneDesafio.setLayout(new GridLayout(6,2,10,10));
        
        LblvalorPagar = new JLabel("Informe o valor a ser Pago: ");
        TxtvalorPagar = new JTextField();
        LblPagar = new JLabel("Informe os valores de suas notas / moedas para o pagamento: ");
        TxtPagamento = new JTextField();
        LblSituacao = new JLabel("A conta está com um valor de: ");
        JButton btnPagar = new JButton("Pagar");
        
        btnPagar.addActionListener(e -> gerarPagamentoWhile());       
        
        paneDesafio.add(LblvalorPagar);
        paneDesafio.add(TxtvalorPagar);
        paneDesafio.add(LblPagar);
        paneDesafio.add(TxtPagamento);
        paneDesafio.add(btnPagar);
        paneDesafio.add(LblSituacao);
        
        add(paneDesafio);

        JPanel PanePagar = new JPanel();
        PanePagar.setLayout(new GridLayout(2,1,10,10));
        LblPagar = new JLabel("Informe os valores de suas notas / moedas para o pagamento: ");
        TxtPagamento = new JTextField(); 
        btnPagar = new JButton("Colocar");
    }

        private void gerarPagamentoWhile(){
            try {
                int valorPagamento = Integer.parseInt(TxtvalorPagar.getText());
                int Pagamento = Integer.parseInt(TxtPagamento.getText());
                int totalPago = Pagamento;
                
                if (Pagamento<valorPagamento){
                }            
                
        private void receberPagamento(){
            
        }
                
                
        
}

