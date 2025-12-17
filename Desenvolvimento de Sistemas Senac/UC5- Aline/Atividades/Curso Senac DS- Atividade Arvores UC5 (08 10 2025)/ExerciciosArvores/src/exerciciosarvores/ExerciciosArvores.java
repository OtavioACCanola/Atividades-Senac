/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exerciciosarvores;

class Node {
    int valor;
    Node esquerda, direita;
    public Node(int valor){
        this.valor = valor;
        esquerda = direita = null;
    }
}

class ArvoreBinaria {
    Node raiz;
    // Inserção Recursiva
    public Node Inserir(Node raiz, int valor){
        if (raiz == null){
            return new Node(valor);
        }
        if(valor < raiz.valor){
            raiz.esquerda = Inserir(raiz.esquerda, valor);
        }
        else if (valor > raiz.valor) {
            raiz.direita = Inserir (raiz.direita, valor);
        }
        return raiz;
}
    // Percurso em Ordem (In-Order): Esquerda, Raiz, Direita
    public void emOrdem (Node raiz){
        if (raiz != null){
            emOrdem(raiz.esquerda);
            System.out.println(raiz.valor + " ");
            emOrdem(raiz.direita);
    }
  }
    
    public void preOrdem (Node raiz){
        if (raiz != null) {
            preOrdem(raiz);
            System.out.println(raiz.valor + "");
            preOrdem(raiz.esquerda);
            System.out.println(raiz.valor + "");
            preOrdem(raiz.direita);
        }
    }
}  

public class ExerciciosArvores {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        // Inserindo Elementos
        
        arvore.raiz = arvore.Inserir(arvore.raiz, 50);
        arvore.Inserir(arvore.raiz, 30);
        arvore.Inserir(arvore.raiz, 70);
        arvore.Inserir(arvore.raiz, 20);
        arvore.Inserir(arvore.raiz, 40);
        arvore.Inserir(arvore.raiz, 60);
        arvore.Inserir(arvore.raiz, 80); 
        System.out.println("Percurso em Ordem (valores Organizados):");
        arvore.emOrdem(arvore.raiz);
        System.out.println("Percurso Raiz -> Esquerda -> Direita ");
        arvore.preOrdem(arvore.raiz);
    }
}
