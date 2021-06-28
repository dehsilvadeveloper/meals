package com.teste.meals.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * Classe de controle da entidade 'país' (country)
 *
 * @author Andre Silva
 * @version 1.0
 * @since 2021-06-27
 */

@Controller
public class PaisController {

    final String urlApiCountries = "https://restcountries.eu/rest/v2/all";

    /**
     * Método responsável pela rota "/paises".
     * Retorna o JSON puro da requisição a API de países.
     * 
     * @verb GET
     * @return List<Object> Retorna lista de países
     */
    @RequestMapping(value = "/paises", method = RequestMethod.GET)
    @ResponseBody
    public List<Object> index() {

        RestTemplate restTemplate = new RestTemplate();
        Object[] lista = restTemplate.getForObject(urlApiCountries, Object[].class);

        return Arrays.asList(lista);

    }
    
}
