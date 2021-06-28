package com.teste.meals.action.prato;

import java.util.List;

import com.teste.meals.model.Prato;
import com.teste.meals.model.PratoList;

import org.springframework.web.client.RestTemplate;

/**
 * Classe de ação para visualização de prato
 *
 * @author Andre Silva
 * @version 1.0
 * @since 2021-06-27
 */
public class VerPratoAction {

    final String urlApiShow = "https://www.themealdb.com/api/json/v1/1/lookup.php?i=";

    /**
     * Executa tarefa única da classe
     * 
     * @access public
     * @param Integer idPrato o identificador do prato (meal)
     * @return Prato Retorna dados do prato solicitado
     */
    public Prato execute(Integer idPrato) {

        RestTemplate restTemplate = new RestTemplate();
        PratoList resposta = restTemplate.getForObject(urlApiShow + idPrato, PratoList.class);

        List<Prato> pratos = resposta.getMeals();

        return pratos.get(0);

    }
    
}
