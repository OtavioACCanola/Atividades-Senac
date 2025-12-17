/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade_nivel_desafio_banco;

/**
 *
 * @author otavio.accarmo
 */
abstract class Conta {
    private String titular;
    private float saldo;

    public Conta (String titular, float saldo){
        this.saldo = saldo;
        this.titular = titular;
    }
    
    abstract void sacar(double valor);
    
    abstract void depositar(double valor);
}
