package me.jhemysbarros.controlepontoapi.domain.validator;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.jhemysbarros.controlepontoapi.domain.exception.FimDeSemanaNaoPermitidoException;
import me.jhemysbarros.controlepontoapi.domain.exception.HorarioDeAlmocoObrigatorioException;
import me.jhemysbarros.controlepontoapi.domain.exception.HorarioJaRegistradoException;
import me.jhemysbarros.controlepontoapi.domain.exception.LimiteDeRegistrosPorDiaExcedidoException;
import me.jhemysbarros.controlepontoapi.domain.model.Momento;
import me.jhemysbarros.controlepontoapi.domain.repository.MomentoRepository;

@Component
public class MomentoValidator {

    @Autowired
    private MomentoRepository momentoRepository;

    public void validaMomento(Momento momento) {
        verificaData(momento.getDataHora());
        verificaRegistroPonto(momento.getDataHora());
        horarioJaRegistrado(momento.getDataHora());
    }

    private void verificaData(LocalDateTime dataHora) {

        if (dataHora.getDayOfWeek().equals(DayOfWeek.SATURDAY) || dataHora.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            throw new FimDeSemanaNaoPermitidoException();
        }
    }

    private void verificaRegistroPonto(LocalDateTime dataHora) {
        List<Momento> momentos = momentoRepository.findByData(dataHora.toLocalDate());

        if (momentos.size() == 4) {
            throw new LimiteDeRegistrosPorDiaExcedidoException();
        }

        if (momentos.size() == 2) {
            Momento ultimoRegistro = momentos.get(1);

            Duration periodo = Duration.between(ultimoRegistro.getDataHora(), dataHora);

            if (periodo.toHours() < 1) {
                throw new HorarioDeAlmocoObrigatorioException();
            }
        }
    }

    private void horarioJaRegistrado(LocalDateTime dataHora) {
        Optional<Momento> momento = momentoRepository.findOneByDataHora(dataHora);

        if (momento.isPresent()) {
            throw new HorarioJaRegistradoException();
        }
    }
}