package teste.marte.sonda.exception;

public class SondaInvalidaException extends RuntimeException {

	private static final long serialVersionUID = -5909094410431493448L;
	
	public SondaInvalidaException(String mensagem) {
		super(mensagem);
	}
}
