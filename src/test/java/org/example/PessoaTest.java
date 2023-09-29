package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PessoaTest {

    @Test
    public void testPessoaValida() {
        Pessoa pessoa = new Pessoa(1, "Ana");
        assertTrue(pessoa.valido());
    }

    @Test
    public void testIdNegativo() {
        Pessoa pessoa = new Pessoa(-1, "Ana");
        assertFalse(pessoa.valido());
    }

    @Test
    public void testNomeVazio() {
        Pessoa pessoa = new Pessoa(1, "");
        assertFalse(pessoa.valido());
    }

    @Test
    public void testIdZeroNomeVazio() {
        Pessoa pessoa = new Pessoa(0, "");
        assertFalse(pessoa.valido());
    }

}