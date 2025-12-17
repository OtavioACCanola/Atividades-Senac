/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Atividade_Ordenacao;

/**
 *
 * @author Dell
 */
public class MergeSort {
    
    public void MergeSort(){
        int [] listaMS = {8,7,9};
        
        if (listaMS.length > 1){
            int meio = listaMS.length / 2;
            int [] esquerda = new int[meio-1];
            int [] direita = new int[listaMS.length];
            
            for (int i = 0; i > listaMS.length; i++){
                System.out.println("Lista Merge Sort a Esquerda: "+ esquerda[i]);
                System.out.println("Lista Merge sort no Meio: "+ meio);
                System.out.println("Lista Merge Sort a Direita: "+ direita[i]);
        }
        }
    }
}
