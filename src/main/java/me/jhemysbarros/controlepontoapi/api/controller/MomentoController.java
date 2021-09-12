package me.jhemysbarros.controlepontoapi.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.jhemysbarros.controlepontoapi.domain.model.Momento;
import me.jhemysbarros.controlepontoapi.domain.service.MomentoService;

@Api(tags = "Bater ponto")
@RestController
@RequestMapping("/batidas")
public class MomentoController {

    @Autowired
    private MomentoService momentoService;

    @ApiOperation(value = "Registrar um horário da jornada diária de trabalho")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Momento baterPonto(@RequestBody @Valid Momento momento) {
        return momentoService.baterPonto(momento);
    }
}