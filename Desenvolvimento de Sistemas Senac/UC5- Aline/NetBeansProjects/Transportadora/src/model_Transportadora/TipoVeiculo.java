package model_Transportadora;

public enum TipoVeiculo {
    MOTO(0.50), CARRO(1.00), CAMINHAO(2.50);
    private final double custoPorKm;
    
    TipoVeiculo(double custo){
        this.custoPorKm = custo;
    }
    
    public double getCustoPorKm(){
        return custoPorKm;
    }
}
