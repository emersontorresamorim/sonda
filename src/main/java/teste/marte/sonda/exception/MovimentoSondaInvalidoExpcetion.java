package teste.marte.sonda.exception;

public class MovimentoSondaInvalidoExpcetion extends RuntimeException {

	private static final long serialVersionUID = 2508873721569389024L;

	public MovimentoSondaInvalidoExpcetion(String mensagem) {
		super(mensagem);
	}
}
