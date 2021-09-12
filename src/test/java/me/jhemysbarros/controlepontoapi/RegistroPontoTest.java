package me.jhemysbarros.controlepontoapi;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import me.jhemysbarros.controlepontoapi.domain.model.Momento;
import me.jhemysbarros.controlepontoapi.domain.service.MomentoService;

@SpringBootTest
public class RegistroPontoTest {

    @Autowired
    private MomentoService momentoService;

    @Test
    void testarRegistroPontoComSucesso() {
        // Cenério
        Momento momento = new Momento();
        momento.setDataHora(LocalDateTime.of(2021, 9, 13, 8, 00, 00));

        // Ação
        momentoService.baterPonto(momento);

        // Verificação
        assertThrows(RuntimeException.class, () -> momentoService.baterPonto(momento));
    }
}