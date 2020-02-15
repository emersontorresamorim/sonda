package teste.marte.sonda.exception;

public class ComandoInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 3058935355754414902L;

	public ComandoInvalidoException(String mensagem) {
		super(mensagem);
	}
}
