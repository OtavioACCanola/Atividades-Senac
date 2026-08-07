/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aulasjava;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaDesafioListaCompras extends JFrame {
    JLabel Lbl_Produto;
    JTextField Txt_Produto;
    public StringBuilder ListaCompra;

    public StringBuilder getListaCompra() {
        return ListaCompra;
    }

    public void setListaCompra(StringBuilder ListaCompra) {
        this.ListaCompra = ListaCompra;
    }
    
    public TelaDesafioListaCompras(){
        setTitle("Tela Desafio Lista de Compras");
        setSize(300,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JPanel TelaDesafioListaCompras = new JPanel();
        TelaDesafioListaCompras.setLayout(new GridLayout(4,2,10,10));
        
        JLabel Lbl_Produto = new JLabel("Digite o nome do Produto: ");
        Txt_Produto = new JTextField();
        this.ListaCompra = new StringBuilder();
        
        JButton BtnAdicionar = new JButton("Adicionar");
        JButton BtnVisualizar = new JButton("Visualizar");
        
        BtnAdicionar.addActionListener(e -> Adicionar());
        BtnVisualizar.addActionListener(e -> Visualizar());
        
        TelaDesafioListaCompras.add(Lbl_Produto);
        TelaDesafioListaCompras.add(Txt_Produto);
        TelaDesafioListaCompras.add(BtnAdicionar);
        TelaDesafioListaCompras.add(BtnVisualizar);
    
        add(TelaDesafioListaCompras);
    }
    
        public void Adicionar(){
        try{
            if (ListaCompra == null){
                JOptionPane.showMessageDialog(null, "Digite um produto");
            }
            ListaCompra.append(Txt_Produto.getText());
            JOptionPane.showMessageDialog(null, "Produto Adicionado com Sucesso!");
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Escreva um produto válido!");
        }}
        
        public void Visualizar(){
        try{
            StringBuilder MensagemLista = new StringBuilder("Sua lista está assim: \n");
            JOptionPane.showMessageDialog(null, MensagemLista.append(ListaCompra));
        }catch(NullPointerException ex){
            JOptionPane.showMessageDialog(null, "Digite um produto Primeiro!");
        }
    }
}
