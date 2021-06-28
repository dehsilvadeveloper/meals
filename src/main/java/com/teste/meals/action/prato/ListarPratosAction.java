package com.teste.meals.action.prato;

import java.util.List;

import com.teste.meals.model.Prato;
import com.teste.meals.model.PratoList;

import org.springframework.web.client.RestTemplate;

/**
 * Classe de ação para visualização de lista de pratos
 *
 * @author Andre Silva
 * @version 1.0
 * @since 2021-06-27
 */
public class ListarPratosAction {

    final String urlApiSearch = "https://www.themealdb.com/api/json/v1/1/search.php?s=";

    /**
     * Executa tarefa única da classe
     * 
     * @access public
     * @return List<Prato> Retorna lista de pratos
     */
    public List<Prato> execute() {

        RestTemplate restTemplate = new RestTemplate();
        PratoList resposta = restTemplate.getForObject(urlApiSearch, PratoList.class);
        
        List<Prato> pratos = resposta.getMeals();

        return pratos;

    }
    
}
