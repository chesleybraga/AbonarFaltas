package com.uece;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolicitacaoTest {

    @Test
    void solicitar() {
        Funcionario entregador = new Funcionario("José Pereira da Silva");
        Solicitacao solicitacao = new Solicitacao(entregador);
        //testar se o objeto funcionario retorna igual
        assertEquals(entregador , solicitacao.getFuncionario());
    }

    @Test
    void aprovar() {
    }

    @Test
    void recusar() {
    }

    @Test
    void retornar() {
    }
}