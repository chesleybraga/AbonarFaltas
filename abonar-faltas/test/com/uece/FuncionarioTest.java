package com.uece;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    @Test
    void getNome() {
        Funcionario func = new Funcionario("Carlos");
        assertEquals("Carlos", func.getNome());
    }
}