/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config_Transportadora;

import DAO_Transportadora.*;
import model_Transportadora.*;
import strategy_Transportadora.*;
import controller_Transportadora.*;

public class config_Transportadora {
    
    private final DAO_Transportadora dao_transportadora = new DAO_Transportadora();
    private final DAO_Veiculo dao_veiculo = new DAO_Veiculo();
    private final DAO_Motorista dao_motorista = new DAO_Motorista();
    private final DAO_Rota dao_rota = new DAO_Rota();
    private final DAO_Frete dao_frete = new DAO_Frete();
    private final DAO_MotoristaVeiculo dao_motoristaveiculolink = new DAO_MotoristaVeiculo();

// Estratégias
    private final Strategy_CalculadoraFreteTipo calculadoraFrete = new Strategy_CalculadoraFreteTipo(); 


// Controllers
    private final TransportadoraController controller_transportadora = new TransportadoraController(dao_transportadora);
    private final VeiculoController controller_veiculo = new VeiculoController(dao_veiculo, dao_transportadora);
    private final MotoristaController controller_motorista = new MotoristaController(dao_motorista, dao_transportadora);
    private final RotaController controller_rota = new RotaController(dao_rota);
    private final VinculoController controller_vinculo = new VinculoController(dao_motoristaveiculolink, dao_motorista, dao_veiculo, dao_transportadora);
    private final FreteController controller_frete = new FreteController(dao_frete, dao_veiculo, dao_rota, calculadoraFrete);
    private final RelatorioController controller_relatorio = new RelatorioController(dao_frete, dao_motorista, dao_veiculo, dao_transportadora);

    public TransportadoraController getController_transportadora() {
        return controller_transportadora;
    }

    public VeiculoController getController_veiculo() {
        return controller_veiculo;
    }

    public MotoristaController getController_motorista() {
        return controller_motorista;
    }

    public RotaController getController_rota() {
        return controller_rota;
    }

    public VinculoController getController_vinculo() {
        return controller_vinculo;
    }

    public FreteController getController_frete() {
        return controller_frete;
    }

    public RelatorioController getController_relatorio() {
        return controller_relatorio;
    }

    
}