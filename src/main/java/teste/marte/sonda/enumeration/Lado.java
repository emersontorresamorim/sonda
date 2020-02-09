package teste.marte.sonda.enumeration;

import java.util.Optional;

public enum Lado {

	ESQUERDO("E"), 
	DIREITO("D");

	private String sigla;

	private Lado(String sigla) {
		this.sigla = sigla;
	}

	public String getSigla() {
		return sigla;
	}

	public static Optional<Lado> getLado(String sigla) {
		Lado lado = null;

		if ("E".equals(sigla)) {
			lado = Lado.ESQUERDO;
		} else if ("D".equals(sigla)) {
			lado = Lado.DIREITO;
		}

		return Optional.ofNullable(lado);
	}
}
