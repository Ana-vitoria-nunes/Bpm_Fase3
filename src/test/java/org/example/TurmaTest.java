package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TurmaTest {
    @InjectMocks
    private Turma turma;

    @Test
    public void testAdicionarPessoaValida() throws Exception {
        Pessoa pessoaValida = new Pessoa(1, "Ana");
        turma.adicionarPessoa(pessoaValida);
        assertTrue(turma.getPessoas().contains(pessoaValida));
    }

    @Test
    public void testAdicionarPessoaInvalida() throws Exception {
        Pessoa pessoaInvalida = new Pessoa(0,"Ana");

        assertFalse(pessoaInvalida.valido());

        var response = Assertions.assertThrows(Exception.class, () -> turma.adicionarPessoa(pessoaInvalida));
        assertEquals("Objeto pessoa inválido", response.getMessage());
    }

    @Test
    public void testAdicionarPessoaExistente() throws Exception {
        Pessoa pessoaExistente = new Pessoa(1, "ana");
        turma.getPessoas().add(pessoaExistente);

        var response = Assertions.assertThrows(Exception.class, () -> turma.adicionarPessoa(pessoaExistente));
        assertEquals("Objeto pessoa já está atribuido a turma", response.getMessage());

    }
    @Test
    public void deveRetornarSucessoRemoverTodasPessoa(){
        this.turma.removerTodasPessoas();
        assert this.turma.getPessoas().size() == 0;
    }


}