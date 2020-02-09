package teste.marte.sonda.exception;

public class LimitePlanaltoInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public LimitePlanaltoInvalidoException(String mensagem) {
		super(mensagem);
	}
}
