package teste.marte.sonda.exception;

import java.io.Serializable;
import java.util.Map;

public class ErrorResult implements Serializable {

	private static final long serialVersionUID = -2235276055736236160L;

	private final Map<String, String> errors;

	public ErrorResult(Map<String, String> errors) {
		this.errors = errors;
	}

	public Map<String, String> getErrors() {
		return errors;
	}
}
