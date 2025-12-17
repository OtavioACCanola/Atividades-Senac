/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Atividade_Ordenacao;

import java.util.List;

public class Atividade_Ordenacao {
    
//    public void MergeSort(int[] listaMS){
//        if (listaMS.length > 1){
//            int meio = listaMS.length / 2;
//            int fim = listaMS.length - 1;
//            int [] esquerda = {};
//            int [] direita = {};
//                for (int i = 0; i < meio-1; i++){
//                    int [] valorEsquerda = {};
//                    valorEsquerda[i] = i;
//                    esquerda[i] += valorEsquerda[i];
//                }
//        
//                for (int i= 0; i < fim; i++){
//                    int [] valorDireita = {};
//                    valorDireita[i] = i;
//                    direita[i] += valorDireita[i]; 
//                }
//            System.out.println("Lista Merge Sort a Esquerda: "+ esquerda);
//            System.out.println("Lista Merge sort no Meio: "+ meio);
//            System.out.println("Lista Merge Sort a Direita: "+ direita);
//        }
//        
//    }
    
    public static void main(String[] args) {
 
        MergeSort ms = new MergeSort();

        // Grafo
        
        System.out.println("-- Atividade Grafo --\n");
        Grafo a = new Grafo();
            // Criando Vértice
            a.adicionarVertice("A");
            a.adicionarVertice("B");
            a.adicionarVertice("C");
            a.adicionarVertice("D");
            a.adicionarVertice("E");
        
            // Criando Aresta
            a.adicionarAresta("A","B");
            a.adicionarAresta("A","C");
            a.adicionarAresta("B","D");
            a.adicionarAresta("C","D");
            a.adicionarAresta("D","E");
        
            // Mostrando na Tela
            a.mostrarGrafo();
    
        // Bubble Sort 
        
        System.out.println("\n-- Atividade Bubble Sort --");
        
        int [] listaBS = {5,4,3,2,1};
        
        for (int i = 0; i < listaBS.length ; i++){
            System.out.println("Sua Lista normal: "+listaBS[i]);
        }
        
        System.out.println("\n");
        
        for (int i = 0; i < listaBS.length - 1; i++){
            for (int j = 0; j < listaBS.length -i-1; j++){
                if (listaBS[j] > listaBS[j+1]){
                   int temp = listaBS[j];
                   listaBS[j] = listaBS[j+1];
                   listaBS[j+1] = temp;
            }
        }
    }
        for (int i = 0; i < listaBS.length; i++){
        System.out.println("Sua Lista com Bubble Sort: "+listaBS[i]);
    }
        
    // Insertion Sort 
    
        System.out.println("\n-- Atividade Insertion Sort --");
        
        int [] listaIS = {9,8,5,7,3,1,2,4,6};
        
        for (int i = 1; i < listaIS.length; i++){
            int chave = listaIS[i];
            int j = i - 1;
            while (j >= 0 && listaIS[j] > chave){
                listaIS[j + 1] = listaIS[j];
                j = j-1;
            }listaIS[j + 1] = chave;
        }
        for(int i = 0 ; i < listaIS.length; i++){
            System.out.println("Sua Lista com Insertion Sort: "+listaIS[i]);
        }
        
    // Selection Sort 
    
        System.out.println("\n-- Atividade Selection Sort --");
        
        int [] listaSS = {8,4,9,3,7, 5};
        
        
        for (int i = 0; i < listaSS.length-1; i++){
            int minIndex = i;
            for (int j = i+1; j < listaSS.length;j++){
                if (listaSS[j] < listaSS[minIndex]){
                   minIndex = j;   
                }    
                
            }
            int temp = listaSS[i];
                listaSS[i] = listaSS[minIndex]; // Sempre colocar a troca dos valores depois do loop ''j''
                listaSS[minIndex] = temp;
        }
        for (int i = 0; i < listaSS.length ; i++){
            System.out.println("Sua lista com Selection Sort: "+listaSS[i]);
        }
        
        // Merge Sort 
        
        System.out.println("\n-- Atividade Merge Sort --");
        
        ms.MergeSort();
    }
        
 } 
