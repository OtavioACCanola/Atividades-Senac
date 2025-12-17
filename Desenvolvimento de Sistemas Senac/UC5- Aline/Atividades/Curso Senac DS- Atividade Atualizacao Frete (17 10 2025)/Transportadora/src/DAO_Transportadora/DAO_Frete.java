package DAO_Transportadora;

import model_Transportadora.Model_Frete; // Importa a classe Frete do pacote model
import java.util.*; // Importa utilitários como List, ArrayList
import java.util.stream.Collectors; // Importa Collectors para uso com Stream (Tipo um SELECT no Java) API
import java.time.*; // Importa classes para trabalhar com datas (LocalDate, LocalDateTime, etc.)

public class DAO_Frete { // Classe responsável pelo gerenciamento dos objetos Frete em memória
    
    // Lista que armazena todos os fretes cadastrados (Tipo uma TABLE do Banco de Dados
    private final List<Model_Frete> lista_Frete = new ArrayList<>();
    
    // Método para salvar (adicionar) um frete na lista (Tipo um INSERT do Banco de Dados)
    public void salvar_Frete(Model_Frete frete){
        lista_Frete.add(frete);
    }    
    
    // Método que retorna todos os fretes cadastrados, criando uma nova lista a partir da original para evitar modificações externas indevidas
    public List<Model_Frete> listar_Frete(){
        return new ArrayList<>(lista_Frete);
    }
    
    // Método que busca fretes dentro de um intervalo de datas(período), simulando um SELECT
    /* Parâmetros:
     - ini: data inicial
     - fim: data final 
    */
    
    public List<Model_Frete> findByPeriod(LocalDate ini, LocalDate fim){
        return lista_Frete.stream() // Cria um fluxo (stream) da lista de fretes
               .filter(frete -> { // Aplica um filtro para selecionar apenas os fretes no período desejado
                   var d = frete.getDataHora().toLocalDate(); // Converte a data/hora do frete para apenas a data
                   return !d.isBefore(ini) && !d.isAfter(fim); // Retorna true se a data do frete estiver entre ini e fim (inclusive)
               })
               .collect(Collectors.toList()); // Coleta e retorna os fretes filtrados em uma nova lista
    }
}
