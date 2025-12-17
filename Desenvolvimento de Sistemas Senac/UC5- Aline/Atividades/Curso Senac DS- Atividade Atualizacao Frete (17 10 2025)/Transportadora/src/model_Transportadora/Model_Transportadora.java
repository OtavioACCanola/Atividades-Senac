// Vive sem Model_Veiculo / Model_Motorista

package model_Transportadora;

import java.util.UUID;

public class Model_Transportadora {
    private final UUID id = UUID.randomUUID();
    private String razaoSocial;
    private String cnpj;
    private String endereco;

    public Model_Transportadora(String razaoSocial, String cnpj, String endereco){
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public UUID getId() {
        return id;
    }
    
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
}

