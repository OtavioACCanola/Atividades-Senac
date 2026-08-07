// Vive sem Model_Transportadora 
// Depende de Model_TipoVeiculo
package model_Transportadora;

import java.util.UUID;
        
public abstract class Veiculo {
    private UUID id;
    private UUID transportadoraId;
    private String placa;
    private String modelo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getTransportadoraId() {
        return transportadoraId;
    }

    public void setTransportadoraId(UUID transportadoraId) {
        this.transportadoraId = transportadoraId;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public TipoVeiculo getTipo(){
        return getTipo();
    }
    
    @Override
    public String toString(){
        return getTipo()+ "/" + placa + " (" + modelo + ")";
    }
    }