// Depende de Model_Veiculo e Model_Motorista

package model_Transportadora;

import java.util.UUID;

public class Model_MotoristaVeiculoLink {
    private UUID id;
    private UUID motoristaId;
    private UUID veiculoId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
    
    public Model_MotoristaVeiculoLink(){
        
        
    }
    
    
}

