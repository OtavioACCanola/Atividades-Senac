/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config_Transportadora;

import br.com.fretesmvc.dao.*;
import br.com.fretesmvc.controller.*;
import br.com.fretesmvc.strategy.*;

public class config_AppContext {


public class AppContext {

    private final TransportadoraDAO transportadoraDAO = new TransportadoraDAO();
    private final VeiculoDAO veiculoDAO = new VeiculoDAO();
    private final MotoristaDAO motoristaDAO = new MotoristaDAO();
    private final RotaDAO rotaDAO = new RotaDAO();
    private final FreteDAO freteDAO = new FreteDAO();
    private final MotoristaVeiculoDAO motoristaVeiculoDAO = new MotoristaVeiculoDAO();

    // Estratégias (padrão Strategy)
    private final CalculadoraFrete calculadoraFrete = new CalculadoraFretePorTipo();

    // Controllers
    private final TransportadoraController transportadoraController = new TransportadoraController(transportadoraDAO);
    private final VeiculoController veiculoController = new VeiculoController(veiculoDAO, transportadoraDAO);
    private final MotoristaController motoristaController = new MotoristaController(motoristaDAO, transportadoraDAO);
    private final RotaController rotaController = new RotaController(rotaDAO);
    private final VinculoController vinculoController = new VinculoController(motoristaVeiculoDAO, motoristaDAO, veiculoDAO, transportadoraDAO);
    private final FreteController freteController = new FreteController(freteDAO, veiculoDAO, rotaDAO, calculadoraFrete);
    private final RelatorioController relatorioController = new RelatorioController(freteDAO, transportadoraDAO, motoristaDAO, veiculoDAO);

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

}
