package com.speedware.gestaovendas.exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GestaoVendasExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		List<Erro> erros = gerarListaDeErros(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<Object> handlerEmptyResultDataAccessException(EmptyResultDataAccessException ex,
			WebRequest request) {

		String msgUsuario = "Recurso não encontrado.";
		String msgDesenvolvedor = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(msgUsuario, msgDesenvolvedor));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);

	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex,
			WebRequest request) {

		String msgUsuario = "Recurso não encontrado.";
		String msgDesenvolvedor = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(msgUsuario, msgDesenvolvedor));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);

	}

	@ExceptionHandler(RegraNegocioExeption.class)
	public ResponseEntity<Object> handleRegraNegocioExeption(RegraNegocioExeption ex, WebRequest request) {

		String msgUsuario = ex.getMessage();
		String msgDesenvolvedor = ex.getMessage();
		List<Erro> erros = Arrays.asList(new Erro(msgUsuario, msgDesenvolvedor));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);

	}

	private List<Erro> gerarListaDeErros(BindingResult bindingResult) {
		List<Erro> erros = new ArrayList<Erro>();
		bindingResult.getFieldErrors().forEach(fieldError -> {

			String msgUsuario = tratarMensagemDeErroParaUsuario(fieldError);
			String msgDesenvolvedor = fieldError.toString();
			erros.add(new Erro(msgUsuario, msgDesenvolvedor));
		});

		return erros;

	}

	private String tratarMensagemDeErroParaUsuario(FieldError fieldError) {
		if (fieldError.getCode().equals("NotBlank")) {
			return fieldError.getDefaultMessage().concat(" é obrigatório.");
		}

		if (fieldError.getCode().equals("NotNull")) {
			return fieldError.getDefaultMessage().concat(" é obrigatório.");
		}

		if (fieldError.getCode().equals("Length")) {

			return fieldError.getDefaultMessage().concat(String.format("O comprimento deve ser entre %s e %s 50",
					fieldError.getArguments()[2], fieldError.getArguments()[1]));
		}

		if (fieldError.getCode().equals("Pattern")) {

			return fieldError.getDefaultMessage().concat(" formato inválido");

		}
		if (fieldError.getCode().equals("Min")) {

			return fieldError.getDefaultMessage().concat(String.format(" deve ser maior ou igual a %s e %s 50",
					fieldError.getArguments()[2], fieldError.getArguments()[1]));

		}
		return fieldError.toString();

	}

}
