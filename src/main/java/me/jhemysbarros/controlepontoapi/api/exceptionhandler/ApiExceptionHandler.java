package me.jhemysbarros.controlepontoapi.api.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import me.jhemysbarros.controlepontoapi.domain.exception.FimDeSemanaNaoPermitidoException;
import me.jhemysbarros.controlepontoapi.domain.exception.HorarioDeAlmocoObrigatorioException;
import me.jhemysbarros.controlepontoapi.domain.exception.HorarioJaRegistradoException;
import me.jhemysbarros.controlepontoapi.domain.exception.LimiteDeRegistrosPorDiaExcedidoException;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(FimDeSemanaNaoPermitidoException.class)
	public ResponseEntity<?> handleFimDeSemanaNaoPermitidoException(FimDeSemanaNaoPermitidoException ex) {
		ApiError apiError = new ApiError();
		apiError.setDataHora(LocalDateTime.now());
		apiError.setMensagem(ex.getMessage());

		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(apiError);
	}

	@ExceptionHandler(HorarioDeAlmocoObrigatorioException.class)
	public ResponseEntity<?> handleHorarioDeAlmocoObrigatorioException(HorarioDeAlmocoObrigatorioException ex) {
		ApiError apiError = new ApiError();
		apiError.setDataHora(LocalDateTime.now());
		apiError.setMensagem(ex.getMessage());

		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(apiError);
	}

	@ExceptionHandler(HorarioJaRegistradoException.class)
	public ResponseEntity<?> handleHorarioJaRegistradoException(HorarioJaRegistradoException ex) {
		ApiError apiError = new ApiError();
		apiError.setDataHora(LocalDateTime.now());
		apiError.setMensagem(ex.getMessage());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(apiError);
	}

	@ExceptionHandler(LimiteDeRegistrosPorDiaExcedidoException.class)
	public ResponseEntity<?> handleLimiteDeRegistrosPorDiaExcedidoException(LimiteDeRegistrosPorDiaExcedidoException ex) {
		ApiError apiError = new ApiError();
		apiError.setDataHora(LocalDateTime.now());
		apiError.setMensagem(ex.getMessage());

		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(apiError);
	}
}