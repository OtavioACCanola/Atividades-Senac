// Vive sem Transportadora 

package model_Transportadora;

import java.util.UUID;

public class Motorista {
    private UUID id;
    private UUID transportadoraId;
    private String nome;
    private String cpf;
    private String cnh;
    private String telefone;

    public Motorista(UUID transportadoraId, String nome, String cpf, String cnh, String telefone){
        this.transportadoraId = transportadoraId;
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
        this.telefone = telefone;
    }
    
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
