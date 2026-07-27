/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listacompras;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaCompras {
    ArrayList<String> listaCompras = new ArrayList(); 

    public ArrayList<String> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(ArrayList<String> listaCompras) {
        this.listaCompras = listaCompras;
    }
    
    public void Adicionar(String produto){
     listaCompras.add(produto);
    }
    
    public void Remover(String produto){
     listaCompras.remove(produto);
    }
    
    public void Listar(){
        System.out.println("Sua Lista está assim: "+getListaCompras());
        System.out.println("Quantidade de Itens: "+getListaCompras().size());
    }
    
public static void main(String[] args) {
        ListaCompras lista = new ListaCompras();
        
        lista.Adicionar("Maçã");
        lista.Listar();
        lista.Remover("Maçã");
        lista.Listar();
    }
}
