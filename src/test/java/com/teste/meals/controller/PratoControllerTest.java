package com.teste.meals.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PratoController.class)
public class PratoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
	public void obterListaDePratos() throws Exception {

        RequestBuilder requisicao = MockMvcRequestBuilders.get("/pratos");
        MvcResult resultado = mvc.perform(requisicao).andReturn();

        assertEquals(200, resultado.getResponse().getStatus());

    }

    @Test
    public void impossivelObterListaDePratosComUrlInexistente() throws Exception {

        RequestBuilder requisicao = MockMvcRequestBuilders.get("/pratos-feitos");
        MvcResult resultado = mvc.perform(requisicao).andReturn();

        assertEquals(404, resultado.getResponse().getStatus());

    }
    
}
