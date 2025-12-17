// Depende de Model_Rota / Model_Motorista / Model_Veiculo / Model_Transportadora
package model_Transportadora;

import java.util.Date;
import java.util.UUID;
import java.time.LocalDateTime;

public class Model_Frete {
    private UUID id;
    private UUID transportadoraID;
    private UUID motoristaId;
    private UUID veiculoId;
    private UUID rotaId;
    private LocalDateTime dataHora;
    private double valor;

    public Model_Frete(UUID transportadoraID, UUID motoristaID, UUID veiculoID, UUID rotaID, LocalDateTime dataHora, double valor){
        this.transportadoraID = transportadoraID;
        this.motoristaId = motoristaID;
        this.veiculoId = veiculoID;
        this.rotaId = rotaID;
        this.dataHora = dataHora;
        this.valor = valor;
}
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getTransportadoraID() {
        return transportadoraID;
    }

    public void setTransportadoraID(UUID transportadoraID) {
        this.transportadoraID = transportadoraID;
    }

    public UUID getMotoristaId() {
        return motoristaId;
    }

    public void setMotoristaId(UUID motoristaId) {
        this.motoristaId = motoristaId;
    }

    public UUID getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(UUID veiculoId) {
        this.veiculoId = veiculoId;
    }

    public UUID getRotaId() {
        return rotaId;
    }

    public void setRotaId(UUID rotaId) {
        this.rotaId = rotaId;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    

}
