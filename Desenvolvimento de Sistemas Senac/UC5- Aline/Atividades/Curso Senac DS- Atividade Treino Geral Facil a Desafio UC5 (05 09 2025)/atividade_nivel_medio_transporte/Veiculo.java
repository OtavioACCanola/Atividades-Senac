/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade_nivel_medio_transporte;

/**
 *
 * @author otavio.accarmo
 */
abstract class Veiculo {
    private String placa;

    
    public Veiculo(String placa){
        this.placa = placa;
    }
            
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    abstract void mover();

}
