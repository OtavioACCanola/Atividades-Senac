package Config_Transportadora;

import DAO_Transportadora.*;
import controller_Transportadora.*;
import strategy_Transportadora.*;

public class AppContext {

    private final DAO_Transportadora transportadoraDAO = new DAO_Transportadora();
    private final DAO_Veiculo veiculoDAO = new DAO_Veiculo();
    private final DAO_Motorista motoristaDAO = new DAO_Motorista();
    private final DAO_Rota rotaDAO = new DAO_Rota();
    private final DAO_Frete freteDAO = new DAO_Frete();
    private final DAO_MotoristaVeiculo motoristaVeiculoDAO = new DAO_MotoristaVeiculo();

    // Estratégias (padrão Strategy)
    private final Strategy_CalculadoraFrete calculadoraFrete = new Strategy_CalculadoraFreteTipo();

    // Controllers
    private final TransportadoraController transportadoraController = new TransportadoraController(transportadoraDAO);
    private final VeiculoController veiculoController = new VeiculoController(veiculoDAO, transportadoraDAO);
    private final MotoristaController motoristaController = new MotoristaController(motoristaDAO, transportadoraDAO);
    private final RotaController rotaController = new RotaController(rotaDAO);
    private final VinculoController vinculoController = new VinculoController(motoristaVeiculoDAO, motoristaDAO, veiculoDAO, transportadoraDAO);
    private final FreteController freteController = new FreteController(freteDAO, veiculoDAO, rotaDAO, calculadoraFrete);
    private final RelatorioController relatorioController = new RelatorioController(freteDAO, motoristaDAO, veiculoDAO, transportadoraDAO);

    public TransportadoraController getTransportadoraController() {
        return transportadoraController;
    }

    public VeiculoController getVeiculoController() {
        return veiculoController;
    }

    public MotoristaController getMotoristaController() {
        return motoristaController;
    }

    public RotaController getRotaController() {
        return rotaController;
    }

    public VinculoController getVinculoController() {
        return vinculoController;
    }

    public FreteController getFreteController() {
        return freteController;
    }

    public RelatorioController getRelatorioController() {
        return relatorioController;
    }
}
