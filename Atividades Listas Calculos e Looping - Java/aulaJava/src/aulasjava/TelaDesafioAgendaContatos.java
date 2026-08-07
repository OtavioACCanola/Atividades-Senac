/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aulasjava;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaDesafioAgendaContatos extends JFrame{
    JTextField TxtTelefones, TxtNomes;
    JLabel LblTelefone, LblNome;
    
    public TelaDesafioAgendaContatos(){
        setTitle("Tela Desafio Elaborado");
        setSize(300,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
        JPanel TelaDesafioAgenda = new JPanel();
        TelaDesafioAgenda.setLayout(new GridLayout(4,2,10,10));
        
        LblTelefone = new JLabel("Telefone");
        LblNome = new JLabel("Nome");
        TxtTelefones = new JTextField();
        TxtNomes = new JTextField();
        
        JButton BtnAdicionar = new JButton("Adicionar");
        JButton BtnVisualizar = new JButton("Visualizar");
    
        BtnAdicionar.addActionListener(e -> Adicionar());
        BtnVisualizar.addActionListener(e -> Visualizar());
        
        TelaDesafioAgenda.add(LblTelefone);
        TelaDesafioAgenda.add(TxtTelefones);
        TelaDesafioAgenda.add(LblNome);
        TelaDesafioAgenda.add(TxtNomes);
        TelaDesafioAgenda.add(BtnAdicionar);
        TelaDesafioAgenda.add(BtnVisualizar);
        
        add(TelaDesafioAgenda);
    }
    
    ArrayList<Contatos> Contatos = new ArrayList<>();
    public void Adicionar(){
        if(TxtTelefones.getText().isEmpty() || TxtNomes.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Informe um valor várlido!!", "AVISO!", JOptionPane.WARNING_MESSAGE);

        }else{
          Contatos NovoContato = new Contatos(TxtNomes.getText(), TxtTelefones.getText());
          Contatos.add(NovoContato);
          JOptionPane.showMessageDialog(null, "Contato Inserido com Sucesso!");
                  }
    }
    
    public void Visualizar(){
        if(Contatos.isEmpty()){
        JOptionPane.showMessageDialog(null, "Não existe nenhum contato salvo, adicione um contato, por favor!", "AVISO!", JOptionPane.WARNING_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Sua lista está assim: " + Contatos.toString());
        }
    }
}
