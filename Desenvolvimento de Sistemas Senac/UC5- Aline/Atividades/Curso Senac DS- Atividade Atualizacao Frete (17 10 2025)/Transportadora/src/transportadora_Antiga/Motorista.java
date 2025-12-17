/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportadora_Antiga;

/**
 *
 * @author otavio.accarmo
 */
public class Motorista {
    private String nome;
    private String CPF;
    private String CNH;
    private double salarioBase;
    
    public Motorista (String nome, String CPF, double salarioBase){
        setNome(nome);
        setCPF(CPF);
        setSalarioBase(salarioBase);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCNH() {
        return CNH;
    }

    public void setCNH(String CNH) {
        this.CNH = CNH;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    
    public void registrarFrete (Frete frete){
        System.out.println("Frete registrado");
    }
    
    public double calcularPagamento (double valorFrete){
        double pagamento = getSalarioBase() + valorFrete;
        System.out.println("Valor Pagamento do Motorista: R$ " + pagamento);
        return pagamento;
    }
}   
