package com.teste.meals.controller;

import java.util.List;

import com.teste.meals.action.prato.ListarPratosAction;
import com.teste.meals.action.prato.VerPratoAction;
import com.teste.meals.model.Prato;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * Classe de controle da entidade 'prato' (meal)
 *
 * @author Andre Silva
 * @version 1.0
 * @since 2021-06-27
 */

@Controller
public class PratoController {

    private ListarPratosAction listarPratosAction;
    private VerPratoAction verPratoAction;

    /**
     * Método construtor
     * 
     * @return void
     */
    public PratoController() {

        this.listarPratosAction = new ListarPratosAction();
        this.verPratoAction = new VerPratoAction();

    }



    /**
     * Método responsável pela rota "/"
     * 
     * @verb GET
     * @return String Retorna redirecionamento para outro método
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String base() {
        return "redirect:/pratos";
    }



    /**
     * Método responsável pela rota "/pratos"
     * Exibe uma página com lista de pratos (meals)
     * 
     * @verb GET
     * @param Model model
     * @return String Retorna página html
     */
    @RequestMapping(value = "/pratos", method = RequestMethod.GET)
    public String index(Model model) {

        List<Prato> pratos = this.listarPratosAction.execute();

        model.addAttribute("pratos", pratos);

        return "pratos/index";

    }



    /**
     * Método responsável pela rota "/pratos-json"
     * Retorna o JSON puro da requisição a API MEALS DB
     * 
     * @verb GET
     * @return String Retorna STRING JSON da resposta da requisição
     */
    @RequestMapping(value = "/pratos-json", method = RequestMethod.GET)
    @ResponseBody
    public String indexJson() {

        RestTemplate restTemplate = new RestTemplate();
        String lista = restTemplate.getForObject("https://www.themealdb.com/api/json/v1/1/search.php?s=", String.class);

        return lista;

    }



    /**
     * Método responsável pela rota "/pratos/{pratoId}"
     * Exibe uma página com dados de um prato (meal) específico
     * 
     * @verb GET
     * @param Integer idPrato o identificador do prato (meal)
     * @param Model model
     * @return String Retorna página html
     */
    @RequestMapping(value = "/pratos/{pratoId}", method = RequestMethod.GET)
    public String show(@PathVariable("pratoId") Integer idPrato, Model model) {

        Prato prato = this.verPratoAction.execute(idPrato);

        model.addAttribute("prato", prato);

        return "pratos/show";

    }
    
}
