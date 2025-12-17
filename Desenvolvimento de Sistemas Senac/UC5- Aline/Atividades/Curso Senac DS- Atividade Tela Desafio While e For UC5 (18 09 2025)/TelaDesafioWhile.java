/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aulasjava;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class TelaDesafioWhile extends JFrame{
    
    private JLabel LblValorProduto, LblPagamento, LblFalta;
    private JTextField TxtValorProduto, TxtValorPagamento, TxtValorExtra;
    
    //Método Construtor
    public TelaDesafioWhile(){
    setTitle("Tela Desafop While");
    setSize(400,350);
    setLocationRelativeTo (null);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    // Painel
    JPanel PainelDesafioWhile = new JPanel();
    PainelDesafioWhile.setLayout(new GridLayout(3, 1, 10, 10));
    // Labels e Botões
    JLabel LblValorProduto = new JLabel("Informe o valor do Produto: ");
    JLabel LblPagamento = new JLabel("Informe o valor da nota que deseja pagar: ");
    TxtValorProduto = new JTextField();
    TxtValorPagamento = new JTextField();
    // Botões
    JPanel PainelBotoes = new JPanel(); 
    JButton BtnSistemaMaquinaVendas = new JButton("Sistema Máquina Vendas");
    PainelBotoes.add(BtnSistemaMaquinaVendas);
    // Ações dos botões
    BtnSistemaMaquinaVendas.addActionListener(e -> pagar());
    
    PainelDesafioWhile.add(LblValorProduto);
    PainelDesafioWhile.add(TxtValorProduto);
    PainelDesafioWhile.add(LblPagamento);
    PainelDesafioWhile.add(TxtValorPagamento);
    PainelDesafioWhile.add(BtnSistemaMaquinaVendas);
    
    add(PainelDesafioWhile);
    }
    
    private void pagar(){
        int valorProduto = Integer.parseInt(TxtValorProduto.getText());
        int valorPagamento = Integer.parseInt(TxtValorPagamento.getText());
        int falta = valorProduto - valorPagamento;
        
        if (valorPagamento < valorProduto){
            while (valorPagamento < valorProduto){
                try{
                    String ValorPedir = JOptionPane.showInputDialog(null, "Está faltando pagar " + falta + "\nDigite mais um valor: ");
                    int ValorPedirInt = Integer.parseInt(ValorPedir);
                    valorPagamento += ValorPedirInt;
                    falta -= ValorPedirInt;
                    int troco = valorPagamento - valorProduto;
                    if (valorPagamento > valorProduto){
                    JOptionPane.showMessageDialog(null, "Você tem um troco de: " + troco);
                    }else{
                        JOptionPane.showMessageDialog(null, "Muito obrigado por pagar!");
                        }
                }catch(NumberFormatException ex){
                      JOptionPane.showMessageDialog(null, "Digite um valor válido");            
               }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Obrigado por comprar!");
        }
     }
}
