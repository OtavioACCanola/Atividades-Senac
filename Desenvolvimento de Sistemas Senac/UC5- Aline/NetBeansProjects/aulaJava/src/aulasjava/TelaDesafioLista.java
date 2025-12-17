/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aulasjava;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author otavio.accarmo
 */
class TelaDesafioLista extends JFrame{
    
    public TelaDesafioLista(){
        setTitle("Tela Desafio Lista");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JPanel TelaDesafiosLista = new JPanel();
        TelaDesafiosLista.setLayout(new GridLayout(4, 2, 10, 10));
        
        JButton BtnListaCompras = new JButton("Desafio ArrayList");
        JButton BtnListaTarefas = new JButton("Desafio CRUD");
        JButton BtnListaContatos = new JButton("Desafio Elaborado");
        
        BtnListaCompras.addActionListener(e->{
            new TelaDesafioListaCompras().setVisible(true);
        });
        BtnListaContatos.addActionListener(e->{;
            new TelaDesafioAgendaContatos().setVisible(true);
        });
        
        TelaDesafiosLista.add(BtnListaCompras);
        TelaDesafiosLista.add(BtnListaTarefas);
        TelaDesafiosLista.add(BtnListaContatos);
        
        add(TelaDesafiosLista);
    }
}
