package me.jhemysbarros.controlepontoapi.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class HorarioJaRegistradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public HorarioJaRegistradoException() {
        super("Horários já registrado");
    }
}