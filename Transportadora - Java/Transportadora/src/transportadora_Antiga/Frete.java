package transportadora_Antiga;
import java.util.Date;
import java.util.Calendar;

public class Frete {
    private Cliente cliente;
    private Motorista motorista;
    private Veiculo veiculo;
    private Rota rota;
    private Date data;
    private double valor;
    private String status;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Frete (Cliente cliente, Motorista motorista, Veiculo veiculo, Rota rota){
        this.cliente = cliente;
        this.motorista = motorista;
        this.rota = rota;
        this.veiculo = veiculo;
    }
    
    public void concluirFrete(float kmrodado){
        double frete = valor * kmrodado;
        System.out.println("Valor do frete: R$"+frete);
    }
    
    public void cadastrarMotorista(){
        
    }
    
    
}
