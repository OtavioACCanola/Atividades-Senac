package view_Transportadora;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LaboratorioPanel extends JPanel implements Refreshable {
    private final JTextArea out = new JTextArea(18, 100);

    public LaboratorioPanel() {
        super(new BorderLayout());
        out.setEditable(false);
        out.setLineWrap(true);
        out.setWrapStyleWord(true);

        JPanel buttons = new JPanel(new GridLayout(0, 1, 6, 6));
        JButton bStack = new JButton("Pilha (push/pop)");
        bStack.addActionListener(e -> demoStack());
        JButton bQueue = new JButton("Fila (enqueue/dequeue)");
        bQueue.addActionListener(e -> demoQueue());
        JButton bBubble = new JButton("Ordenacao: BubbleSort");
        bBubble.addActionListener(e -> demoBubble());
        JButton bMerge = new JButton("Ordenacao: MergeSort");
        bMerge.addActionListener(e -> demoMerge());
        JButton bBuscaLin = new JButton("Busca Linear");
        bBuscaLin.addActionListener(e -> demoBuscaLinear());
        JButton bBuscaBin = new JButton("Busca Binaria");
        bBuscaBin.addActionListener(e -> demoBuscaBinaria());

        buttons.add(bStack);
        buttons.add(bQueue);
        buttons.add(bBubble);
        buttons.add(bMerge);
        buttons.add(bBuscaLin);
        buttons.add(bBuscaBin);

        add(new JScrollPane(out), BorderLayout.CENTER);
        add(buttons, BorderLayout.EAST);

        JTextArea legend = new JTextArea(
            "Laboratorio: exemplos de Estruturas/Algoritmos. " +
            "Execute os botoes e observe a saida passo a passo."
        );
        legend.setEditable(false);
        add(legend, BorderLayout.NORTH);
    }

    private void demoStack() {
        out.setText("");
        Stack<Integer> pilha = new Stack<>();
        for (int n : new int[]{10, 20, 30, 40, 50}) {
            pilha.push(n);
            out.append("push: " + n + " -> " + pilha + "\n");
        }
        out.append("\n");
        out.append("pop: " + pilha.pop() + " -> " + pilha + "\n");
        out.append("pop: " + pilha.pop() + " -> " + pilha + "\n");
        out.append("Topo: " + pilha.peek() + "\n");
    }

    private void demoQueue() {
        out.setText("");
        Queue<String> fila = new LinkedList<>();
        for (String s : new String[]{"Ana", "Bruno", "Carla", "Diego"}) {
            fila.add(s);
            out.append("enqueue: " + s + " -> " + fila + "\n");
        }
        out.append("\n");
        out.append("dequeue: " + fila.remove() + " -> " + fila + "\n");
        out.append("dequeue: " + fila.remove() + " -> " + fila + "\n");
        out.append("Proximo: " + fila.peek() + "\n");
    }

    private void demoBubble() {
        out.setText("");
        int[] a = {7, 2, 9, 4, 1};
        out.append("Inicial: " + Arrays.toString(a) + "\n");
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j]; a[j] = a[j + 1]; a[j + 1] = t;
                }
                out.append("Passo (i=" + i + ", j=" + j + "): " + Arrays.toString(a) + "\n");
            }
        }
        out.append("Ordenado: " + Arrays.toString(a) + "\n");
    }

    private void demoMerge() {
        out.setText("");
        int[] a = {7, 4, 6, 2};
        out.append("Inicial: " + Arrays.toString(a) + "\n");
        mergeSort(a, 0, a.length - 1);
        out.append("Ordenado: " + Arrays.toString(a) + "\n");
    }

    private void mergeSort(int[] a, int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;
        mergeSort(a, l, m);
        mergeSort(a, m + 1, r);
        merge(a, l, m, r);
    }

    private void merge(int[] a, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(a, l, L, 0, n1);
        System.arraycopy(a, m + 1, R, 0, n2);
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) a[k++] = L[i++];
            else a[k++] = R[j++];
            out.append("merge passo: " + Arrays.toString(a) + "\n");
        }
        while (i < n1) { a[k++] = L[i++]; out.append("merge passo: " + Arrays.toString(a) + "\n"); }
        while (j < n2) { a[k++] = R[j++]; out.append("merge passo: " + Arrays.toString(a) + "\n"); }
    }

    private void demoBuscaLinear() {
        out.setText("");
        int[] v = {15, 22, 8, 19, 31, 4};
        int alvo = 19;
        out.append("Vetor: " + Arrays.toString(v) + " - alvo=" + alvo + "\n");
        for (int i = 0; i < v.length; i++) {
            out.append("Comparando v[" + i + "]=" + v[i] + "\n");
            if (v[i] == alvo) {
                out.append("Encontrado na posicao " + i + "\n");
                return;
            }
        }
        out.append("Nao encontrado\n");
    }

    private void demoBuscaBinaria() {
        out.setText("");
        int[] v = {3, 7, 14, 18, 21, 27, 32, 40};
        int alvo = 21;
        out.append("Vetor ordenado: " + Arrays.toString(v) + " - alvo=" + alvo + "\n");
        int l = 0, r = v.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            out.append("Meio index=" + m + " valor=" + v[m] + "\n");
            if (v[m] == alvo) {
                out.append("Encontrado na posicao " + m + "\n");
                return;
            }
            if (v[m] < alvo) l = m + 1; else r = m - 1;
        }
        out.append("Nao encontrado\n");
    }

    @Override
    public void refresh() {
        // nada a atualizar ao trocar de aba
    }
}