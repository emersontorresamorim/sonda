package teste.marte.sonda.exception;

public class MovimentoSondaInvalidoExpcetion extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public MovimentoSondaInvalidoExpcetion(String mensagem) {
		super(mensagem);
	}
}
