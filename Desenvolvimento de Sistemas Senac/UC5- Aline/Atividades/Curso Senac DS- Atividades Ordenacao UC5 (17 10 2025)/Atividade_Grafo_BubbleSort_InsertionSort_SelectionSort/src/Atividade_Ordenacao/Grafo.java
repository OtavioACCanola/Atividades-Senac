/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Atividade_Ordenacao;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Grafo {
    public Queue <String> Vertices = new LinkedList();

    private Map<String, List<String>> adjacencia;    
    public Grafo(){
            adjacencia = new HashMap<>();
        }
        // Adicionar um Vértice 
        public void adicionarVertice (String v){
            adjacencia.putIfAbsent(v, new ArrayList<>());
            Vertices.add(v);
        }
        // Adicionar uma Aresta (Não Direcionada)
        public void adicionarAresta (String origem, String destino){
            adjacencia.get(origem).add(destino);
            adjacencia.get(destino).add(origem); // Remover está linha se quiser grafo direcionado 
            
        }
        // Mostra o Grafo
        public void mostrarGrafo(){
            for (var v : adjacencia.keySet()) {
                System.out.println(v + "-> " + adjacencia.get(v));
        }
            System.out.println("Saída em ordem BFS:" + Vertices);
    }
}
