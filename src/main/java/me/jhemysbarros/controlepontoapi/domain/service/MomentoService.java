package me.jhemysbarros.controlepontoapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.jhemysbarros.controlepontoapi.domain.model.Momento;
import me.jhemysbarros.controlepontoapi.domain.repository.MomentoRepository;
import me.jhemysbarros.controlepontoapi.domain.validator.MomentoValidator;

@Service
public class MomentoService {

    @Autowired
    private MomentoRepository momentoRepository;

    @Autowired
    private MomentoValidator momentoValidator;

    public Momento baterPonto(Momento momento) {
        momentoValidator.validaMomento(momento);

        return momentoRepository.save(momento);
    }    
}