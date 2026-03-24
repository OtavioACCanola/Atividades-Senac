/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testefinanceiropi;

/**
 *
 * @author otavio.accarmo
 */
public class Financeiro {
    private float saldo;

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public void computarValor(float pagamento){
        this.saldo += pagamento;
    }
}
