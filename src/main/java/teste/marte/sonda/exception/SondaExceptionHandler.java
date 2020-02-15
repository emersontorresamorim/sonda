package teste.marte.sonda.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SondaExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(SondaExceptionHandler.class);
	private static final String BAD_REQUEST = "Bad request: {}";
	private static final String SONDA_APPLICATION_ERROR = "Sonda application error";

	private ErrorResult getErrorResult(Exception e) {
		Map<String, String> errors = new HashMap<String, String>();
		errors.put(SONDA_APPLICATION_ERROR, e.getMessage());
		return new ErrorResult(errors);
	}

	@ExceptionHandler(PlanaltoInvalidoException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResult handlePlanaltoInvalidoException(PlanaltoInvalidoException e) {
		LOGGER.error(BAD_REQUEST, e);
		return getErrorResult(e);
	}

	@ExceptionHandler(SondaInvalidaException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResult handleSondaInvalidaException(SondaInvalidaException e) {
		LOGGER.error(BAD_REQUEST, e);
		return getErrorResult(e);
	}

	@ExceptionHandler(ComandoInvalidoException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResult handleComandoInvalidoException(ComandoInvalidoException e) {
		LOGGER.error(BAD_REQUEST, e);
		return getErrorResult(e);
	}

	@ExceptionHandler(MovimentoSondaInvalidoExpcetion.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResult handleMovimentoSondaInvalidoExpcetion(MovimentoSondaInvalidoExpcetion e) {
		LOGGER.error(BAD_REQUEST, e);
		return getErrorResult(e);
	}
}
